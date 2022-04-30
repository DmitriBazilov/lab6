package com.Dmitrii.commandhub;

import com.Dmitrii.server.WorkerCollection;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public abstract class Command {

	private CommandHandler handler;
	private final String name;
	private final String description;

	public Command(CommandHandler handler, String name, String description) {
		this.handler = handler;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public CommandHandler getHandler() {
		return handler;
	}

	public abstract Object execute(List<Object> args);
}
