package ru.obydennov.authorization.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.obydennov.authorization.exceptions.BlockedUserAuthorizationException;
import ru.obydennov.authorization.exceptions.UserCredentialsAreNotValid;
import ru.obydennov.authorization.exceptions.UserNotFoundInDatabaseException;
import ru.obydennov.authorization.exceptions.UsernameIsAlreadyExists;
import ru.obydennov.authorization.repository.RoleRepository;
import ru.obydennov.authorization.repository.UserRepository;
import ru.obydennov.authorization.model.dto.UserDtoWithRoleNames;
import ru.obydennov.authorization.model.entity.Role;
import ru.obydennov.authorization.model.entity.User;
import ru.obydennov.authorization.services.LoginAttemptService;
import ru.obydennov.authorization.services.UserService;
import ru.obydennov.authorization.utils.IpAddressExtractor;
import ru.obydennov.authorization.utils.dto.UserDtoMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
final public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserDtoMapper userDtoMapper;
    private final LoginAttemptService loginAttemptService;
    private final IpAddressExtractor ipAddressExtractor;

    @Override
    public Optional<User> getUserByLogin(String login) {
        checkIpAddressToBeBlocked();

        return userRepository.findByLogin(login);
    }

    @Override
    public User getAccessInfo(final String login, final String pwd) {
        return this.getUserByLogin(login)
                    .filter(u -> checkUserCredentials(u, pwd))
                    .orElseThrow(() -> new UserCredentialsAreNotValid("Credentials are not valid"));
    }

    @Override
    public boolean checkUserCredentials(User user, String pwd) {
        return user.getPassword().equals(pwd);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(long id) throws UserNotFoundInDatabaseException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundInDatabaseException("Wrong ID of user. ID = " + id));
    }

    @Override
    public void saveUser(UserDtoWithRoleNames userDto) {
        if (!checkUserExistence(userDto.getLogin())) {
            // todo добавить хэширование пароля при сохранении
            final List<Role> rolesEntitiesForUser      = Collections.unmodifiableList(roleRepository.findAllRolesByName(userDto.getRoles()));
            final Consumer<User> setRoleEntitiesToUser = u -> u.setRoles(rolesEntitiesForUser);

            Optional.of(userDto)
                    .map(userDtoMapper::convertUserDtoWithRoleNamesToUser)
                    .ifPresent(setRoleEntitiesToUser.andThen(userRepository::save));
        } else throw new UsernameIsAlreadyExists("Username \"" + userDto.getLogin() + "\" is already exists");

    }

    @Override
    public boolean checkUserExistence(String username) {
        return userRepository.checkUsernameExistence(username);
    }

    private void checkIpAddressToBeBlocked() {
        String ip = ipAddressExtractor.getClientIP();

        if (loginAttemptService.isBlocked(ip)) {
            throw new BlockedUserAuthorizationException("This user is blocked by IP");
        }
    }
}

