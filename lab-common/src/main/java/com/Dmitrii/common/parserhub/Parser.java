package com.Dmitrii.common.parserhub;

import java.util.List;
import java.io.File;
import com.Dmitrii.common.worker.*;
import java.io.IOException;
import java.util.TreeMap;

/**
 *
 * Абстрактный класс парсера.
 */
public abstract class Parser {

	public abstract List<Worker> getClasses(File file);

	public abstract void writeClasses(File file, TreeMap<Coordinates, Worker> classes) throws IOException;
}
