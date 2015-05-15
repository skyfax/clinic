package client;

import client.views.AdminView;
import client.views.DoctorView;
import client.views.SecretaryView;
import server.entities.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

/**
 * Created by Paul on 12/05/2015.
 */
public class ClientHandler {

    LoginView login;
    ClientSocket client;

    public ClientHandler(ClientSocket client) {
        this.client = client;
    }

    public void clientInitialization() {
        login = new LoginView();
        login.addFrameListener(new FrameListener());
        login.addLoginListener(new LoginListener());
    }


    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent arg) {
            String username = login.getUsernameField().getText();
            String password = login.getPasswordField().getText();
            System.out.println("User: " + username + " pass: " + password);
            User user = new User();
            try {
                client.login(username, password);
                user = (User) client.readResponse();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (user.getId() != null && (user.getId() != 0)) {
                int roleId = user.getRole().getId();
                System.out.println(roleId);
                switch (roleId) {
                    case 1: {//administrator
                        AdminView admin = new AdminView();
                        admin.show();
                        break;
                    }
                    case 3: {//doctor
                        DoctorView doctor = new DoctorView();
                        doctor.show();
                        break;
                    }
                    case 4: {//secretary
                        SecretaryView secretary = new SecretaryView();
                        secretary.show();
                        break;
                    }

                }

                login.getUsernameField().setText("");
                login.getPasswordField().setText("");
            } else
                JOptionPane.showMessageDialog(login.getFrame(),
                        "Wrong Username/Password.", "Login",
                        JOptionPane.WARNING_MESSAGE);
        }
    }

    class FrameListener implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
            try {
                client.closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void windowClosed(WindowEvent e) {
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }
    }
}
