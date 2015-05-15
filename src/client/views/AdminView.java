package client.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 14/05/2015.
 */
public class AdminView {

    private JDialog frame;
    private JTable table;


    /**
     * Create the application.
     */
    public AdminView() {
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
        frame.setBounds(100, 100, 475, 481);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 204, 255));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblUser = new JLabel("User");
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUser.setBounds(20, 17, 82, 14);
        panel.add(lblUser);

        JButton editUserInfo = new JButton("Add User");
        editUserInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        editUserInfo.setBounds(86, 14, 89, 23);
        panel.add(editUserInfo);

        JLabel lblNewLabel = new JLabel("Edit User Informations");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(20, 42, 168, 23);
        panel.add(lblNewLabel);

        JComboBox editPatientInfo = new JComboBox();
        editPatientInfo.setBounds(198, 44, 143, 20);
        panel.add(editPatientInfo);

        JButton editUserButton = new JButton("Edit");
        editUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        editUserButton.setBounds(351, 43, 89, 23);
        panel.add(editUserButton);

        JLabel lblEditPatientConsultation = new JLabel("Edit Patient Consultation Informations");
        lblEditPatientConsultation.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEditPatientConsultation.setBounds(20, 110, 258, 14);
        panel.add(lblEditPatientConsultation);

        JLabel lblPatient = new JLabel("Patient");
        lblPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPatient.setBounds(139, 136, 67, 14);
        panel.add(lblPatient);

        JComboBox editConsPatientCombo = new JComboBox();
        editConsPatientCombo.setBounds(243, 134, 139, 20);
        panel.add(editConsPatientCombo);

        JLabel lblConsultation = new JLabel("Consultation");
        lblConsultation.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblConsultation.setBounds(139, 161, 95, 14);
        panel.add(lblConsultation);

        JComboBox consultationCombo = new JComboBox();
        consultationCombo.setBounds(243, 159, 139, 20);
        panel.add(consultationCombo);

        JButton editConsButton = new JButton("Edit");
        editConsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        editConsButton.setBounds(243, 186, 139, 23);
        panel.add(editConsButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 228, 420, 190);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

}