package com.Dmitrii.common.worker.validator;

import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import com.Dmitrii.common.worker.*;

/**
 *
 * Класс, вызывающий все валидаторы полей раба.
 */
public class WorkerValidator {
	
	public static Worker validateWorker(Worker w) throws IllegalArgumentException, NumberFormatException, DateTimeParseException, NullPointerException {
		validateId(w.getId());
		validateName(w.getName());
		validateCoordinates(w.getCoordinates());
		validateCreationDate(w.getCreationDate());
		validateSalary(w.getSalary());
		validateStartDate(w.getStartDate());
		validatePosition(w.getPosition());
		validateStatus(w.getStatus());
		validatePerson(w.getPerson());
		return w;
	}
	
	public static Integer validateId(Integer id) throws IllegalArgumentException {
		if (id == null || id <= 0)
			throw new IllegalArgumentException("Неправильный ID. Не должен быть null и должен быть больше нуля");
		return id;
	}

	public static String validateName(String name) throws IllegalArgumentException {
		try {
			String result = NameValidator.validateName(name);
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Coordinates validateCoordinates(Coordinates c) throws IllegalArgumentException, NumberFormatException {
		if (c == null) 
			throw new IllegalArgumentException("Координаты не могут быть null");
		try {
			String[] coords = c.toString().split("\\s+");
			double x = c.getX();
			long y = c.getY();
			double resultX = CoordinatesValidator.validateX(Double.toString(x));
			long resultY = CoordinatesValidator.validateY(Long.toString(y));
			return c;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	} 

	public static ZonedDateTime validateCreationDate(ZonedDateTime time) throws IllegalArgumentException {
		if (time == null) 
			throw new IllegalArgumentException("Время не может быть null");
		try {
			ZonedDateTime result = CreationDateValidator.validateCreationDate(time.toString());
		} catch (IllegalArgumentException e) {
			throw e;
		}
		return time;
	}

	public static Long validateSalary(Long salary) throws IllegalArgumentException, NumberFormatException {
		if (salary == null) 
			throw new IllegalArgumentException("Зарплата не может быть null");
		try {
			Long result = SalaryValidator.validateSalary(salary.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static LocalDateTime validateStartDate(LocalDateTime time) throws IllegalArgumentException {
		if (time == null)
			throw new IllegalArgumentException("Время не может быть null");
		try {
			LocalDateTime result = StartDateValidator.validateStartDate(time.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Position validatePosition(Position pos) throws IllegalArgumentException {
		if (pos == null) 
			return null;
		try {
			Position result = PositionValidator.validatePosition(pos.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Status validateStatus(Status s) throws IllegalArgumentException {
		if (s == null)
			return null;
		try {
			Status result = StatusValidator.validateStatus(s.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Person validatePerson(Person p) throws IllegalArgumentException, NullPointerException {
		if (p == null)
			return null;
		try {
			Integer resultWeight;
			if (p.getWeight() != null)
				resultWeight = PersonValidator.validateWeight(p.getWeight().toString());
			Color resultEyeColor = PersonValidator.validateEyeColor(p.getEyeColor().toString());
			Color resultHairColor = PersonValidator.validateHairColor(p.getHairColor().toString());
			Location resultLocation;
			if (p.getLocation() != null)
				resultLocation = PersonValidator.validateLocation(p.getLocation().toString());
			return p;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}
}
