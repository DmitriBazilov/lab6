package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Coordinates;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public class RemoveKey extends Command{

	public RemoveKey(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}

	@Override
	public Object execute(List<Object> args) {
		for (Object o : args) {
			System.out.println(o);
		}
		Coordinates coords = (Coordinates) args.get(0);
		short returnCode = getHandler().getCollection().removeKey(coords);
		return returnCode == 1 ? new Response("Раб успешно удален") : new Response("Такого раба не существует");
	}
}
