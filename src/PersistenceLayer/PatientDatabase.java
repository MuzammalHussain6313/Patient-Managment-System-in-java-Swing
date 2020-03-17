package PersistenceLayer;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PatientDatabase
{
    public void insertPatient(int id,String name,String fathername,String doctor,String dHistroy,String discription,String gender,Date date)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT doctorID FROM doctor WHERE name ='" + doctor + "'");
        int idd=0 ;
        while(resultSet.next())
            {
            idd = resultSet.getInt(1);
            }
        System.out.println(idd);
        String sql = "INSERT INTO patient (id,name,fatherName,gender,dateOfBirth,doctorID,diseaseHistory,prescription) VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, fathername);
        preparedStatement.setString(4, gender);
        preparedStatement.setDate(5, date);
        preparedStatement.setInt(6, idd);
        preparedStatement.setString(7, dHistroy);
        preparedStatement.setString(8, discription);
        int row = preparedStatement.executeUpdate();
        if (row > 0)
            {
            JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
        connection.close();
        } catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
            }
    }
    public void deletePatient(String name, String fname) // working
    {
        Connection connection = Database.getConnection();
        try
            {
            String sql = "DELETE FROM patient WHERE name=? AND fatherName=?";
            //String sql = "DELETE FROM patient WHERE (name = " + name + " AND fatherName = " + fname + ")";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2,fname);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                {
                JOptionPane.showMessageDialog(null,"A user was deleted successfully!");
                }
            connection.close();
            } catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
            }
    }
    public String[][] searchPatientByID(int iD) //working
    {
        String[][] multD = new String[1][8];
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM patient WHERE id = "+iD+"";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                multD[0][0] = Integer.toString(RSet.getInt("id"));
                multD[0][1] = RSet.getString("name");
                multD[0][2] = RSet.getString("fatherName");
                multD[0][3] = RSet.getString("gender");
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                multD[0][4] = df.format(RSet.getDate("dateOfBirth"));
                multD[0][5] = Integer.toString(RSet.getInt("doctorID"));
                multD[0][6] = RSet.getString("diseaseHistory");
                multD[0][7] = RSet.getString("prescription");
                }
            for(int c = 0; c<8;c++){
            System.out.println(multD[0][c]);}
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return multD;
    }
    public void searchPatientByDisease(String Dname) // not working
    {
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            ////////////// That statement as well as next statement is also working ////////////////////
            //String sqll = "SELECT name, fatherName FROM patient WHERE name = '"+name+"' AND fatherName = '"+Fname+"'";
            //String sqll = "SELECT * FROM patient NATURAL JOIN disease WHERE name LIKE '%"+Dname+"%'";
            //"SELECT * FROM Contacts WHERE Name LIKE '%'"+name+"'%' AND TelePhoneNumber LIKE '"+tpNumber+"%' OR Address LIKE '%'"+address+"'%' OR Description LIKE '%'"+description+"'%'";
            String sqll = "SELECT * FROM patient NATURAL JOIN doctor";
            ResultSet rSet = statement1.executeQuery(sqll);
            //contactTableInDefaultForm.setModel(DbUtils.resultSetToTableModel(rs));
            while (rSet.next())
                {
                if(rSet.getString("doctorName").equals(Dname))
                    {
                    JOptionPane.showMessageDialog(null, "ID : " + rSet.getInt("id") + "\nName :" + rSet.getString("name") + "\nFather Name : " + rSet.getString("fatherName") + "\nGender " + rSet.getString("gender") + "\nDate Of Birth" + rSet.getDate("dateOfBirth") + "\nDoctor ID : " + rSet.getInt("doctorID") + "\nDisease History" + rSet.getString("diseaseHistory") + "\nPrescription : " + rSet.getString("prescription"));
                    }
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

    }
    public void searchPatientByAge(int age) // not working
    {
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT *, YEAR(CURDATE()) - YEAR(dateOfBirth) AS age FROM patient";
            ResultSet rSet = statement1.executeQuery(sqll);
            int array[] = new int[10];int i=0;
            while (rSet.next())
                {
                if(rSet.getInt("age")==age)
                    {
                    JOptionPane.showMessageDialog(null,"ID : "+rSet.getInt("id")+"\nName :" + rSet.getString("name")+"\nFather Name : "+rSet.getString("fatherName")+"\nGender "+rSet.getString("gender")+"\nDate Of Birth"+rSet.getDate("dateOfBirth")+"\nDoctor ID : "+rSet.getInt("doctorID")+"\nDisease History"+rSet.getString("diseaseHistory")+"\nPrescription : "+rSet.getString("prescription"));
                    }
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

    }
    public String [][] searchPatientByNAME(String name) //working
    {
        String[][] multD = new String[1][8];
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM patient WHERE name LIKE '%"+name+"%'";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                multD[0][0] = Integer.toString(RSet.getInt("id"));
                multD[0][1] = RSet.getString("name");
                multD[0][2] = RSet.getString("fatherName");
                multD[0][3] = RSet.getString("gender");
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                multD[0][4] = df.format(RSet.getDate("dateOfBirth"));
                multD[0][5] = Integer.toString(RSet.getInt("doctorID"));
                multD[0][6] = RSet.getString("diseaseHistory");
                multD[0][7] = RSet.getString("prescription");
                }
            for(int c = 0; c<8;c++){
            System.out.println(multD[0][c]);}
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return multD;

    }
    public String[][] searchPatientRecord(String name,String Fname) // Working
    {
        String[][] multD = new String[1][8];
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT * FROM patient WHERE name LIKE '%"+name+"%' OR fatherName LIKE '%"+Fname+"%'";
            ResultSet rSet = statement1.executeQuery(sqll);
            while (rSet.next())
                {
                multD[0][0] = Integer.toString(rSet.getInt("id"));
                multD[0][1] = rSet.getString("name");
                multD[0][2] = rSet.getString("fatherName");
                multD[0][3] = rSet.getString("gender");
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                multD[0][4] = df.format(rSet.getDate("dateOfBirth"));
                multD[0][5] = Integer.toString(rSet.getInt("doctorID"));
                multD[0][6] = rSet.getString("diseaseHistory");
                multD[0][7] = rSet.getString("prescription");
                JOptionPane.showMessageDialog(null,"ID : "+rSet.getInt("id")+"\nName :" + rSet.getString("name")+"\nFather Name : "+rSet.getString("fatherName")+"\nGender "+rSet.getString("gender")+"\nDate Of Birth"+rSet.getString("dateOfBirth")+"\nDoctor ID : "+rSet.getInt("doctorID")+"\nDisease History"+rSet.getString("diseaseHistory")+"\nPrescription : "+rSet.getString("prescription"));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return multD;
    }
    public int getPatientID() // working
    {
        int id = 0;
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT * FROM patient";
            ResultSet rSet = statement1.executeQuery(sqll);
            while (rSet.next())
                {
                id = rSet.getInt(1);
                }
            System.out.println(id);
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return id;
    }
    public void searchPatientByDoctor(String name) // not working
    {
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            ////////////// That statement as well as next statement is also working ////////////////////
            //String sqll = "SELECT name, fatherName FROM patient WHERE name = '"+name+"' AND fatherName = '"+Fname+"'";
            String sqll = "SELECT * FROM patient NATURAL JOIN doctor WHERE name LIKE '%"+name+"%'";
            //"SELECT * FROM Contacts WHERE Name LIKE '%'"+name+"'%' AND TelePhoneNumber LIKE '"+tpNumber+"%' OR Address LIKE '%'"+address+"'%' OR Description LIKE '%'"+description+"'%'";
            ResultSet rSet = statement1.executeQuery(sqll);
            //contactTableInDefaultForm.setModel(DbUtils.resultSetToTableModel(rs));
            while (rSet.next())
                {

                JOptionPane.showMessageDialog(null,"ID : "+rSet.getInt("id")+"\nName :" + rSet.getString("name")+"\nFather Name : "+rSet.getString("fatherName")+"\nGender "+rSet.getString("gender")+"\nDate Of Birth"+rSet.getString("dateOfBirth")+"\nDoctor ID : "+rSet.getString("doctorID")+"\nDisease History"+rSet.getString("diseaseHistory")+"\nPrescription : "+rSet.getString("prescription"));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

    }
    public static void main(String a[])
    {
        PatientDatabase p = new PatientDatabase();
        p.searchPatientByDisease("ali Hamza");
    }
}
