package com.Dmitrii.commandhub;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Exit extends Command {

	public Exit(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}
	
	@Override
	public Object execute(List<Object> args) {
		return getHandler().serverOff() ? "Сервер выключен" : "Ошибка при выключении сервера";
	}
}
