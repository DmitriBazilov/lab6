package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Position;
import java.util.List;
import java.util.Set;

/**
 *
 * @author dmitrii
 */
public class PrintUniquePosition extends Command {

	public PrintUniquePosition(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}
	
	@Override
	public Object execute(List<Object> args) {
		Set<Position> uniquePositions = getHandler().getCollection().getUniquePositions();
		StringBuilder responseMessage = new StringBuilder();
		for (Position pos : uniquePositions) {
			responseMessage.append(pos.toString())
					.append(System.lineSeparator());
		}
		responseMessage.deleteCharAt(responseMessage.length() - 1);
		return new Response(responseMessage.toString().isEmpty() ? "Коллекция пуста" : responseMessage.toString());
	}
}
