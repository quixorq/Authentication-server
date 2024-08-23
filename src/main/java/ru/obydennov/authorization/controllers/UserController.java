package ru.obydennov.authorization.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.obydennov.authorization.model.dto.UserDtoDetailed;
import ru.obydennov.authorization.model.dto.UserDto;
import ru.obydennov.authorization.exceptions.UserNotFoundInDatabaseException;
import ru.obydennov.authorization.model.dto.UserDtoWithRoleNames;
import ru.obydennov.authorization.services.UserService;
import ru.obydennov.authorization.utils.dto.UserDtoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с пользователями системы авторизации
 *
 * @author obydennov
 * @since 08.05.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Api(tags = "Контроллер для работы с пользователями системы авторизации")
final public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @ApiOperation("Получение всех пользователей")
    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userDtoMapper::convertUserToUserDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @ApiOperation("Получение пользователя по ID")
    @GetMapping("/user")
    public UserDtoDetailed getUserById(@RequestParam long id) throws UserNotFoundInDatabaseException {
        return userDtoMapper.detailedUserDto(userService.getUserById(id));
    }

    @ApiOperation("Создание нового пользователя")
    @PostMapping("/user")
    public ResponseEntity createNewUser(@RequestBody UserDtoWithRoleNames userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.status(201).build();
    }

    @ApiOperation("Обновление пользователя")
    @PutMapping("/user")
    public ResponseEntity updateUser(@RequestBody UserDtoWithRoleNames userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }
}
