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
	
	private final Map<String, Command> commands = new HashMap<>();
	private final Map<String, Command> serverCommands = new HashMap<>();
	private WorkerCollection collection;
	
	public CommandHandler(WorkerCollection collection) {
		this.collection = collection;
		commands.put("info", new Info(this, "Info", "вывести в стандартный поток вывода информацию о коллекции"));
		commands.put("insert", new Insert(this, "Insert", "добавить новый элемент"));
		commands.put("remove_key", new RemoveKey(this, "Remove_key", "удалить элемент из коллекции по его ключу"));
		commands.put("show", new Show(this, "Show", "вывести в стандартный поток вывода все элементы коллекции"));
		commands.put("help", new Help(this, "Help", "вывести справку по доступным командам"));
		commands.put("update_id", new UpdateId(this, "Update_id", "обновить значение элемента коллекции, id которого равен заданному"));
		commands.put("clear", new Clear(this, "Clear", "очистить коллекцию"));
		commands.put("remove_lower", new RemoveLower(this, "Remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный"));
		commands.put("replace_if_greater", new ReplaceIfGreater(this, "Replace_if_greater", "заменить значение по ключу, если новое значение больше старого"));
		commands.put("remove_lower_key", new RemoveLowerKey(this, "Remove_lower_key", "удалить из коллекции все элементы, ключ которых меньше, чем заданный"));
		commands.put("max_by_salary", new MaxBySalary(this, "Max_by_salary", "вывести любой объект из коллекции, значение поля salary которого является максимальным"));
		commands.put("print_ascending", new PrintAscending(this, "Print_ascending", "вывести элементы коллекции в порядке возрастания"));
		
		serverCommands.put("save", new Save(this, "Save", "сохранить коллекцию в файл"));
	}

	public Map<String, Command> getCommands() {
		return commands;
	}

	public void setCollection(WorkerCollection collection) {
		this.collection = collection;
	}
	
	public WorkerCollection getCollection() {
		return collection;
	}

	public Response executeCommandByRequest(Request request) {
		return (Response) commands.get(request.getCommandName()).execute(request.getArgs());
	}

	public String executeServerCommand(String command) {
		return (String) serverCommands.get(command).execute(null);
	}
}
