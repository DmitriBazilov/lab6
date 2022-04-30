package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class PrintAscending extends Command {

	public PrintAscending(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}
	
	@Override
	public Object execute(List<Object> args) {
		String workers = getHandler().getCollection().show();
		return new Response(workers.isEmpty() ? "Коллекция пуста" : workers);
	}
}
