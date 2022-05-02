package com.Dmitrii.server;

import com.Dmitrii.commandhub.CommandHandler;

import java.util.Scanner;

/**
 *
 * @author dmitrii
 */
public class ConsoleListener extends Thread {
	
	private final CommandHandler handler;
	
	public ConsoleListener(CommandHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (handler.getServerIsOn()) {
			String message = scanner.nextLine().trim();
			System.out.println(handler.executeServerCommand(message, null));
		}
	}

	
}
