package ru.obydennov.authorization.utils.dto;

import ru.obydennov.authorization.model.dto.UserDtoDetailed;
import ru.obydennov.authorization.model.dto.UserDto;
import ru.obydennov.authorization.model.dto.UserDtoWithRoleNames;
import ru.obydennov.authorization.model.dto.UserIdAndFioDto;
import ru.obydennov.authorization.model.entity.User;

/**
 * Мэппуер DTO для пользователей
 *
 * @author obydennov
 * @since 13.05.2022
 */
public interface UserDtoMapper {
    UserDto convertUserToUserDto(User user);
    UserIdAndFioDto convertToIdAndFioDto(User user);
    UserDtoDetailed detailedUserDto(User user);
    User convertUserDtoWithRoleNamesToUser(UserDtoWithRoleNames userDto);
}
