package ru.obydennov.authorization.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Объект Exception при попытке создания пользователя
 * с существующим именем.
 *
 * @author obydennov
 * @since 11.06.2022
 */
public class UsernameIsAlreadyExists extends AuthenticationException {
    public UsernameIsAlreadyExists(String msg) {
        super(msg);
    }
}
