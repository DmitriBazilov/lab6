package com.Dmitrii.client;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Commands {
	
	private List<String> commandsWithoutArguments;
	private List<String> commandsNeedWorker;
	private List<String> commandsNeedKey;
	private List<String> commandsNeedId;
	
	public Commands() {
		commandsNeedId = new ArrayList<>();
		commandsNeedKey = new ArrayList<>();
		commandsNeedWorker = new ArrayList<>();
		commandsWithoutArguments = new ArrayList<>();
		
		commandsWithoutArguments.add("info");
		commandsWithoutArguments.add("exit");
		commandsWithoutArguments.add("show");
		
		commandsNeedWorker.add("insert");
		
		commandsNeedKey.add("remove_key");
	}
	
	public boolean isCommand(String command) {
		return commandsNeedId.contains(command) ||
				commandsNeedKey.contains(command) ||
				commandsNeedWorker.contains(command) ||
				commandsWithoutArguments.contains(command);
	}
	
	public boolean isNeedKey(String command) {
		return commandsNeedKey.contains(command);
	}

	public boolean isNeedWorker(String command) {
		return commandsNeedWorker.contains(command);
	}
}
