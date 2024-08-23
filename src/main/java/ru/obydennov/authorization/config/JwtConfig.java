package ru.obydennov.authorization.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Настройки для работы с JWT
 *
 * @author obydennov
 * @since 23.04.2022
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
public class JwtConfig {
    private String uri;
    private String header;
    private String prefix;
    private int rawTokenExpiration;
    private int refreshTokenExpiration;
    private String secret;
}
