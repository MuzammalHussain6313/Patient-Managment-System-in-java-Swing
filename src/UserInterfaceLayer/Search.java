package UserInterfaceLayer;

import PersistenceLayer.DoctorDatabase;
import PersistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search
{
    DoctorDatabase doctorDatabase = new DoctorDatabase();
    PatientDatabase patientDatabase = new PatientDatabase();
    JPanel SearchPatientRecordpanel = new JPanel();
    JPanel SearchByIDpanel = new JPanel();
    JPanel SearchByNamepanel = new JPanel();
    JPanel SearchByAgepanel = new JPanel();
    JPanel SearchByDiseaspanel = new JPanel();
    JPanel SearchByDoctorpanel = new JPanel();
    JPanel SearchDoctorByNamepanel = new JPanel();
    JPanel SearchDoctorBySpacializationpanel = new JPanel();
    JPanel searchByNameForGuestPanel = new JPanel();
    JPanel searchByIDForGuestPanel = new JPanel();
    JPanel searchByAgeForGuestPanel = new JPanel();
    Font font1 = new Font("Arial", Font.BOLD, 15);
    public JPanel searchPatientRecord() //working
    {
        SearchPatientRecordpanel.setLayout(null);
        JLabel name = new JLabel("Name");
        JLabel fatherName = new JLabel("Father Name");
        JTextField patientName = new JTextField();
        JTextField FatherName = new JTextField();
        JButton save = new JButton("Search");
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
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[][] data= new String[1][8];
                data = patientDatabase.searchPatientRecord(patientName.getText(),FatherName.getText());
                String[] columns = {"ID", "Name", "Father Name", "Gender", "Date Of Birth","Doctor ID","Disease History","Prescription"};
                viewtable(data,columns);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        SearchPatientRecordpanel.add(fatherName);
        SearchPatientRecordpanel.add(patientName);
        SearchPatientRecordpanel.add(name);
        SearchPatientRecordpanel.add(FatherName);
        SearchPatientRecordpanel.add(save);
        SearchPatientRecordpanel.add(cancel);
        return SearchPatientRecordpanel;
    }
    public JPanel searchPatientByID() // working
    {
        JLabel id = new JLabel("ID");
        JTextField ID = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        id.setBounds(50,20,200,30);
        id.setFont(font1);
        ID.setBounds(210,20,200,30);
        ID.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[][] data= new String[1][8];
                data = patientDatabase.searchPatientByID(Integer.parseInt(ID.getText()));
                String[] columns = {"ID", "Name", "Father Name", "Gender", "Date Of Birth","Doctor ID","Disease History","Prescription"};
                viewtable(data,columns);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SearchByIDpanel.setVisible(false);
            }
        });
        SearchByIDpanel.add(ID);
        SearchByIDpanel.add(id);
        SearchByIDpanel.add(save);
        SearchByIDpanel.add(cancel);
        SearchByIDpanel.setLayout(null);
        return SearchByIDpanel;
    }
    public JPanel searchPatientByname() //working
    {
        JLabel name = new JLabel("Name");
        JTextField NAME = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        NAME.setBounds(210,20,200,30);
        NAME.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[][] data= new String[1][8];
                data = patientDatabase.searchPatientByNAME(NAME.getText());
                String[] columns = {"ID", "Name", "Father Name", "Gender", "Date Of Birth","Doctor ID","Disease History","Prescription"};
                viewtable(data,columns);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SearchByNamepanel.setVisible(false);
            }
        });
        SearchByNamepanel.add(NAME);
        SearchByNamepanel.add(name);
        SearchByNamepanel.add(save);
        SearchByNamepanel.add(cancel);
        SearchByNamepanel.setLayout(null);
        return SearchByNamepanel;
    }
    public JPanel searchPatientByAge() //working
    {
        JLabel age = new JLabel("Age");
        JTextField AGE = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        age.setBounds(50,20,200,30);
        age.setFont(font1);
        AGE.setBounds(210,20,200,30);
        AGE.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                patientDatabase.searchPatientByAge(Integer.parseInt(AGE.getText()));
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SearchByAgepanel.setVisible(false);
            }
        });
        //SearchByAgepanel.setBackground(Color.white);
        //SearchByAgepanel.setBounds(200, 200, 470, 250);
        SearchByAgepanel.add(age);
        SearchByAgepanel.add(AGE);
        SearchByAgepanel.add(save);
        SearchByAgepanel.add(cancel);
        SearchByAgepanel.setLayout(null);
        return SearchByAgepanel;
    }
    public JPanel searchPatientByDisease()
    {
        JLabel disease = new JLabel("Disease");
        JTextField DISEASE = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        disease.setBounds(50,20,200,30);
        disease.setFont(font1);
        DISEASE.setBounds(210,20,200,30);
        DISEASE.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        //SearchByDiseaspanel.setBackground(Color.white);
        //SearchByDiseaspanel.setBounds(200, 200, 470, 250);
        SearchByDiseaspanel.add(DISEASE);
        SearchByDiseaspanel.add(disease);
        SearchByDiseaspanel.add(save);
        SearchByDiseaspanel.add(cancel);
        SearchByDiseaspanel.setLayout(null);
        return SearchByDiseaspanel;
    }
    public JPanel searchPatientByDoctor()
    {
        JLabel doctor = new JLabel("Doctor Name");
        JTextField DOCTOR = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        doctor.setBounds(50,20,200,30);
        doctor.setFont(font1);
        DOCTOR.setBounds(210,20,200,30);
        DOCTOR.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        //SearchByDoctorpanel.setBackground(Color.white);
        //SearchByDoctorpanel.setBounds(200, 200, 470, 250);
        SearchByDoctorpanel.add(DOCTOR);
        SearchByDoctorpanel.add(doctor);
        SearchByDoctorpanel.add(save);
        SearchByDoctorpanel.add(cancel);
        SearchByDoctorpanel.setLayout(null);
        return SearchByDoctorpanel;
    }
    public JPanel searchDoctorByName() // working
    {
        JLabel name = new JLabel("Name Of Doctor");
        JTextField NAME = new JTextField();
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        NAME.setBounds(210,20,200,30);
        NAME.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[][] data= new String[1][3];
                data = doctorDatabase.searchDoctorByNAME(NAME.getText());
                String[] columns = {"ID", "Name", "Specialization"};
                viewtable(data,columns);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        //SearchDoctorByNamepanel.setBackground(Color.white);
        //SearchDoctorByNamepanel.setBounds(200, 200, 470, 250);
        SearchDoctorByNamepanel.add(NAME);
        SearchDoctorByNamepanel.add(name);
        SearchDoctorByNamepanel.add(save);
        SearchDoctorByNamepanel.add(cancel);
        SearchDoctorByNamepanel.setLayout(null);
        return SearchDoctorByNamepanel;
    }
    public JPanel searchDoctorBySpacialization()
    {
        JLabel disease = new JLabel("Disease name");
        String diseases[] = {"Heart","Eye","Nose","Stomach","Kidney","liver"};
        JComboBox DISEASE = new JComboBox(diseases);
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        disease.setBounds(50,20,200,30);
        disease.setFont(font1);
        DISEASE.setBounds(210,20,200,30);
        DISEASE.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String diseaseName = (String) DISEASE.getItemAt(DISEASE.getSelectedIndex());
                String[][] data= new String[1][3];
                data = doctorDatabase.searchDoctorBySpacialization(diseaseName);
                String[] columns = {"ID", "Name", "Specialization"};
                viewtable(data,columns);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        //SearchDoctorBySpacializationpanel.setBackground(Color.white);
        //SearchDoctorBySpacializationpanel.setBounds(200, 200, 470, 250);
        SearchDoctorBySpacializationpanel.add(DISEASE);
        SearchDoctorBySpacializationpanel.add(disease);
        SearchDoctorBySpacializationpanel.add(save);
        SearchDoctorBySpacializationpanel.add(cancel);
        SearchDoctorBySpacializationpanel.setLayout(null);
        return SearchDoctorBySpacializationpanel;
    }
    public JPanel searchByNameForGuest()
    {
        JLabel name = new JLabel("Name");
        JLabel persone = new JLabel("Select Persone");
        JTextField personeName = new JTextField();
        String diseases[] = {"Doctor","Manager"};
        JComboBox persones = new JComboBox(diseases);
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        personeName.setBounds(210,20,200,30);
        personeName.setFont(font1);
        persone.setBounds(50,80,200,30);
        persone.setFont(font1);
        persones.setBounds(210,80,200,30);
        persones.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        searchByNameForGuestPanel.setLayout(null);
        searchByNameForGuestPanel.setVisible(true);
        searchByNameForGuestPanel.add(persone);
        searchByNameForGuestPanel.add(personeName);
        searchByNameForGuestPanel.add(name);
        searchByNameForGuestPanel.add(persones);
        searchByNameForGuestPanel.add(save);
        searchByNameForGuestPanel.add(cancel);
        return searchByNameForGuestPanel;
    }
    public JPanel searchByIDForGuest()
    {
        JLabel name = new JLabel("ID");
        JLabel persone = new JLabel("Select Persone");
        JTextField personeName = new JTextField();
        String diseases[] = {"Doctor","Manager"};
        JComboBox persones = new JComboBox(diseases);
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        personeName.setBounds(210,20,200,30);
        personeName.setFont(font1);
        persone.setBounds(50,80,200,30);
        persone.setFont(font1);
        persones.setBounds(210,80,200,30);
        persones.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        searchByIDForGuestPanel.setLayout(null);
        searchByIDForGuestPanel.setVisible(true);
        searchByIDForGuestPanel.add(persone);
        searchByIDForGuestPanel.add(personeName);
        searchByIDForGuestPanel.add(name);
        searchByIDForGuestPanel.add(persones);
        searchByIDForGuestPanel.add(save);
        searchByIDForGuestPanel.add(cancel);
        return searchByIDForGuestPanel;
    }
    public JPanel searchByAgeForGuest()
    {
        JLabel name = new JLabel("Age");
        JLabel persone = new JLabel("Select Persone");
        JTextField personeName = new JTextField();
        String diseases[] = {"Manager","Doctor"};
        JComboBox persones = new JComboBox(diseases);
        JButton save = new JButton("Search");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        personeName.setBounds(210,20,200,30);
        personeName.setFont(font1);
        persone.setBounds(50,80,200,30);
        persone.setFont(font1);
        persones.setBounds(210,80,200,30);
        persones.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        searchByAgeForGuestPanel.setLayout(null);
        searchByAgeForGuestPanel.setVisible(true);
        searchByAgeForGuestPanel.add(persone);
        searchByAgeForGuestPanel.add(personeName);
        searchByAgeForGuestPanel.add(name);
        searchByAgeForGuestPanel.add(persones);
        searchByAgeForGuestPanel.add(save);
        searchByAgeForGuestPanel.add(cancel);
        return searchByAgeForGuestPanel;
    }
    public void searchPatientTable(String name,String Fname) //working
    {
//        JFrame frame = new JFrame("test");
//        JPanel panel = new JPanel();
//        panel.setBounds(0,0,900,100);
//        String[] columns = {"ID", "Name", "Father Name", "Gender", "Date Of Birth","Doctor ID","Disease History","Prescription"};
//        String[][] data= new String[1][8];
//        data = ;
//        JTable table = new JTable(data, columns);
//        table.getColumnModel().getColumn(0).setPreferredWidth(27);
//        table.getColumnModel().getColumn(1).setPreferredWidth(220);
//        table.getColumnModel().getColumn(2).setPreferredWidth(250);
//        table.getColumnModel().getColumn(3).setPreferredWidth(290);
//        table.getColumnModel().getColumn(4).setPreferredWidth(290);
//        table.getColumnModel().getColumn(6).setPreferredWidth(250);
//        table.getColumnModel().getColumn(7).setPreferredWidth(250);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBounds(30, 30, 700, 79);
//
//        panel.add(scrollPane);
//        panel.setVisible(true);
//        frame.add(panel);
//        frame.setBounds(200,200,950,450);
//        frame.setLayout(null);
//        frame.setVisible(true);
    }
    public void viewtable(String [][] data, String columns[]) //working
    {
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        panel.setBounds(0,0,900,100);
        JTable table = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30, 700, 79);

        panel.add(scrollPane);
        panel.setVisible(true);
        frame.add(panel);
        frame.setBounds(200,200,950,450);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public void searchByNameTable(String [][] data) //working
    {
//        JFrame frame = new JFrame("test");
//        JPanel panel = new JPanel();
//        panel.setBounds(0,0,900,100);
//        String[] columns = {"ID", "Name", "Father Name", "Gender", "Date Of Birth","Doctor ID","Disease History","Prescription"};
//        JTable table = new JTable(data, columns);
//        table.getColumnModel().getColumn(0).setPreferredWidth(27);
//        table.getColumnModel().getColumn(1).setPreferredWidth(220);
//        table.getColumnModel().getColumn(2).setPreferredWidth(250);
//        table.getColumnModel().getColumn(3).setPreferredWidth(290);
//        table.getColumnModel().getColumn(4).setPreferredWidth(290);
//        table.getColumnModel().getColumn(6).setPreferredWidth(250);
//        table.getColumnModel().getColumn(7).setPreferredWidth(250);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBounds(30, 30, 700, 79);
//
//        panel.add(scrollPane);
//        panel.setVisible(true);
//        frame.add(panel);
//        frame.setBounds(200,200,950,450);
//        frame.setLayout(null);
//        frame.setVisible(true);
    }
    public static void main(String a[])
    {
        Search s = new Search();
    }
}