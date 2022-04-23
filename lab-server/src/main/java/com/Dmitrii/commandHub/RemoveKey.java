package com.Dmitrii.commandHub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Coordinates;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public class RemoveKey extends Command{

	@Override
	public Object execute(List<Object> args) {
		Coordinates coords = (Coordinates) args.get(0);
		CommandHandler.getCollection().removeKey(coords);
		Response response = new Response("раб удален");
		return response;
	}
}
