package ru.obydennov.authorization.filters;

import ru.obydennov.authorization.model.filter.AuthenticationFilter;

/**
 * Фабрика создания фильтров для авторизации внутри
 * спринг секьюрити
 *
 * @author obydennov
 * @since 07.06.2022
 */
public interface AuthenticationFilterFactory {
    AuthenticationProcessingFilter getAuthenticationFilter(AuthenticationFilter filterType);
}
