package client.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 14/05/2015.
 */
public class ConsultationEditor {

    private JDialog frame;
    private JTextField idField;

    /**
     * Create the application.
     */
    public ConsultationEditor() {
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
        frame.setBounds(100, 100, 507, 356);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        panel.setBounds(0, 0, 491, 317);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblConsultationId = new JLabel("Consultation Id:");
        lblConsultationId.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblConsultationId.setBounds(10, 11, 114, 14);
        panel.add(lblConsultationId);

        JLabel lblPatient = new JLabel("Patient:");
        lblPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPatient.setBounds(10, 36, 58, 14);
        panel.add(lblPatient);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDate.setBounds(10, 61, 46, 14);
        panel.add(lblDate);

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDoctor.setBounds(10, 86, 72, 14);
        panel.add(lblDoctor);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblStatus.setBounds(10, 111, 72, 14);
        panel.add(lblStatus);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDescription.setBounds(10, 136, 93, 14);
        panel.add(lblDescription);

        idField = new JTextField();
        idField.setBounds(113, 9, 114, 20);
        panel.add(idField);
        idField.setColumns(10);

        JComboBox patientCombo = new JComboBox();
        patientCombo.setBounds(113, 36, 114, 20);
        panel.add(patientCombo);

        JComboBox dateCombo = new JComboBox();
        dateCombo.setBounds(113, 59, 114, 20);
        panel.add(dateCombo);

        JComboBox hourCombo = new JComboBox();
        hourCombo.setBounds(243, 59, 58, 20);
        panel.add(hourCombo);

        JComboBox doctorCombo = new JComboBox();
        doctorCombo.setBounds(113, 84, 114, 20);
        panel.add(doctorCombo);

        JComboBox statusCombo = new JComboBox();
        statusCombo.setBounds(113, 109, 114, 20);
        panel.add(statusCombo);

        JTextArea descriptionField = new JTextArea();
        descriptionField.setBounds(113, 132, 367, 167);
        panel.add(descriptionField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        saveButton.setBounds(391, 27, 89, 23);
        panel.add(saveButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        deleteButton.setBounds(391, 58, 89, 23);
        panel.add(deleteButton);
    }
}
