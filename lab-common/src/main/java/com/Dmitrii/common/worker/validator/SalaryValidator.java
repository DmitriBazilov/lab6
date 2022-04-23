package com.Dmitrii.common.worker.validator;

/**
 *
 * Валидатор зарплаты раба.
 */
public class SalaryValidator {

	public static Long validateSalary(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Long salary = Long.parseLong(s);
			if (salary > 0)
				return salary;
			else
				throw new IllegalArgumentException("Зарплата должна быть больше 0");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Неправильный формат. Число должно быть целочисленным");
		}
	}
}
