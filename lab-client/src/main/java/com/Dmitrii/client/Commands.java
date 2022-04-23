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
		
		commandsNeedWorker.add("insert");
		
		commandsNeedKey.add("remove_key");
	}
	
	public boolean isCommand(String command) {
		if (commandsNeedId.contains(command) ||
			commandsNeedKey.contains(command) ||
			commandsNeedWorker.contains(command) ||
			commandsWithoutArguments.contains(command)) {
				return true;
		} else {
			return false;
		}
	}
	
	public boolean isNeedKey(String command) {
		return commandsNeedKey.contains(command) ? true : false;
	}
}
