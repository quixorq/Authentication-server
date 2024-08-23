package ru.obydennov.authorization.exceptions;

/**
 * Исключение при ненахождении пользователя в базе данных
 *
 * @author obydennov
 * @since 13.05.2022
 */
final public class UserNotFoundInDatabaseException extends RuntimeException {
    public UserNotFoundInDatabaseException (String message) {
        super(message);
    }
}
