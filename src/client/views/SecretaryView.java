package client.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 14/05/2015.
 */
public class SecretaryView {

    private JDialog frame;
    private JTable patientTable;
    /**
     * Create the application.
     */
    public SecretaryView() {
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
        frame.setBounds(100, 100, 472, 479);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 204, 255));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblPatients = new JLabel("Patients");
        lblPatients.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPatients.setBounds(20, 17, 82, 14);
        panel.add(lblPatients);

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        addPatientButton.setBounds(86, 14, 89, 23);
        panel.add(addPatientButton);

        JLabel lblNewLabel = new JLabel("Edit Patient Informations");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(20, 42, 168, 23);
        panel.add(lblNewLabel);

        JComboBox editPatientInfo = new JComboBox();
        editPatientInfo.setBounds(198, 44, 143, 20);
        panel.add(editPatientInfo);

        JButton editPaientButton = new JButton("Edit");
        editPaientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        editPaientButton.setBounds(351, 43, 89, 23);
        panel.add(editPaientButton);

        JLabel lblConsultations = new JLabel("Consultations");
        lblConsultations.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblConsultations.setBounds(20, 76, 109, 14);
        panel.add(lblConsultations);

        JButton addConsultationButton = new JButton("Add Consultation");
        addConsultationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        addConsultationButton.setBounds(139, 75, 115, 23);
        panel.add(addConsultationButton);

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

        JLabel lblPatient_1 = new JLabel("Patient");
        lblPatient_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPatient_1.setBounds(20, 220, 82, 14);
        panel.add(lblPatient_1);

        JComboBox notifyCombo = new JComboBox();
        notifyCombo.setBounds(86, 218, 120, 20);
        panel.add(notifyCombo);

        JButton notifyDoctor = new JButton("Notify Doctor");
        notifyDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        notifyDoctor.setBounds(243, 217, 139, 23);
        panel.add(notifyDoctor);

        JScrollPane patientScrollPane = new JScrollPane();
        patientScrollPane.setBounds(20, 266, 420, 166);
        panel.add(patientScrollPane);

        patientTable = new JTable();
        patientScrollPane.setViewportView(patientTable);
    }

}