package ru.obydennov.authorization.utils.dto.Impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.obydennov.authorization.model.dto.RoleDto;
import ru.obydennov.authorization.model.dto.RoleIdAndNameDto;
import ru.obydennov.authorization.model.entity.Role;
import ru.obydennov.authorization.utils.dto.RoleDtoMapper;

@AllArgsConstructor
@Service
final public class RoleDtoMapperImpl implements RoleDtoMapper {
    private final ModelMapper modelMapper;

    public RoleDto roleDto(Role role) {
        return modelMapper.map(role, RoleDto.class);
    }

    public RoleIdAndNameDto roleIdAndNameDto(Role role) {
        return modelMapper.map(role, RoleIdAndNameDto.class);
    }
}
