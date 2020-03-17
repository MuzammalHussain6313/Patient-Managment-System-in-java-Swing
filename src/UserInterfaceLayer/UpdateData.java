package UserInterfaceLayer;

import PersistenceLayer.DiseaseDatabase;
import PersistenceLayer.DoctorDatabase;
import PersistenceLayer.PatientDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateData
{
    PatientDatabase patientDatabase = new PatientDatabase();
    DoctorDatabase doctorDatabase = new DoctorDatabase();
    DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
    JFrame frame = new JFrame("Update data");
    Font font1 = new Font("Arial", Font.BOLD, 15);
    JPanel addNewPatient = new JPanel();
    JPanel addDoctor = new JPanel();
    JPanel panel = new JPanel();
    public void updatePatientSuppoter()
    {
        JPanel p = new JPanel();
        p.setBounds(100,100,1000,700);
        p.setLayout(null);
        frame.setBounds(100,0,1000,600);
        JLabel name = new JLabel("Name");
        JButton save = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        JTextField NAME = new JTextField();
        name.setBounds(50,110,150,40);
        save.setBounds(150,380,100,40);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                p.setVisible(false);
                panel = updatePatient();
                panel.setVisible(true);
                panel.setBounds(100,100,1000,700);
                frame.getContentPane().add(panel);
            }
        });
        cancel.setBounds(300,380,100,40);
        NAME.setBounds(150,110,300,40);
        p.add(name);
        p.add(NAME);
        p.add(save);
        p.add(cancel);
        frame.add(p);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public JPanel updatePatient()
    {
//        UtilDateModel model = new UtilDateModel();
//        Properties p = new Properties();
//        p.put("text.today", "Today");
//        p.put("text.month", "Month");
//        p.put("text.year", "Year");
//        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//        datePicker.setBounds(25,25,100,30);
//        JPanel top = new JPanel();
//        top.setBounds(150,250,300,40);
//        top.add(datePicker);
//        top.setVisible(true);


        addNewPatient.setLayout(null);
        addNewPatient.setVisible(true);
        JLabel id = new JLabel("ID");
        JLabel name = new JLabel("Name");
        JLabel fatherName = new JLabel("Father Name");
        JLabel gender = new JLabel("Gender");
        JLabel dateOfBirth = new JLabel("Date Of Birth");
        JLabel doctorName = new JLabel("Doctor Name");
        JLabel diseaseHistory = new JLabel("Disease History");
        JLabel discription = new JLabel("Discription");
        JButton save = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        JTextField ID = new JTextField();
        String iD = Integer.toString(patientDatabase.getPatientID());
        ID.setText(Integer.toString(Integer.parseInt(iD)+1));
        ID.setEditable(false);
        JTextField NAME = new JTextField();
        JTextField FATHER_NAME = new JTextField();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        JTextField date = new JTextField();
        JComboBox doctor = new JComboBox(doctorDatabase.doctorList());
        JTextArea dHistory = new JTextArea();
        JTextArea discriptions = new JTextArea();
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        id.setBounds(50,60,120,40);
        name.setBounds(50,110,150,40);
        fatherName.setBounds(50,160,150,40);
        gender.setBounds(50,200,150,40);
        dateOfBirth.setBounds(50,250,150,40);
        doctorName.setBounds(50,300,150,40);
        diseaseHistory.setBounds(470,60,100,40);
        discription.setBounds(470,240,100,40);
        save.setBounds(150,380,100,40);
        cancel.setBounds(300,380,100,40);
        ID.setBounds(150,60,300,40);
        NAME.setBounds(150,110,300,40);
        FATHER_NAME.setBounds(150,160,300,40);
        male.setBounds(160,200,80,40);
        female.setBounds(270,200,100,40);
        date.setBounds(150,250,300,40);
        doctor.setBounds(150,300,300,40);
        dHistory.setBounds(470,90,300,150);
        discriptions.setBounds(470,280,300,150);

        addNewPatient.add(id);
        addNewPatient.add(name);
        addNewPatient.add(fatherName);
        addNewPatient.add(gender);
        addNewPatient.add(dateOfBirth);
        addNewPatient.add(male);
        addNewPatient.add(female);
        addNewPatient.add(date);
        addNewPatient.add(doctor);
        addNewPatient.add(doctorName);
        addNewPatient.add(discription);
        addNewPatient.add(discriptions);
        addNewPatient.setVisible(true);
        addNewPatient.add(diseaseHistory);
        addNewPatient.add(dHistory);
        addNewPatient.add(FATHER_NAME);
        addNewPatient.add(NAME);
        addNewPatient.add(ID);
        addNewPatient.add(save);
        addNewPatient.add(cancel);
        return addNewPatient;
    }
    public void updateDoctorSuppoter()
    {
        JPanel p = new JPanel();
        p.setBounds(100,100,1000,700);
        p.setLayout(null);
        frame.setBounds(100,0,1000,600);
        JLabel name = new JLabel("Name");
        JButton save = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        JTextField NAME = new JTextField();
        name.setBounds(50,110,150,40);
        save.setBounds(150,380,100,40);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                p.setVisible(false);
                panel = updateDoctor();
                panel.setVisible(true);
                panel.setBounds(100,100,1000,700);
                frame.getContentPane().add(panel);
            }
        });
        cancel.setBounds(300,380,100,40);
        NAME.setBounds(150,110,300,40);
        p.add(name);
        p.add(NAME);
        p.add(save);
        p.add(cancel);
        frame.add(p);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public JPanel updateDoctor()
    {
        JLabel name = new JLabel("Doctor Name");
        JLabel description = new JLabel("Select Disease");
        JTextField doctorname = new JTextField();
        JComboBox disease = new JComboBox(diseaseDatabase.diseaseList());
        JButton save = new JButton("Save");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        doctorname.setBounds(210,20,200,30);
        doctorname.setFont(font1);
        description.setBounds(50,80,200,30);
        description.setFont(font1);
        disease.setBounds(210,80,200,30);
        disease.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String diseaseName = (String) disease.getItemAt(disease.getSelectedIndex());
                String doctorName = doctorname.getText();
                doctorDatabase.insertDoctor(doctorName,diseaseName);
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        addDoctor.setLayout(null);
        addDoctor.setVisible(true);
        //addDoctor.setBackground(Color.DARK_GRAY);
        //addDoctor.setBounds(100, 100, 470, 250);
        addDoctor.add(description);
        addDoctor.add(doctorname);
        addDoctor.add(name);
        addDoctor.add(disease);
        addDoctor.add(save);
        addDoctor.add(cancel);
        return addDoctor;

    }
}
