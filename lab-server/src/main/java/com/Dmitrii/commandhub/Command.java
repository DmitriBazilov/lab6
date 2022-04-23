package com.Dmitrii.commandhub;

import java.util.List;

/**
 *
 * @author dmitrii
 */
public abstract class Command {
	
	public abstract Object execute(List<Object> args);
}
