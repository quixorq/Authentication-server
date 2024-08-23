package ru.obydennov.authorization.common;

/**
 * Перечисление типов ошибок REST.
 *
 * @author obydennov
 * @since 07.05.2022
 */
public enum ErrorCode {
	GLOBAL(2), AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);
	private int errorCode;

	ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
