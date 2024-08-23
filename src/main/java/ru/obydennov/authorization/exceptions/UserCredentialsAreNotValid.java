package ru.obydennov.authorization.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Объект Exception при неверных данных
 * аутентификации пользователя
 *
 * @author obydennov
 * @since 07.05.2022
 */
final public class UserCredentialsAreNotValid extends AuthenticationException {
    public UserCredentialsAreNotValid(String msg) {
        super(msg);
    }
}
