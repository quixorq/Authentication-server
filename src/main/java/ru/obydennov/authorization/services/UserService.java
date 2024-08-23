package ru.obydennov.authorization.services;

import ru.obydennov.authorization.exceptions.UserCredentialsAreNotValid;
import ru.obydennov.authorization.exceptions.UserNotFoundInDatabaseException;
import ru.obydennov.authorization.model.dto.UserDtoWithRoleNames;
import ru.obydennov.authorization.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Сервис получения информации по пользователю
 * для аутентификации
 *
 * @author obydennov
 * @since 07.05.2022
 */
public interface UserService {
    Optional<User> getUserByLogin(String login);
    User getAccessInfo(String login, String pwd) throws UserCredentialsAreNotValid;
    boolean checkUserCredentials(User user, String pwd) throws UserCredentialsAreNotValid;
    List<User> getAllUsers();
    User getUserById(long id) throws UserNotFoundInDatabaseException;
    boolean checkUserExistence(String username);
    /**
     * Сохраняет пользователя через стратегию Hibernat'a,
     * динамически определяя операцию (save или update) через
     * наличие id в DTO
     */
    void saveUser(UserDtoWithRoleNames userDto);
}
