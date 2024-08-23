package ru.obydennov.authorization.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Объект Exception для отслеживания исключения
 * при неверном Http запросе на попытку аутентификации
 *
 * @author  obydennov
 * @since 07.05.2022
 */
final public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
