package util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectServer {
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 1234;
	
	private Socket socketServer;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public Socket getSocketServer() {
		return socketServer;
	}

	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}

	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}

	public ConnectServer() {
		try {
			socketServer = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("Connected to server");
			objectOutputStream = new ObjectOutputStream(socketServer.getOutputStream());
			objectInputStream = new ObjectInputStream(socketServer.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
