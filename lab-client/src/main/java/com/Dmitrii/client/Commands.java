package com.Dmitrii.client;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Commands {
	
	private final List<String> commandsWithoutArguments;
	private final List<String> commandsNeedWorker;
	private final List<String> commandsNeedKey;
	private final List<String> commandsNeedId;
	private final List<String> commandsNeedPath;
	
	public Commands() {
		commandsNeedId = new ArrayList<>();
		commandsNeedKey = new ArrayList<>();
		commandsNeedWorker = new ArrayList<>();
		commandsWithoutArguments = new ArrayList<>();
		commandsNeedPath = new ArrayList<>();
		
		commandsNeedPath.add("execute_script");

		commandsNeedId.add("update_id");

		commandsNeedKey.add("remove_key");
		commandsNeedKey.add("remove_lower_key");

		commandsNeedWorker.add("update_id");
		commandsNeedWorker.add("insert");
		commandsNeedWorker.add("remove_lower");
		commandsNeedWorker.add("replace_if_greater");

		commandsWithoutArguments.add("info");
		commandsWithoutArguments.add("exit");
		commandsWithoutArguments.add("show");
		commandsWithoutArguments.add("help");
		commandsWithoutArguments.add("clear");
		commandsWithoutArguments.add("max_by_salary");
		commandsWithoutArguments.add("print_ascending");//-
		commandsWithoutArguments.add("print_unique_position");//-
	}
	
	public boolean isCommand(String command) {
		return commandsNeedId.contains(command) ||
				commandsNeedKey.contains(command) ||
				commandsNeedWorker.contains(command) ||
				commandsWithoutArguments.contains(command) ||
				commandsNeedPath.contains(command);
	}
	
	public boolean isNeedPath(String command) {
		return commandsNeedPath.contains(command);
	}
	
	public boolean isNeedKey(String command) {
		return commandsNeedKey.contains(command);
	}

	public boolean isNeedWorker(String command) {
		return commandsNeedWorker.contains(command);
	}

	public boolean isNeedId(String command) {
		return commandsNeedId.contains(command);
	}
}
