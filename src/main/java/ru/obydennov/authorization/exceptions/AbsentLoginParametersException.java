package ru.obydennov.authorization.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Объект Exception для отслеживания исключения
 * при отсутствии какого либо параметра в объекте Http
 * запроса при попытке аутентификации
 *
 * @author  obydennov
 * @since 07.05.2022
*/
final public class AbsentLoginParametersException extends AuthenticationServiceException {
    public AbsentLoginParametersException(String msg) {
        super(msg);
    }
}
