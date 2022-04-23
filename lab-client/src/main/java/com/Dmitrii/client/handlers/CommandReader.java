package com.Dmitrii.client.handlers;

import com.Dmitrii.client.Commands;
import com.Dmitrii.common.worker.Coordinates;
import com.Dmitrii.common.worker.validator.CoordinatesValidator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			String line = reader.readLine().trim();
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
		if (!commands.isNeedKey(command))
			return null;
		ArrayList<Object> result = new ArrayList<>();
		result.add(readCoordinares());
		return result;
	}
	
	public Coordinates readCoordinares() {
		try {
			String line = reader.readLine().trim();
			String[] coords = line.split("\\s+");
			double x = CoordinatesValidator.validateX(coords[0]);
			long y = CoordinatesValidator.validateY(coords[1]);
			return new Coordinates(x, y);
		} catch (IOException e) {
			System.out.println("LAJLKAJD");
			return null;
		} catch (NumberFormatException e) {
			if (!(stream instanceof FileInputStream)) {
				System.out.println(e.getMessage() + " Попробуйте еще раз.");
				return readCoordinares();
			}
			throw e;
		}
	}
}
