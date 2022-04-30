package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Insert extends Command{

	public Insert(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}

	@Override
	public Object execute(List<Object> args) {
		Worker worker = (Worker) args.get(0);
		worker.setId();
		worker.setCreationDate();
		short returnCode = getHandler().getCollection().insert(worker);
		return returnCode == 1 ? new Response("Раб добавлен в коллекцию") : new Response("Ошибка при добавлении раба в коллекцию");
	}

}
