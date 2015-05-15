package client.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Paul on 14/05/2015.
 */
public class UserEditor {

    private JDialog frame;
    private JTextField idField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField cnpField;
    private JTextField birthDateField;
    private JTextField icnField;

    /**
     * Create the application.
     */
    public UserEditor() {
        initialize();
    }

    public void show(){
        frame.setVisible(true);
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JDialog();
        frame.setBounds(100, 100, 417, 448);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel adminPanel = new JPanel();
        adminPanel.setBackground(new Color(153, 255, 255));
        adminPanel.setBounds(0, 0, 401, 409);
        frame.getContentPane().add(adminPanel);
        adminPanel.setLayout(null);

        JLabel lblId = new JLabel("Id:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblId.setBounds(78, 43, 46, 14);
        adminPanel.add(lblId);

        idField = new JTextField();
        idField.setBounds(196, 41, 110, 21);
        adminPanel.add(idField);
        idField.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblName.setBounds(78, 72, 61, 14);
        adminPanel.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(196, 70, 110, 21);
        adminPanel.add(nameField);
        nameField.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUsername.setBounds(78, 99, 76, 18);
        adminPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(196, 99, 110, 21);
        adminPanel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPassword.setBounds(78, 134, 76, 14);
        adminPanel.add(lblPassword);

        passwordField = new JTextField();
        passwordField.setBounds(196, 131, 110, 21);
        adminPanel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCnp.setBounds(78, 166, 46, 14);
        adminPanel.add(lblCnp);

        cnpField = new JTextField();
        cnpField.setBounds(196, 163, 110, 21);
        adminPanel.add(cnpField);
        cnpField.setColumns(10);

        JLabel lblBirthDate = new JLabel("Birth Date:");
        lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblBirthDate.setBounds(78, 198, 71, 14);
        adminPanel.add(lblBirthDate);

        birthDateField = new JTextField();
        birthDateField.setBounds(196, 195, 110, 21);
        adminPanel.add(birthDateField);
        birthDateField.setColumns(10);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAddress.setBounds(78, 231, 76, 14);
        adminPanel.add(lblAddress);

        addressField = new JTextField();
        addressField.setBounds(196, 227, 110, 23);
        adminPanel.add(addressField);
        addressField.setColumns(10);

        JLabel lblIcn = new JLabel("ICN:");
        lblIcn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblIcn.setBounds(78, 264, 46, 14);
        adminPanel.add(lblIcn);

        icnField = new JTextField();
        icnField.setBounds(196, 261, 110, 20);
        adminPanel.add(icnField);
        icnField.setColumns(10);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRole.setBounds(78, 295, 46, 14);
        adminPanel.add(lblRole);

        JComboBox roleCombo = new JComboBox();
        roleCombo.setBounds(196, 292, 110, 20);
        adminPanel.add(roleCombo);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        deleteBtn.setBounds(78, 321, 110, 23);
        adminPanel.add(deleteBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancelBtn.setBounds(140, 351, 110, 23);
        adminPanel.add(cancelBtn);

        JButton saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        saveBtn.setBounds(196, 321, 110, 23);
        adminPanel.add(saveBtn);
    }
}