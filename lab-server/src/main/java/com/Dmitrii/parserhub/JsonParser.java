package com.Dmitrii.parserhub;

import com.Dmitrii.common.worker.Coordinates;
import com.Dmitrii.common.worker.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Collection;

/**
 *
 * Класс - парсер. Парсит json. Умеет записывать и доставать рабов из файла.
 */
public class JsonParser extends Parser {

	public List<Worker> getClasses(File jsonFile) {
		ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules();
		List<Worker> objList = new ArrayList<>();
		try {
			objList = mapper.readValue(jsonFile, new TypeReference<List<Worker>>(){});
		} catch (IOException e) {
			System.out.println(e);
		}
		return objList;
	}

	public void writeClasses(File file, TreeMap<Coordinates, Worker> classes) throws IOException {
		ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules();
		Collection<Worker> collection = classes.values();
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, collection);
	}
}
