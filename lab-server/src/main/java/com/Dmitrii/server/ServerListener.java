package com.Dmitrii.server;

import com.Dmitrii.commandHub.CommandHandler;
import com.Dmitrii.common.networkhub.Request;
import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.networkhub.Serializer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author dmitrii
 */
public class ServerListener {
	
	private final Selector selector;
	private final DatagramChannel datagramChannel;
	private boolean isOn = true;
	
	public ServerListener(int port) throws IOException {
		datagramChannel = DatagramChannel.open();
		selector = Selector.open();
		datagramChannel.socket().bind(new InetSocketAddress(port));
		datagramChannel.configureBlocking(false);
		datagramChannel.register(selector, SelectionKey.OP_READ);
	}
	
	public void startListen() throws IOException {
		ConsoleListener consoleListener = new ConsoleListener();
		consoleListener.start();
		
		Serializer serializer = new Serializer();
		System.out.println("Слушаем");
		while (isOn) {
			try {
				
				if (selector.selectNow() == 0)
					continue;
				Request request = null;
				SocketAddress address = null;
				Set<SelectionKey> rKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = rKeys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
					if (key.isReadable()) {
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						address = datagramChannel.receive(buffer);
						buffer.flip();
						byte[] byteRequest = new byte[buffer.remaining()];
						buffer.get(byteRequest);
						request = (Request) serializer.deserialize(byteRequest);
						break;
					}
				}
				
				if (request != null && address != null) {
					Response response = CommandHandler.executeCommandByRequest(request);
					ByteBuffer byteResponse = ByteBuffer.wrap(serializer.serialize(response));
					datagramChannel.send(byteResponse, address);
				}
				
				//Получаем реквест, десериализуем и выводим его
//				DatagramPacket dpRequest = new DatagramPacket(receive, receive.length);
//				serverSocket.receive(dpRequest);
//				Request request = (Request) serializer.deserialize(dpRequest.getData());
//				String userMessage = request.getMessage();
//				System.out.println("Client says: " + userMessage);
//				
//				// чекаем адресс клиента
//				InetAddress senderAddress = dpRequest.getAddress();
//				int senderPort = dpRequest.getPort();
//				
//				// крафтим респонс сериализуем его и отправляем
//				Response response = new Response(userMessage.toUpperCase());
//				send = serializer.serialize(response);
//				DatagramPacket dpResponse = new DatagramPacket(send, send.length, senderAddress, senderPort);
//				serverSocket.send(dpResponse);
			} catch (Exception e) {
				System.out.println("СОСУ ХУЙ");
			}
		}
	}
}
