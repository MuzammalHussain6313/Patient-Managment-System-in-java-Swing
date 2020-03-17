package UserInterfaceLayer;
import PersistenceLayer.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class Admin
{
    JFrame frame = new JFrame("Manager Infromation System");
    Font font1 = new Font("Arial", Font.BOLD, 15);
    JPanel panel = new JPanel();
    public Admin()
    {
        // empty constructor
    }
    public void mainFrame()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu mngRecord, SEARCH_BY, help;
        mngRecord = new JMenu("Manage Record");
        SEARCH_BY = new JMenu("SEARCH BY");
        help = new JMenu("Help");
        JMenuItem addNewPatient = new JMenuItem("Add New Patient");
        JMenuItem searchPatientRecord = new JMenuItem("Search Patient Record");
        JMenuItem addNewDoctor = new JMenuItem("Add New Doctor");
        JMenuItem addNewDisease = new JMenuItem("Add New Disease");
        JMenuItem deletePatientRecord = new JMenuItem("Delete Patient Record");
        JMenu updateRecord = new JMenu("Update Record");
        JMenuItem updateDoctor = new JMenuItem("Update Doctor");
        JMenuItem updatePatient = new JMenuItem("Update Patient");
        JMenuItem searchPatietByID = new JMenuItem("Search Patient By ID");
        JMenuItem searchPatietByName = new JMenuItem("Search Patient By Name");
        JMenuItem searchPatietByAge = new JMenuItem("Search Patient By Age");
        JMenuItem searchPatietByDisease = new JMenuItem("Search Patient By Diease");
        JMenuItem searchPatietByDoctor = new JMenuItem("Search Patient By Doctor");
        JMenuItem searchDoctorByName = new JMenuItem("Search Doctor By Name");
        JMenuItem searchDoctorByDiseaseSpacialization = new JMenuItem("Search doctor By Disease Spacialization");
        JMenuItem aboutUS = new JMenuItem("About Us");
        JMenuItem changePassword = new JMenuItem("Change Password");
        addNewPatient.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame patientFrame = new JFrame("Add new Patient");
                panel.setVisible(false);
                AddNewRecord patient = new AddNewRecord();
                panel = patient.addNewPatient();
                panel.setBounds(50,150,800,500);
                panel.setVisible(true);
                patientFrame.getContentPane().add(panel);
                patientFrame.setBounds(100,100,850,550);
                patientFrame.setVisible(true);
            }
        });
        searchPatientRecord.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search patient = new Search();
                panel = patient.searchPatientRecord();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        addNewDoctor.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                AddNewRecord doctor = new AddNewRecord();
                panel = doctor.addNewDoctor();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                //panel.setBounds(50,50,700,500);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        addNewDisease.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                AddNewRecord add = new AddNewRecord();
                panel = add.addNewDisease();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        deletePatientRecord.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                DeletePatientRecord delete = new DeletePatientRecord();
                panel = delete.deletePatient();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        updateDoctor.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UpdateData updateData = new UpdateData();
                updateData.updateDoctorSuppoter();
            }
        });

        updatePatient.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UpdateData updateData = new UpdateData();
                updateData.updatePatientSuppoter();
            }
        });

        searchPatietByID.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchPatientByID();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchPatietByName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchPatientByname();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchPatietByAge.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchPatientByAge();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchPatietByDisease.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchPatientByDisease();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchPatietByDoctor.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchPatientByDoctor();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchDoctorByName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchDoctorByName();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        searchDoctorByDiseaseSpacialization.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchDoctorBySpacialization();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        aboutUS.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Admin patient = new Admin();
                panel = patient.aboutUS();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        changePassword.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Login patient = new Login();
                panel = patient.forgetPassword();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        mngRecord.setFont(font1);
        SEARCH_BY.setFont(font1);
        help.setFont(font1);
        addNewPatient.setFont(font1);
        searchPatientRecord.setFont(font1);
        addNewDoctor.setFont(font1);
        addNewDisease.setFont(font1);
        deletePatientRecord.setFont(font1);
        updateRecord.setFont(font1);
        updateDoctor.setFont(font1);
        updatePatient.setFont(font1);
        searchPatietByID.setFont(font1);
        searchPatietByName.setFont(font1);
        searchPatietByAge.setFont(font1);
        searchPatietByDisease.setFont(font1);
        searchPatietByDoctor.setFont(font1);
        searchDoctorByName.setFont(font1);
        searchDoctorByDiseaseSpacialization.setFont(font1);
        aboutUS.setFont(font1);
        changePassword.setFont(font1);

        menuBar.setBounds(0, 0, 1500, 40);
        menuBar.setBackground(Color.pink);
        mngRecord.add(addNewPatient);
        mngRecord.add(searchPatientRecord);
        mngRecord.add(addNewDoctor);
        mngRecord.add(addNewDisease);
        mngRecord.add(deletePatientRecord);
        mngRecord.add(updateRecord);
        updateRecord.add(updateDoctor);
        updateRecord.add(updatePatient);
        SEARCH_BY.add(searchPatietByName);
        SEARCH_BY.add(searchPatietByID);
        SEARCH_BY.add(searchPatietByAge);
        SEARCH_BY.add(searchPatietByDisease);
        SEARCH_BY.add(searchPatietByDoctor);
        SEARCH_BY.add(searchDoctorByName);
        SEARCH_BY.add(searchDoctorByDiseaseSpacialization);
        help.add(aboutUS);
        help.add(changePassword);
        menuBar.add(mngRecord);
        menuBar.add(SEARCH_BY);
        menuBar.add(help);

        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0,40,1500,50);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Button_Add_Icon_48.png"));
        JButton addButton = new JButton();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                AddNewRecord p = new AddNewRecord();
                panel = p.addNewPatient();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        addButton.setToolTipText("Add New Patient");
        addButton.setIcon(imageIcon);
        addButton.setBounds(100,100,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        toolBar.add(addButton );

        ImageIcon searchIcon = new ImageIcon(getClass().getResource("icons8-search-50.png"));
        JButton searchButton = new JButton();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search patient = new Search();
                panel = patient.searchPatientRecord();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        searchButton.setToolTipText("Search Patient Rocord");
        searchButton.setIcon(searchIcon);
        searchButton.setBounds(100,100,searchIcon.getIconWidth(),searchIcon.getIconHeight());
        toolBar.add(searchButton);

        ImageIcon addIcon = new ImageIcon(getClass().getResource("Button_Add_Icon_48.png"));
        JButton add = new JButton();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                AddNewRecord doctor = new AddNewRecord();
                panel = doctor.addNewDoctor();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        add.setToolTipText("Add New Doctor");
        add.setIcon(addIcon);
        add.setBounds(100,100,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        toolBar.add(add);

        ImageIcon printIcon = new ImageIcon(getClass().getResource("icons8-print-50.png"));
        JButton printButton = new JButton();
        printButton.setToolTipText("Print");
        printButton.setIcon(printIcon);
        printButton.setBounds(50,50,printIcon.getIconWidth(),printIcon.getIconHeight());
        toolBar.add(printButton);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(Color.DARK_GRAY);
        frame.setBounds(250, 50, 1000, 650);
        frame.add(menuBar);
        frame.add(toolBar);

    }
    public JPanel aboutUS()
    {
        JPanel aboutusPanel = new JPanel();
        aboutusPanel.setBounds(0,0,700,600);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(20,20,500,500);
        String text = "Strong is an exemplary teaching hospital with advanced scientific " +
                "\nproficiencies, robust patient care services, and formidable community \n" +
                "relations. These qualities and the dedicated staff who support them are \n" +
                "precisely what elevate Strong’s reputation. As a teaching hospital, all of \n" +
                "Strong’s medical clinicians are clinician scholars with faculty appointments \n" +
                "(at the University of Rochester School of Medicine and Dentistry) who \n" +
                "supervise\n" +
                " residents and participate in the education of residents and students. \n" +
                "The result is a learning environment immersed in research, education, \n" +
                "community, and innovation—Medicine of the Highest Order.\n" +
                "Strong is also characterized by having medical clinicians who are comfortable \n" +
                "working with many other specialists in an interdisciplinary, team-based \n" +
                "environment. Familiarity and ease with this level of collaboration allows \n" +
                "staff to harness the powerful interaction of three distinct but interrelated \n" +
                "missions: research, education, and patient care. The fruit of this interaction\n" +
                " is found in not only how clinicians teach but also how they practice. Indeed,\n" +
                " all of Strong’s staff is committed to consistently delivering a high quality \n" +
                "patient experience. This includes working to build partnerships with patients\n" +
                " and their families along with identifying ways to empower patients with \n" +
                "information and the tools they need to make informed decisions about their \n" +
                "health care.\nWhat This Means for You As a result of Strong’s approach, \n" +
                "each and every patient has an extensive number of specialists who can be \n" +
                "seamlessly integrated into their health care team. A condition is never \n" +
                "isolated. Patients always have a team of people and specialists taking care\n" +
                " of them, all supported with the highest technology. That technology also \n" +
                "applies to communication. All of a patient’s medical information is \n" +
                "consolidated into a single medical record thus eliminating potential for \n" +
                "miscommunication.This means that if you go in for a standard procedure \n" +
                "and there is a complication, a specialist is on hand to be instantly \n" +
                "included into your health care team. Moreover, that specialist represents \n" +
                "the most advanced medical care and research. When you combine this expertise\n" +
                "with Strong’s philosophy of developing a meaningful partnership with patients\n" +
                "and families the result is nothing short of a transformational patient \n" +
                "experience.\n";
        textArea.setText(text);
        textArea.setEditable(false);
        JScrollPane s = new JScrollPane();
        s.setBounds(20,20,600,500);
        s.add(textArea);
        s.setLayout(null);
        JScrollBar sb = new JScrollBar();
        s.setVerticalScrollBar(sb);
        s.setHorizontalScrollBar(sb);

        aboutusPanel.add(s);
        aboutusPanel.setVisible(true);
        aboutusPanel.setLayout(null);
        return aboutusPanel;
    }
    public static void main(String args [])
    {

    }
}