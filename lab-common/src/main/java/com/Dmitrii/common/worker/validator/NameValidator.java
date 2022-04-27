package com.Dmitrii.common.worker.validator;

/**
 *
 * Валидатор имени раба.
 */
public class NameValidator {

	public static String validateName(String n) throws IllegalArgumentException {
		if ("".equals(n) || n == null)
			throw new IllegalArgumentException("Неправильное имя");
		return n;
	}
}
