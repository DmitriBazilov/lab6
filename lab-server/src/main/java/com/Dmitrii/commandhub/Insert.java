package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Insert extends Command{

	@Override
	public Object execute(List<Object> args) {
		Worker worker = (Worker) args.get(0);
		CommandHandler.getCollection().insert(worker);
		return new Response("Раб добавлен в коллекцию");
	}

}
