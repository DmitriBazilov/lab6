package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Request;
import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.server.WorkerCollection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmitrii
 */
public class CommandHandler {
	
	private final Map<String, Command> commands = new HashMap<>();
	private final Map<String, Command> serverCommands = new HashMap<>();
	private WorkerCollection collection;
	private boolean serverIsOn;
	
	public CommandHandler(WorkerCollection collection) {
		serverIsOn = true;
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
		commands.put("print_unique_position", new PrintUniquePosition(this, "Print_unique_position", "вывести уникальные значения поля position всех элементов в коллекции"));
		
		serverCommands.put("save", new Save(this, "Save", "сохранить коллекцию в файл"));
		serverCommands.put("exit", new Exit(this, "Exit", "Выключение сервера"));
	}

	public boolean getServerIsOn() {
		return serverIsOn;
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
		Command command = commands.get(request.getCommandName());
		if (command == null) {
			return new Response("Такой команды нет");
		} else {
			return (Response) command.execute(request.getArgs());
		}
	}
	public String executeServerCommand(String stringCommand, List<Object> args) {
		Command command = serverCommands.get(stringCommand);
		if (command == null) {
			return "Такой команды нет";
		} else {
			return (String) command.execute(args);
		}
	}
	public boolean serverOff() {
		serverIsOn = false;
		return true;
	}
}
