package ru.obydennov.authorization.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.obydennov.authorization.model.dto.UserIdAndFioDto;
import ru.obydennov.authorization.services.UserService;
import ru.obydennov.authorization.utils.dto.UserDtoMapper;

/**
 * Контроллер для проверки наличия возможности
 * аунтентификации пользователя
 *
 * @author obydennov
 * @since 07.05.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Api(tags = "Контроллер для проверки возможности аутентификации пользователя")
final public class TestAccessController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @ApiOperation("Проверка доступа. Возвращается ФИО и ID при успешной проверке. 403 при невозможности доступа.")
    @GetMapping("/access")
    public UserIdAndFioDto getAccessInformation(@RequestParam String login, @RequestParam String pwd) {
        return userDtoMapper.convertToIdAndFioDto(userService.getAccessInfo(login, pwd));
    }
}
