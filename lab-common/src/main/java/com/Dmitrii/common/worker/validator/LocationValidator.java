package com.Dmitrii.common.worker.validator;

/**
 *
 * Валидатор локации раба.
 */
public class LocationValidator {

	public static Double validateX(String s) throws IllegalArgumentException {
		try {
			Double result = Double.parseDouble(s);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный X");
		}
	}

	public static long validateY(String s) throws IllegalArgumentException {
		try {
			Long result = Long.parseLong(s);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный Y");
		}
	}

	public static int validateZ(String s) throws IllegalArgumentException {
		try {
			Integer result = Integer.parseInt(s);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный Z");
		}
	}
}
