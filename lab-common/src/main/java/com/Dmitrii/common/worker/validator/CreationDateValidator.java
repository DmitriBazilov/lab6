package com.Dmitrii.common.worker.validator;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * Валидатор даты создания.
 */
class CreationDateValidator {
	
	public static ZonedDateTime validateCreationDate(String s) {
		try {
			ZonedDateTime result = ZonedDateTime.parse(s);
			return result;
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Неправильная дата создания");
		}
	}
}
