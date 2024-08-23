package ru.obydennov.authorization.utils.dto;

import ru.obydennov.authorization.model.dto.RoleDto;
import ru.obydennov.authorization.model.dto.RoleIdAndNameDto;
import ru.obydennov.authorization.model.entity.Role;

/**
 * Мэппер DTO для ролей
 *
 * @author obydennov
 * @since 13.05.2022
 */
public interface RoleDtoMapper {
    RoleDto roleDto(Role role);
    RoleIdAndNameDto roleIdAndNameDto(Role role);
}
