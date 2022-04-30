package com.Dmitrii.server;

import com.Dmitrii.commandhub.CommandHandler;

import java.util.Scanner;

/**
 *
 * @author dmitrii
 */
public class ConsoleListener extends Thread {
	
	private final CommandHandler handler;
	private final boolean isOn;
	
	public ConsoleListener(CommandHandler handler) {
		this.handler = handler;
		isOn = true;
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (isOn) {
			String message = scanner.nextLine().trim();
			if ("exit".equals(message))
				System.exit(1);
			if ("save".equals(message))
				System.out.println(handler.executeServerCommand(message));
		}
	}

	
}
