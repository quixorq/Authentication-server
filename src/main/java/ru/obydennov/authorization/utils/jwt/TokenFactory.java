package ru.obydennov.authorization.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.obydennov.authorization.config.JwtConfig;
import ru.obydennov.authorization.model.token.JwtToken;
import ru.obydennov.authorization.model.token.RawAccessJwtToken;
import ru.obydennov.authorization.model.token.RefreshJwtToken;
import ru.obydennov.authorization.model.token.UserContext;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Фабрика для генерации JWT токен (access и refresh)
 *
 * Тут идет некотороен дублирование кода. Но после
 * переписывания через общий метод, код стал значительно
 * менее читаемым. Можно реализовать через
 * абстрактную фабрику.
 *
 * @author obydennov
 * @since 07.05.2022
 */
@Service
@AllArgsConstructor
public class TokenFactory {
    private final JwtConfig jwtConfig;
    private final int MILLISECONDS_COEFFICIENT = 1000;
    private final String AUTHORITIES = "authorities";

    public JwtToken createAccessJwtToken(UserContext userContext) {
        val subject = userContext.getLogin();
        checkUsernameForAbsence(subject);

        val now            = System.currentTimeMillis();
        val issueDate      = new Date(now);
        val expirationDate = new Date(now + jwtConfig.getRawTokenExpiration() * MILLISECONDS_COEFFICIENT);
        val claims         = getClaims(subject);

        val token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(expirationDate)
                .setClaims(claims)
                .claim(AUTHORITIES, userContext.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .compact();

        return new RawAccessJwtToken(token);
    }

    public JwtToken createRefreshToken(UserContext userContext) {
        val subject = userContext.getLogin();
        checkUsernameForAbsence(subject);

        val now                = System.currentTimeMillis();
        val issueDate          = new Date(now);
        val expirationDate     = new Date(now + jwtConfig.getRefreshTokenExpiration() * MILLISECONDS_COEFFICIENT);
        val claims             = getClaims(subject);
        val grantedAuthorities = userContext.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        String token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(expirationDate)
                .setClaims(claims)
                .claim(AUTHORITIES, grantedAuthorities)
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .setId(UUID.randomUUID().toString())
                .compact();

        return new RefreshJwtToken(token);
    }

    private void checkUsernameForAbsence(String username) {
        if (StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("Cannot create JWT Token without username");
        }
    }

    private Claims getClaims(String subject) {
        return Jwts.claims().setSubject(subject);
    }
}
