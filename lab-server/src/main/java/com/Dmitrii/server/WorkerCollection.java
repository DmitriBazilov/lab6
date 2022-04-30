package com.Dmitrii.server;

import com.Dmitrii.common.parserhub.*;
import com.Dmitrii.common.worker.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author dmitrii
 */
public class WorkerCollection {

    private TreeMap<Coordinates, Worker> collection;
    private final LocalDateTime creationDate;
    private final Parser parser;

    public WorkerCollection(File file) {
        collection = new TreeMap<>();
        creationDate = LocalDateTime.now();
        parser = new JsonParser();
        List<Worker> workers = parser.getClasses(file);
        for (Worker w : workers) {
            w.setId();
            collection.put(w.getCoordinates(), w);
        }
    }

    public TreeMap<Coordinates, Worker> getCollection() {
        return collection;
    }

    public String getInfo() {
        return String.join(", ", creationDate.toString(), Integer.toString(collection.size()));
    }
	
	public Set<Position> getUniquePositions() {
		Set<Position> result = new HashSet<>();
		for (Worker w : collection.values()) {
			result.add(w.getPosition());
		}
		return result;
	}

    public short insert(Worker worker) {
        collection.put(worker.getCoordinates(), worker);
        return 1;
    }

    public short updateId(Integer id, Worker worker) {
        Collection<Worker> workers = collection.values();
        Worker workerForRemove = null;
        for (Worker w : workers) {
            if (w.getId().equals(worker.getId())) {
                workerForRemove = w;
                break;
            }
        }
        if (workerForRemove != null) {
            removeKey(workerForRemove.getCoordinates());
            return insert(worker);
        } else {
            return 0;
        }
    }

    public short removeKey(Coordinates coords) {
        if (collection.remove(coords) == null)
            return 0;
        else
            return 1;
    }

    public int removeLower(Worker worker) {
        Coordinates key = worker.getCoordinates();
        return removeLowerKey(key);
    }

    public int removeLowerKey(Coordinates key) {
        int counter = 0;
        while (collection.lowerKey(key) != null) {
            removeKey(collection.lowerKey(key));
            counter++;
        }
        return counter;
    }

    public short replaceIfGreater(Worker worker) {
        Worker colWorker = collection.get(worker.getCoordinates());
        if (colWorker == null)
            return -1;
        if (worker.compareTo(colWorker) > 0) {
            removeKey(worker.getCoordinates());
            insert(worker);
            return 1;
        } else {
            return 0;
        }
    }
	
	public Worker maxBySalary() {
		Collection<Worker> workers = collection.values();
		Worker maxSalaryWorker = null;
		long maxSalary = 0l;
		for (Worker w : workers) {
			if (w.getSalary().compareTo(maxSalary) >= 0) {
				maxSalaryWorker = w;
				maxSalary = w.getSalary();
			}
		}
		return maxSalaryWorker;
	}

    public short clear() {
        collection.clear();
        return 1;
    }

    public String show() {
        Collection<Worker> col = collection.values();
        String result = "";
		for (Worker w : col) {
			result += (w.toString() + System.lineSeparator());
        }
		return result;
    }
}
