package server;

import server.entities.Consultation;
import server.mappers.ConsultationMapper;
import server.mappers.DatabaseAccess;
import server.mappers.UserMapper;
import server.services.ConsultationService;
import server.services.UserService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		DatabaseAccess database= new DatabaseAccess();
		database.connectionSetup();
		UserMapper uM= new UserMapper();
		ConsultationMapper cM = new ConsultationMapper();
		UserService uS = new UserService(uM);
		ConsultationService cS =new ConsultationService(cM);

		// Setting a default port number.
		int portNumber = 5555;
		int count = 0;
		System.out.println("Starting the multiple socket server at port: " + portNumber);
		try {
			Socket connection =new Socket();
			ServerSocket serverSocket = new ServerSocket(portNumber);

			System.out.println("Multiple Socket Server Initialized");
//Listen for clients
			while(true) {
				Socket client = serverSocket.accept();
				Runnable runnable = new MServerSocket(client, ++count,cS,uS);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch (Exception e) {}
	}

}
