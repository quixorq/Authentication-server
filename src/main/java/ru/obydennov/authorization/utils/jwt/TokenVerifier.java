package ru.obydennov.authorization.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * Интерфейс проверки действия токена
 *
 * @author obydennov
 * @since 24.05.2022
 */
public interface TokenVerifier {
    boolean verifyClaims(Jws<Claims> claimsJws);
}
