package ru.obydennov.authorization.exceptions;

/**
 * Исключение при неверном указании типа фильтра
 * аутентификации в фабричном методе
 *
 * @author obydennov
 * @since 07.06.2022
 */
public class WrongAuthenticationFilterException extends RuntimeException {
    public WrongAuthenticationFilterException (String message) {
        super(message);
    }

}
