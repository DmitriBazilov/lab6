package com.Dmitrii.server;

import com.Dmitrii.commandhub.CommandHandler;
import java.io.File;
import java.io.IOException;

public final class Server {

    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException {
		String path = "/home/dmitrii/Документы/Programming_univer/lab6/lab6/lab-server/src/main/java/com/Dmitrii/data.json";
		File file = new File(path);
		WorkerCollection collection = new WorkerCollection(file);
		CommandHandler handler = new CommandHandler(collection);
		ServerListener clientListener = new ServerListener(1234, handler);
		clientListener.startListen();
    }
}