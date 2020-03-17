package PersistenceLayer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DiseaseDatabase
{
    public int diseaseID(String disease) // working
    {
        int id = 0;
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT diseaseID FROM disease WHERE diseaseName = '" + disease + "'";
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
    public String[] diseaseList() //working
    {
        String [] list = new String[0];
        Connection connection = Database.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM disease");
        int i=0;
        while(resultSet.next())
            {
            i++;
            }
        list = new String[i];i = 0;
        resultSet = statement.executeQuery("SELECT * FROM disease");
        while(resultSet.next())
            {
            list[i] = resultSet.getString("diseaseName");
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
    public void insertDisease(String name, String discription) // working
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM disease");
        int id=0 ;
        while(resultSet.next())
            {
            id = resultSet.getInt(1);
            }
        System.out.println("id"+id);
        String sql = "INSERT INTO disease (diseaseID,diseaseName,discription) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id+1);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, discription);
        int row = preparedStatement.executeUpdate();
        if (row > 0)
            {
            JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
        connection.close();
        }catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,"Error occured !!!");
            }
    }
}
