package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Info extends Command{

	public Info(String name, String description) {
		super(name, description);
	}

	@Override
	public Object execute(List<Object> args) {
		return new Response(CommandHandler.getCollection().getInfo());
	}

}
