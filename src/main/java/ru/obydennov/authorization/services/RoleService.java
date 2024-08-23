package ru.obydennov.authorization.services;

import ru.obydennov.authorization.model.entity.Role;

import java.util.List;

/**
 * Сервис для работы с ролями
 *
 * @author obydennov
 * @since 07.05.2022
 */
public interface RoleService {
    List<Role> getAllRoles();
}
