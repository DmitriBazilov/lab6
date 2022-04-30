package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class MaxBySalary extends Command {

	public MaxBySalary(CommandHandler handler, String name, String description) {
		super(handler, name, description);
	}
	
	@Override
	public Object execute(List<Object> args) {
		Worker w = getHandler().getCollection().maxBySalary();
		if (w != null) {
			return new Response("Максимальная зарплата: " 
					+ w.getSalary() 
					+ System.lineSeparator() 
					+ "Инфа о рабочем: " 
					+ w.toString());
		} else {
			return new Response("Коллекция пустая");
		}
	}
}
