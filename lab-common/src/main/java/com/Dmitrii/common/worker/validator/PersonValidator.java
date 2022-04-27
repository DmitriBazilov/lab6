package com.Dmitrii.common.worker.validator;

import com.Dmitrii.common.worker.Color;
import com.Dmitrii.common.worker.Location;

/**
 *
 * Класс, дополняющий и вызывающий валидаторы информации о рабе.
 */
public class PersonValidator {

	public static Integer validateWeight(String s) throws IllegalArgumentException {
		if (s == null)
			return null;
		try {
			Integer result = WeightValidator.validateWeight(s);
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Color validateEyeColor(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Color result = EyeColorValidator.validateEyeColor(s);
			return result;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}

	public static Color validateHairColor(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Color result = HairColorValidator.validateHairColor(s);
			return result;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}

	public static Location validateLocation(String s) throws IllegalArgumentException, NumberFormatException {
		if (s == null)
			return null;
		String[] args = s.split("\\s+");
		if (args.length != 3)
			throw new IllegalArgumentException("Координаты должно быть 3");
		try {
			Double x = LocationValidator.validateX(args[0]);
			long y = LocationValidator.validateY(args[1]);
			int z = LocationValidator.validateZ(args[2]);
			return new Location(x, y, z);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
}
