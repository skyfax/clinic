package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * Created by Paul on 12/05/2015.
 */
public class LoginView {

    private JFrame frame;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginBtn;

    public void addFrameListener(WindowListener w){
        frame.addWindowListener(w);
    }

    public void addLoginListener(ActionListener a){
        loginBtn.addActionListener(a);
    }

    public LoginView() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 427, 209);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel adminPanel = new JPanel();
        adminPanel.setBackground(new Color(153, 255, 255));
        adminPanel.setBounds(0, 0, 411, 170);
        frame.getContentPane().add(adminPanel);
        adminPanel.setLayout(null);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        loginBtn.setBounds(106, 127, 200, 23);
        adminPanel.add(loginBtn);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(106, 11, 77, 21);
        adminPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(106, 38, 200, 21);
        adminPanel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPassword.setBounds(106, 70, 77, 14);
        adminPanel.add(lblPassword);

        passwordField = new JTextField();
        passwordField.setBounds(106, 95, 200, 21);
        adminPanel.add(passwordField);
        passwordField.setColumns(10);
    }


    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JFrame getFrame() {
        return frame;
    }
}