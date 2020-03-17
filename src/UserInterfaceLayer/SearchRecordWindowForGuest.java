package UserInterfaceLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRecordWindowForGuest
{
    Search search = new Search();
    JFrame frame = new JFrame("Search Record");
    JPanel buttonPanel = new JPanel();
    JPanel controlPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    public JPanel searchforguest()
    {
        buttonPanel.setVisible(true);
        buttonPanel.setBounds(0,0,900,150);
        JButton patient = new JButton("Search Manager");
        patient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controlPanel = search.searchPatientByname();
            }
        });
        JButton doctor = new JButton("Search Doctor");
        doctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                controlPanel = search.searchDoctorByName();
                mainPanel.add(controlPanel);
            }
        });
        patient.setBounds(200,50,150,40);
        doctor.setBounds(400,50,150,40);
        buttonPanel.add(patient);
        buttonPanel.add(doctor);
        buttonPanel.setVisible(true);
        controlPanel.setBounds(0,150,900,600);
        controlPanel.setVisible(true);
        mainPanel.add(buttonPanel);
        mainPanel.add(controlPanel);
        mainPanel.setBounds(0,0,910,760);
        mainPanel.setVisible(true);
        return mainPanel;
    }
}
