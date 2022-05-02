package com.Dmitrii.client.handlers;

import com.Dmitrii.client.validators.WeightValidator;
import com.Dmitrii.client.validators.SalaryValidator;
import com.Dmitrii.client.validators.NameValidator;
import com.Dmitrii.client.validators.IdValidator;
import com.Dmitrii.client.validators.HairColorValidator;
import com.Dmitrii.client.validators.EyeColorValidator;
import com.Dmitrii.client.validators.CoordinatesValidator;
import com.Dmitrii.client.validators.PersonValidator;
import com.Dmitrii.client.validators.PositionValidator;
import com.Dmitrii.client.validators.StatusValidator;
import com.Dmitrii.client.validators.StartDateValidator;
import com.Dmitrii.client.validators.WorkerValidator;
import com.Dmitrii.client.Commands;
import com.Dmitrii.common.worker.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
			return null;
		}	
	}
	
	public ArrayList<Object> readArgs(String command) {
		ArrayList<Object> result = new ArrayList<>();
		try {
			if (commands.isNeedPath(command))
				result.add(readPath());
			if (commands.isNeedId(command))
				result.add(readId());
			if (commands.isNeedKey(command))
				result.add(readCoordinates());
			if (commands.isNeedWorker(command))
				result.add(readWorker());
		} catch (Exception e) {
			return null;
		}	
		return result;
	}
	
	public String readPath() {
		try {
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите путь до скрипта: ");
			String line = reader.readLine().trim();
			if (Files.isRegularFile(Paths.get(line))) {
				return line;
			} else {
				return readPath();
			}
		} catch (IOException ex) {
			return null;
		}
	}

	public Integer readId() {
		try {
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите Id : ");
			String line = reader.readLine().trim();
			Integer result = IdValidator.validateId(line);
			return result;
		} catch (IOException e) {
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите имя : ");
			String line = reader.readLine().trim();
			String result = NameValidator.validateName(line);
			return result;
		} catch (IOException e) {
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите 2 координаты : ");
			String line = reader.readLine().trim();
			String[] coords = line.split("\\s+");
			if (coords.length != 2)
				throw new NumberFormatException("Координаты должно быть 2");
			double x = CoordinatesValidator.validateX(coords[0]);
			long y = CoordinatesValidator.validateY(coords[1]);
			return new Coordinates(x, y);
		} catch (IOException e) {
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите зарплату раба : ");
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите дату начала работы(YYYY-MM-DD hh:mm:ss): ");
			String line = reader.readLine().trim();
			String replace = line.replace(" ", "T");
			LocalDateTime result = StartDateValidator.validateStartDate(replace);
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите должность раба(MANAGER, LABORER, HUMAN_RESOURCES, LEAD_DEVELOPER, BAKER): ");
			String line = reader.readLine().trim();
			Position result = PositionValidator.validatePosition(line.toUpperCase());
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите статус раба(FIRED, RECOMMENDED_FOR_PROMOTION, PROBATION): ");
			String line = reader.readLine().trim();
			Status result = StatusValidator.validateStatus(line.toUpperCase());
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
			if (!(stream instanceof FileInputStream))
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите цвет глаз раба(RED, WHITE, BLACK, ORANGE, BLUE): ");
			String line = reader.readLine().trim();
			Color result = EyeColorValidator.validateEyeColor(line.toUpperCase());
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите цвет волос раба(RED, WHITE, BLACK, ORANGE, BLUE): ");
			String line = reader.readLine().trim();
			Color result = HairColorValidator.validateHairColor(line.toUpperCase());
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
			if (!(stream instanceof FileInputStream))
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
