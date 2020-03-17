package PersistenceLayer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DoctorDatabase
{
    DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
    public void insertDoctor(String name,String disease) //working
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM doctor");
        int id=0 ;
        while(resultSet.next())
            {
            id = resultSet.getInt(1);
            }
        String sql = "INSERT INTO doctor (doctorID,doctorName,diseaseID) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id+1);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3,diseaseDatabase.diseaseID(disease));
        int row = preparedStatement.executeUpdate();
        if (row > 0)
            {
            JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
        connection.close();
        }catch(Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Error occured !!!");
            }
    }
    public String[] doctorList()
    {
        String [] list = new String[0];
        Connection connection = Database.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM doctor");
        int i=0;
        while(resultSet.next())
            {
            i++;
            }
        list = new String[i];i = 0;
        resultSet = statement.executeQuery("SELECT * FROM doctor");
        while(resultSet.next())
            {
            list[i] = resultSet.getString("doctorName");
            i++;
            }
        statement.close();
        connection.close();

        } catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.out.println("Exception occured.");
            }
        return list;
    }
    public String [][] searchDoctorByNAME(String name) //working
    {
        String[][] multD = new String[1][3];
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM doctor WHERE doctorName LIKE '%"+name+"%'";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                multD[0][0] = Integer.toString(RSet.getInt("doctorID"));
                multD[0][1] = RSet.getString("doctorName");
                multD[0][2] = RSet.getString("diseaseID");
                }
            for(int c = 0; c<3;c++){
            System.out.println(multD[0][c]);}
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return multD;

    }
    public String [][] searchDoctorBySpacialization(String name) //not working
    {
        String[][] multD = new String[1][3];
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM doctor WHERE doctorName LIKE '%"+name+"%'";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                multD[0][0] = Integer.toString(RSet.getInt("doctorID"));
                multD[0][1] = RSet.getString("name");
                multD[0][2] = RSet.getString("diseaseID");
                }
            for(int c = 0; c<3;c++){
            System.out.println(multD[0][c]);}
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return multD;

    }
}
