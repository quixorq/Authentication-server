package ru.obydennov.authorization.exceptions;

import org.springframework.security.core.AuthenticationException;
import ru.obydennov.authorization.model.token.JwtToken;

/**
 * Объект Exception при окончании срока действия токена
 *
 * @author obydennov
 * @since 07.05.2022
 */
final public class JwtExpiredTokenException extends AuthenticationException {
    private JwtToken token;

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
