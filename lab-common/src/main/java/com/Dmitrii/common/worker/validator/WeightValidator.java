package com.Dmitrii.common.worker.validator;

/**
 *
 * Валидатор веса раба.
 */
public class WeightValidator {

	public static Integer validateWeight(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Integer result = Integer.parseInt(s);
			if (Integer.compare(result, 0) > 0) {
				return result;
			} else {
				throw new IllegalArgumentException("Неправильное число. Должно быть > 0");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Неправильный формат. Число должно быть целочисленным");
		}
	}
}

