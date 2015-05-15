package client;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String arg[]) {
		LoginView login;
		ClientSocket client = new ClientSocket("localhost", 5555);
		try {
			client.connect();
		} catch (UnknownHostException e) {
			System.err.println("Host unknown. Cannot establish connection");
		} catch (IOException e) {
			System.err.println("Cannot establish connection. Server may not be up."
					+ e.getMessage());
		}
		ClientHandler clientHandler = new ClientHandler(client);
		clientHandler.clientInitialization();

	}



}
