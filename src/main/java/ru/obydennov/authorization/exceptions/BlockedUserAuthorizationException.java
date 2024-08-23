package ru.obydennov.authorization.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Объект Exception для отслеживания исключения
 * при попытке зайти пользователю, который заблокирован по IP
 * адресу
 *
 * @author obydennov
 * @since 27.05.2022
 */
public final class BlockedUserAuthorizationException extends AuthenticationException {
    public BlockedUserAuthorizationException(String message) {
        super(message);
    }
}
