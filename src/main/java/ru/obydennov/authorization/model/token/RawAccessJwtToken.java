package ru.obydennov.authorization.model.token;


import io.jsonwebtoken.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Необработанное представление токена
 *
 * @author obydennov
 * @since 13.05.2022
 */
@Data
@RequiredArgsConstructor
public class RawAccessJwtToken implements JwtToken {
	private String token;
	private Jws<Claims> claims;

	public RawAccessJwtToken(String token) {
		this.token = token;
	}
}
