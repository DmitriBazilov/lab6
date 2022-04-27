package com.Dmitrii.common.worker.validator;

import com.Dmitrii.common.worker.Color;

/**
 *
 * Валидатор цвета глаз.
 */
public class EyeColorValidator {

	public static Color validateEyeColor(String s) throws IllegalArgumentException, NullPointerException {
		try {
			Color result = Color.valueOf(s.toUpperCase());
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный цвет");
		} catch (NullPointerException e) {
			throw new NullPointerException("Цвет не может быть null");
		}
	}
}
