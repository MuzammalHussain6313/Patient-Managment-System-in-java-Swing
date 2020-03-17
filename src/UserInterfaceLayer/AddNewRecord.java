package UserInterfaceLayer;

import BusinessLogicLayer.*;
import PersistenceLayer.DiseaseDatabase;
import PersistenceLayer.DoctorDatabase;
import PersistenceLayer.PatientDatabase;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class AddNewRecord
{
    DoctorDatabase doctorDatabase = new DoctorDatabase();
    PatientDatabase patientDatabase = new PatientDatabase();
    DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
    JPanel addDoctor = new JPanel();
    JPanel addDisease = new JPanel();
    JPanel addNewPatient = new JPanel();
    Font font1 = new Font("Arial", Font.BOLD, 15);
    public JPanel addNewDisease()
    {
        JLabel name = new JLabel("Disease Name");
        JLabel description = new JLabel("Disease Discription");
        JTextField diseasename = new JTextField();
        JTextField diseasedescription = new JTextField();
        JButton save = new JButton("Save");
        JButton cancel = new JButton("cancel");
        name.setBounds(50,20,200,30);
        name.setFont(font1);
        diseasename.setBounds(210,20,200,30);
        diseasename.setFont(font1);
        description.setBounds(50,80,200,30);
        description.setFont(font1);
        diseasedescription.setBounds(210,80,200,30);
        diseasedescription.setFont(font1);
        save.setBounds(100,150,100,30);
        save.setFont(font1);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Disease disease = new Disease(diseasename.getText(),diseasedescription.getText());

                diseaseDatabase.insertDisease(disease.getname(),disease.getDiscription());
                //Admin.Manager patient = new Admin.Manager();
                //patient.sendTodataBase(name,discripotion);
                diseasename.setText("");
                diseasedescription.setText("");
            }
        });
        cancel.setBounds(250,150,100,30);
        cancel.setFont(font1);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addDisease.setVisible(true);
            }
        });
        addDisease.setLayout(null);
        addDisease.setVisible(true);
        addDisease.add(description);
        addDisease.add(diseasename);
        addDisease.add(name);
        addDisease.add(diseasedescription);
        addDisease.add(save);
        addDisease.add(cancel);
        return addDisease;
    }
    public JPanel addNewDoctor()
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
                Doctor doctor = new Doctor(doctorname.getText(),diseaseName);
                doctorDatabase.insertDoctor(doctor.getName(),doctor.getSpacialization());
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
    public JPanel addNewPatient()
    {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(25,25,100,30);
        JPanel top = new JPanel();
        top.setBounds(150,250,300,40);
        top.add(datePicker);
        top.setVisible(true);


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
        JButton save = new JButton("Save");
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
        JComboBox doctor = new JComboBox(doctorDatabase.doctorList());
        JTextArea dHistory = new JTextArea();
        JTextArea discriptions = new JTextArea();
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int identity = Integer.parseInt(ID.getText());
                String d = (String) doctor.getItemAt(doctor.getSelectedIndex());
                String gendr  = "male" ;
                java.util.Date datee = (java.util.Date) datePicker.getModel().getValue();
                //java.sql.Date sqlDate = new java.sql.Date(datee.getTime());
                Patient patient = new Patient(identity,NAME.getText(),FATHER_NAME.getText(),gendr,datee,d,dHistory.getText(),discription.getText());
                int id = patient.getid();
                String name = patient.getName();
                String FName = patient.getFatherName();
                String dh = patient.getDiseaseHistory();
                String dscrptn = patient.getPrescription();
                String gender1 = patient.getGender();
                java.sql.Date sqlDate = (Date) patient.getDateOfBirth();
                patientDatabase.insertPatient(id,name,FName,d,dh,dscrptn,gender1,sqlDate);
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
        addNewPatient.add(top);
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
}

class DateLabelFormatter extends JFormattedTextField.AbstractFormatter
{
    private String datePattern = "dd-MM-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException
    {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
        Calendar cal = (Calendar) value;
        return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}