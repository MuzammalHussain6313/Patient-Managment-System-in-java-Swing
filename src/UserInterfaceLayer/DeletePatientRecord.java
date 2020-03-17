package UserInterfaceLayer;

import PersistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePatientRecord
{
    PatientDatabase patientDatabase = new PatientDatabase();
    JPanel deletePatientPanel = new JPanel();
    Font font1 = new Font("Arial", Font.BOLD, 15);
    public JPanel deletePatient()
    {
        JLabel name = new JLabel("Name");
        JLabel fatherName = new JLabel("Father Name");
        JTextField patientName = new JTextField();
        JTextField FatherName = new JTextField();
        JButton save = new JButton("Delete");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = patientName.getText();
                String fname  =FatherName.getText();
                patientDatabase.deletePatient(name,fname);
            }
        });
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        patientName.setBounds(210,20,200,30);
        patientName.setFont(font1);
        fatherName.setBounds(50,80,200,30);
        fatherName.setFont(font1);
        FatherName.setBounds(210,80,200,30);
        FatherName.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        deletePatientPanel.add(fatherName);
        deletePatientPanel.add(patientName);
        deletePatientPanel.add(name);
        deletePatientPanel.add(FatherName);
        deletePatientPanel.add(save);
        deletePatientPanel.add(cancel);
        deletePatientPanel.setLayout(null);
        return deletePatientPanel;
    }
}
