package client.views;

/**
 * Created by Paul on 13/05/2015.
 */
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class DoctorView {

    private JDialog frame;
    private JTable consultationTable;

    public void show(){
        frame.setVisible(true);
    }
    /**
     * Create the application.
     */
    public DoctorView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JDialog();
        frame.setBounds(100, 100, 789, 482);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 153, 255));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JComboBox selectCombo = new JComboBox();
        selectCombo.setBounds(126, 11, 117, 20);
        panel.add(selectCombo);

        JLabel lblSelectPatient = new JLabel("Select Patient:");
        lblSelectPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSelectPatient.setBounds(10, 10, 106, 20);
        panel.add(lblSelectPatient);

        JButton selectButton = new JButton("Ok");
        selectButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        selectButton.setBounds(253, 10, 89, 23);
        panel.add(selectButton);

        JLabel lblConsultations = new JLabel("Consultations:");
        lblConsultations.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblConsultations.setBounds(10, 41, 89, 14);
        panel.add(lblConsultations);

        JScrollPane consultationScrolPane = new JScrollPane();
        consultationScrolPane.setBounds(10, 66, 753, 366);
        panel.add(consultationScrolPane);

        consultationTable = new JTable();
        consultationScrolPane.setViewportView(consultationTable);

        JButton addConsButton = new JButton("Edit Consultation");
        addConsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addConsButton.setBounds(622, 32, 141, 23);
        panel.add(addConsButton);
    }
}
