package com.Dmitrii.server;

import com.Dmitrii.commandhub.CommandHandler;
import java.io.File;
import java.io.IOException;

public final class Server {

    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException {
		String path = "/Users/ITMO/Downloads/lab5-lab6/lab-server/src/main/java/com/Dmitrii/data.json";
		File file = new File(path);
		if (file.exists())
			System.out.println("YA DAUN");
		WorkerCollection collection = new WorkerCollection(file);
		CommandHandler.setCollection(collection);
		CommandHandler.getCollection().show();
		ServerListener clientListener = new ServerListener(1234);
		clientListener.startListen();
    }
}