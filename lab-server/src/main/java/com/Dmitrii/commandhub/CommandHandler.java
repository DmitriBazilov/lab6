package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Request;
import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.server.WorkerCollection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dmitrii
 */
public class CommandHandler {
	
	private static final Map<String, Command> commands = new HashMap<>();
	private static final Map<String, Command> serverCommands = new HashMap<>();
	private static WorkerCollection collection;
	
	static {
		commands.put("info", new Info("Info", "вывести в стандартный поток вывода информацию о коллекции"));
		commands.put("insert", new Insert("Insert", "добавить новый элемент"));
		commands.put("remove_key", new RemoveKey("Remove_key", "удалить элемент из коллекции по его ключу"));
		commands.put("show", new Show("Show", "вывести в стандартный поток вывода все элементы коллекции"));
		commands.put("help", new Help("Help", "вывести справку по доступным командам"));
		commands.put("update_id", new UpdateId("Update_id", "обновить значение элемента коллекции, id которого равен заданному"));
		commands.put("clear", new Clear("Clear", "очистить коллекцию"));
		commands.put("remove_lower", new RemoveLower("Remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный"));
		commands.put("replace_if_greater", new ReplaceIfGreater("Replace_if_greater", "заменить значение по ключу, если новое значение больше старого"));
		commands.put("remove_lower_key", new RemoveLowerKey("Remove_lower_key", " удалить из коллекции все элементы, ключ которых меньше, чем заданный"));

		serverCommands.put("save", new Save("Save", "сохранить коллекцию в файл"));
	}

	public static Map<String, Command> getCommands() {
		return commands;
	}

	public static void setCollection(WorkerCollection collection) {
		CommandHandler.collection = collection;
	}
	
	public static WorkerCollection getCollection() {
		return collection;
	}

	public static Response executeCommandByRequest(Request request) {
		return (Response) commands.get(request.getCommandName()).execute(request.getArgs());
	}

	public static String executeServerCommand(String command) {
		return (String) serverCommands.get(command).execute(null);
	}
}
