package com.Dmitrii.common.worker.validator;

/**
 *
 * Валидатор Id.
 */
public class IdValidator {
	
	public static Integer validateId(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Integer result = Integer.parseInt(s);
			if (Integer.compare(result, 0) > 0)
				return result;
			else 
				throw new IllegalArgumentException("Id должен быть больше 0");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Неправильный формат. Id это 1 целлочисленное число");
		}
	}
}
