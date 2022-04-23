package com.Dmitrii.server;

import com.Dmitrii.common.parserhub.*;
import com.Dmitrii.common.worker.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author dmitrii
 */
public class WorkerCollection {
	
	private TreeMap<Coordinates, Worker> collection;
	private LocalDateTime creationDate;
	private Parser parser;

	public WorkerCollection(File file) {
		collection = new TreeMap<>();
		creationDate = LocalDateTime.now();
		parser = new JsonParser();
		List<Worker> workers = parser.getClasses(file);
		for (Worker w : workers) {
			collection.put(w.getCoordinates(), w);
			System.out.println(w);
		}
	}

	public TreeMap<Coordinates, Worker> getCollection() {
		return collection;
	}
	
	public String getInfo() {
		return String.join(", ", creationDate.toString(), Integer.toString(collection.size()));
	}
	
	public void insert(Worker worker) {
		collection.put(worker.getCoordinates(), worker);
	}
	
	public void removeKey(Coordinates coords) {
		collection.remove(coords);
	}

	public void show() {
		Collection<Worker> col = collection.values();
		for (Worker w : col) {
			System.out.println(w);
		}
	}
}
