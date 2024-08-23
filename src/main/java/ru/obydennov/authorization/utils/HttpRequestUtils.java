package ru.obydennov.authorization.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Класс вспомогательных методов для Http запросов
 *
 * @author  obydennov
 * @since 07.05.2022
 */
public final class HttpRequestUtils {
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-type";

    public static boolean isContentTypeJson(HttpServletRequest request) {
        return request.getHeader(CONTENT_TYPE).contains(CONTENT_TYPE_JSON);
    }
}
