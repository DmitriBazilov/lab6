package com.Dmitrii.client.handlers;

import com.Dmitrii.common.networkhub.Request;
import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.networkhub.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


/**
 *
 * @author dmitrii
 */
public class Listener {
	
	private final int SERVER_PORT = 1234;
	private boolean isOn;
	private InputStream stream;
	
	public Listener(InputStream stream) {
		this.stream = stream;
		isOn = true;
	}
	
	public void startListen() {
		
		DatagramSocket clientSocket = null;
		InetAddress IPAddress = null;
		try {
			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName("localhost");
		} catch (SocketException ex) {
			System.out.println("YA LOX");
		} catch (UnknownHostException ex) {
			System.out.println("Такого адреса не существует");
		}
		CommandReader reader = new CommandReader(stream);
		Serializer serializer = new Serializer();
		while (isOn) {
			try {
				String command = reader.readCommand().trim();
				if ("exit".equals(command.toLowerCase())) {
					isOn = false;
					continue;
				}
				ArrayList<Object> args = reader.readArgs(command);
				
				// мутим реквест
				Request request = new Request(command, args);
				byte[] send = serializer.serialize(request);
				DatagramPacket dpRequest = new DatagramPacket(send, send.length, IPAddress, SERVER_PORT);
				clientSocket.send(dpRequest);
				
				// получаем ответ
				byte[] receive = new byte[1024];
				DatagramPacket dpResponse = new DatagramPacket(receive, receive.length);
				clientSocket.receive(dpResponse);
				Response response = (Response) serializer.deserialize(dpResponse.getData());
				System.out.println("Ответ от сервера " + response.getMessage());
//			RequestHandler.sendRequest(command);
//			Response response = RequestHandler.receiveResponse();
//			if (response.getReturnCode) {
//				System.out.println("Команда выполнилась успешно");
//				if (response.hasWorkers())
//					response.getWorkers.forEach(worker -> System.out.println(worker.toString()));
//				if (response.hasPositions())
//					response.getPositions.forEach(position -> System.out.println(position));
//				if (response.hasInfo())
//					System.out.println(response.getInfo());
//			}
			} catch (IOException ex) {

			}
		}
		clientSocket.close();
	}
}