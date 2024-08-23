package ru.obydennov.authorization.common;

/**
 * Объект для получения области видимости
 *
 * @author obydennov
 * @since 22.05.2022
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
