package client;

import server.entities.User;

import java.io.*;
import java.net.*;

/**
 * Created by Paul on 09/05/2015.
 */
public class ClientSocket {
    private String hostname;
    private int port;
    Socket socketClient;
    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;
    ObjectInputStream inStream = null;

    public ClientSocket(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException {
        System.out.println("Attempting to connect to " + hostname + ":" + port);
        socketClient = new Socket(hostname, port);
        System.out.println("Connection Established");
        outputStream = new ObjectOutputStream(socketClient.getOutputStream());
        inStream = new ObjectInputStream(socketClient.getInputStream());
    }

    public Object readResponse() throws IOException {
        try {

            String action = (String) inStream.readObject();
            if (action.equals("loginResponse")) {
                User user = (User) inStream.readObject();
                return user;
            }
            inputStream.reset();
            outputStream.reset();

        } catch (SocketException se) {
            se.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
        return  null;
    }

    public void closeConnection() throws IOException {
        socketClient.close();
    }

    public void writeMessage() throws IOException {

        try {
            outputStream.flush();
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String username, String password) throws IOException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        outputStream.writeObject(new String("login"));
        outputStream.writeObject(user);
        writeMessage();
    }


}
