package com.Dmitrii.common.worker.validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * Валидатор даты начала работы.
 */
public class StartDateValidator {

	public static LocalDateTime validateStartDate(String s) throws IllegalArgumentException {
		try {
			LocalDateTime result = LocalDateTime.parse(s);
			return result;
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Неправильная дата");
		}
	}
}
