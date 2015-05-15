package server;

import server.entities.User;
import server.services.ConsultationService;
import server.services.UserService;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Paul on 09/05/2015.
 */
public class MServerSocket implements Runnable {
    private Socket connection;
    private int ID;
    private ConsultationService cS;
    private UserService uS;
    ObjectInputStream reader = null;
    ObjectOutputStream writer = null;

    public MServerSocket(Socket connection, int ID, ConsultationService cS, UserService uS) {
        this.connection = connection;
        this.ID = ID;
        this.cS = cS;
        this.uS = uS;
        try {
            writer = new ObjectOutputStream(connection.getOutputStream());
            reader = new ObjectInputStream(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                readFromClient(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFromClient(Socket client) throws IOException {
        try {

            String action = (String) reader.readObject();
            System.out.println("Action: " + action);
            if (action.equals("login")) {
                User user = (User) reader.readObject();
                handleLogin(user);
            }

        } catch (SocketException se) {
            se.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
    }

    private void sendMessage(ObjectOutputStream writer) throws IOException {
        writer.flush();
    }

    public void handleLogin(User user) throws IOException {
        User logger = uS.login(user);

        writer.writeObject(new String("loginResponse"));
        writer.writeObject(logger);
        sendMessage(writer);
    }

}
