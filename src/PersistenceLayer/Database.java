package PersistenceLayer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Database
{
    public static Connection getConnection() //working
    {
    Connection connection = null;
    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "12345");
        } catch (Exception e)
        {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    return connection;
    }
    public static void main(String args[])
    {
        Database db = new Database();
        if(Database.getConnection()!=null)
        {
            System.out.println("connected");
        }
    }
}