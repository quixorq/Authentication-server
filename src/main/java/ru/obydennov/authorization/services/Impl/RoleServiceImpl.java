package ru.obydennov.authorization.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.obydennov.authorization.repository.RoleRepository;
import ru.obydennov.authorization.services.RoleService;
import ru.obydennov.authorization.model.entity.Role;

import java.util.List;

@Service
@AllArgsConstructor
final public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

}
