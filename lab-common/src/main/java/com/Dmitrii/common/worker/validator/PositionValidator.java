package com.Dmitrii.common.worker.validator;

import com.Dmitrii.common.worker.Position;

/**
 *
 * Валидатор должности раба.
 */
public class PositionValidator {

	public static Position validatePosition(String p) throws IllegalArgumentException {
		try {
			Position result = Position.valueOf(p);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильное название позиции");
		} catch (NullPointerException e) {
			return null;
		}
	}
}
