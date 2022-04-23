package com.Dmitrii.common.networkhub;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dmitrii
 */
public class Request implements Serializable {
	
	private String commandName;
	private List<Object> args;
 
	public Request(String commandName) {
		this.commandName = commandName;
	}
	
	public Request(String commandName, List<Object> args) {
		this.commandName = commandName;
		this.args = args;
	} 

	public String getCommandName() {
		return commandName;
	}
	
	public List<Object> getArgs() {
		return args;
	}
}
