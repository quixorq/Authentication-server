package ru.obydennov.authorization.model.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.Data;

/**
 * Объект refresh токена
 *
 * @author obydennov
 * @since 22.05.2022
 */
@Data
public class RefreshJwtToken implements JwtToken {
    private String token;
    private Jws<Claims> claims;

    public RefreshJwtToken(String token) {
        this.token = token;
    }

    RefreshJwtToken(Jws<Claims> claims) {
        this.claims = claims;
    }
}
