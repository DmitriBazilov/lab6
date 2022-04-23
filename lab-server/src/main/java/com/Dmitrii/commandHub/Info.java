package com.Dmitrii.commandHub;

import com.Dmitrii.common.networkhub.Response;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Info extends Command{

	@Override
	public Object execute(List<Object> args) {
		return new Response(CommandHandler.getCollection().getInfo());
	}

}
