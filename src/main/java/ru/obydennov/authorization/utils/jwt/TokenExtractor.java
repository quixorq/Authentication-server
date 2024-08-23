package ru.obydennov.authorization.utils.jwt;

/**
 * Экстрактор токена из заголовка
 *
 * @author obydennov
 * @since 13.05.2022
 */
public interface TokenExtractor {
    String extractTokenFromHeader(String payload);
}
