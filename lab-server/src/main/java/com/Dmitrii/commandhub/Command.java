package com.Dmitrii.commandhub;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public abstract class Command {

	private final String name;
	private final String description;

	public Command(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public abstract Object execute(List<Object> args);
}
