package com.Dmitrii.client.handlers;

import com.Dmitrii.client.Commands;
import com.Dmitrii.common.worker.*;
import com.Dmitrii.common.worker.validator.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmitrii
 */
class CommandReader {
	
	private BufferedReader reader;
	private InputStream stream;
	private Commands commands;
	
	public CommandReader(InputStream stream) {
		this.stream = stream;
		reader = new BufferedReader(new InputStreamReader(stream));
		commands = new Commands();
	}
	
	public String readCommand() {
		try {
			String line = reader.readLine().trim().toLowerCase();
			if (commands.isCommand(line))
				return line;
			else
				return readCommand();
		} catch (IOException ex) {
			System.out.println("ОСУЖДАЮ");
		}	
		return null;
	}
	
	public ArrayList<Object> readArgs(String command) {
		ArrayList<Object> result = new ArrayList<>();
		if (commands.isNeedId(command))
			result.add(readId());
		if (commands.isNeedKey(command))
			result.add(readCoordinates());
		if (commands.isNeedWorker(command))
			result.add(readWorker());
		return result;
	}

	public Integer readId() {
		try {
			System.out.print("Введите Id : ");
			String line = reader.readLine().trim();
			Integer result = IdValidator.validateId(line);
			return result;
		} catch (IOException e) {
			System.out.println("adas");
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readId();
			}
			throw e;
		}
	}

	public Worker readWorker() {
		String name = readName();
		Coordinates coordinates = readCoordinates();
		Long salary = readSalary();
		LocalDateTime startDate = readStartDate();
		Position position = readPosition();
		Status status = readStatus();
		Person person = readPerson();
		return WorkerValidator.validateWorker(new Worker(name, coordinates, salary, startDate, position, status, person));
	}

	public String readName() {
		try {
			System.out.print("Введите имя : ");
			String line = reader.readLine().trim();
			String result = NameValidator.validateName(line);
			return result;
		} catch (IOException e) {
			System.out.println("jdsklfjs");
			return null;
		} catch	(IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readName();
			}
			throw e;
		}
	}

	public Coordinates readCoordinates() {
		try {
			System.out.print("Введите 2 координаты : ");
			String line = reader.readLine().trim();
			String[] coords = line.split("\\s+");
			if (coords.length != 2)
				throw new NumberFormatException("Координаты должно быть 2");
			double x = CoordinatesValidator.validateX(coords[0]);
			long y = CoordinatesValidator.validateY(coords[1]);
			return new Coordinates(x, y);
		} catch (IOException e) {
			System.out.println("LAJLKAJD");
			return null;
		} catch (NumberFormatException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readCoordinates();
			}
			throw e;
		}
	}

	public Long readSalary() {
		try {
			System.out.print("Введите зарплату раба : ");
			String line = reader.readLine().trim();
			Long result = SalaryValidator.validateSalary(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readSalary();
			}
			throw e;
		}
	}

	public LocalDateTime readStartDate() {
		try {
			System.out.println("Введите дату начала работы : ");
			String line = reader.readLine().trim();
			LocalDateTime result = StartDateValidator.validateStartDate(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readStartDate();
			}
			throw e;
		}
	}

	public Position readPosition() {
		try {
			System.out.println("Введите должность раба : ");
			String line = reader.readLine().trim();
			Position result = PositionValidator.validatePosition(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readPosition();
			}
			throw e;
		}
	}

	public Status readStatus() {
		try {
			System.out.println("Введите статус раба : ");
			String line = reader.readLine().trim();
			Status result = StatusValidator.validateStatus(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readStatus();
			}
			throw e;
		}
	}

	public Person readPerson() {
		Integer weight = readWeight();
		Color eyeColor = readEyeColor();
		Color hairColor = readHairColor();
		Location location = readLocation();
		return WorkerValidator.validatePerson(new Person(weight, eyeColor, hairColor, location));
	}

	public Integer readWeight() {
		try {
			System.out.println("Введите вес раба : ");
			String line = reader.readLine().trim();
			Integer result = WeightValidator.validateWeight(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readWeight();
			}
			throw e;
		}
	}

	public Color readEyeColor() {
		try {
			System.out.println("Введите цвет глаз раба : ");
			String line = reader.readLine().trim();
			Color result = EyeColorValidator.validateEyeColor(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readEyeColor();
			}
			throw e;
		}
	}

	public Color readHairColor() {
		try {
			System.out.println("Введите цвет волос раба : ");
			String line = reader.readLine().trim();
			Color result = HairColorValidator.validateHairColor(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readHairColor();
			}
			throw e;
		}
	}

	public Location readLocation() {
		try {
			System.out.println("Введите место жительства раба(3 координаты) : ");
			String line = reader.readLine().trim();
			Location result = PersonValidator.validateLocation(line);
			return result;
		} catch (IOException e) {
			return null;
		} catch (IllegalArgumentException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readLocation();
			}
			throw e;
		}
	}
}
