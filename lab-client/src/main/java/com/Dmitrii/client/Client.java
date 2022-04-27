package com.Dmitrii.client;

import com.Dmitrii.client.handlers.Listener;
import java.io.IOException;

public final class Client {
 
	private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException {
		Listener listener = new Listener(System.in);
		listener.startListen();
	}
}
