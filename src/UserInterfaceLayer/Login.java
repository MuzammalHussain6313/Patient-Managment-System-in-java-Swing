package UserInterfaceLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login
{
    JFrame frame = new JFrame("Login");
    JPanel mainlogin = new JPanel();


    public JPanel Login()
    {
        frame.setBounds(200,200,620,430);
        JPanel login = new JPanel();
        login.setBounds(0,0,600,400);
        JLabel uLabel = new JLabel("User Name");
        JLabel pLabel = new JLabel("Password");
        JLabel forgetPass = new JLabel("forget Password");
        forgetPass.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                login.setVisible(false);
                mainlogin.setBounds(0,0,610,410);
                mainlogin.setVisible(false);
                mainlogin = forgetPassword();
                mainlogin.setVisible(true);
                frame.add(mainlogin);
            }
        });
        JLabel msg = new JLabel("Invalid User Name or Password ");

        JTextField uname = new JTextField();
        JPasswordField pass = new JPasswordField();

        Font f = new Font("Arial", Font.BOLD, 15);
        String [] user = {"Admin","Guest"};
        JComboBox userType = new JComboBox(user);
        userType.setFont(f);
        // Step 10 : Creating an object of JButton
        JButton loginbtn = new JButton("Login");
        JButton signUp = new JButton("Sign UP");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                login.setVisible(false);
                mainlogin.setBounds(0,0,610,430);
                mainlogin.setVisible(false);
                mainlogin = signUP();
                mainlogin.setVisible(true);
                frame.add(mainlogin);
            }
        });
        login.setLayout(null);

        uLabel.setBounds(100, 50, 100, 40);
        pLabel.setBounds(100, 140, 100, 40);

        uname.setBounds(250, 50, 200, 40);
        pass.setBounds(250, 140, 200, 40);

        userType.setBounds(250,200,200,40);
        loginbtn.setBounds(100, 280, 100, 40);
        signUp.setBounds(250,280,100,40);
        forgetPass.setFont(f);
        forgetPass.setBounds(400,280,120,40);//setting location and size of JButton
        loginbtn.setFont(f);
        signUp.setFont(f);
        forgetPass.setFont(f);
        loginbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Admin admin = new Admin();
                admin.mainFrame();
                frame.dispose();
            }
        });
        uLabel.setFont(f);
        pLabel.setFont(f);

        uname.setFont(f);
        pass.setFont(f);

        login.add(uLabel);
        login.add(pLabel);

        login.add(uname);
        login.add(pass);
        login.add(loginbtn);
        login.add(msg);
        login.add(signUp);
        login.add(forgetPass);
        login.add(userType);
        // adding success label to the container
        //adding JButton to the container
        login.setLayout(null);
        login.setVisible(true);
        frame.add(login);
        frame.setVisible(true);
        frame.setLayout(null);
        return login;
    }
    public JPanel forgetPassword()
    {
        JPanel forgetPassword = new JPanel();
        forgetPassword.setBounds(0,0,650,430);
        JLabel userName = new JLabel("User Name");
        JLabel password = new JLabel("New Password");
        JLabel newPassword = new JLabel("confarm Password");
        JLabel msg = new JLabel("Invalid User Name or Password ");

        JTextField uname = new JTextField();
        JPasswordField newpassword = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        Font f = new Font("Arial", Font.BOLD, 15);

        // Step 10 : Creating an object of JButton
        JButton loginbtn = new JButton("Change Password");

        forgetPassword.setLayout(null);

        userName.setBounds(100, 50, 150, 40);
        password.setBounds(100, 140, 150, 40);
        newPassword.setBounds(100,230,150,40);

        uname.setBounds(300, 50, 200, 40);
        newpassword.setBounds(300, 140, 200, 40);
        confirmPassword.setBounds(300,230,200,40);

        loginbtn.setBounds(280, 330, 140, 50);    //setting location and size of JButton
        loginbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Login login = new Login();
                mainlogin.setBounds(0,0,610,430);
                login.mainlogin.setVisible(false);
                login.mainlogin = Login();
                login.mainlogin.setVisible(true);
                login.frame.add(mainlogin);
            }
        });

        userName.setFont(f);
        password.setFont(f);
        newPassword.setFont(f);

        uname.setFont(f);
        newpassword.setFont(f);
        confirmPassword.setFont(f);

        forgetPassword.add(userName);
        forgetPassword.add(password);
        forgetPassword.add(newPassword);
        forgetPassword.add(confirmPassword);
        forgetPassword.add(uname);
        forgetPassword.add(newpassword);
        forgetPassword.add(loginbtn);
        forgetPassword.add(msg);
        // adding success label to the container
        //adding JButton to the container
        forgetPassword.setLayout(null);
        forgetPassword.setVisible(true);
        return forgetPassword;
    }
    public JPanel signUP()
    {
        JPanel signUP = new JPanel();
        signUP.setBounds(0,0,650,430);
        JLabel userName = new JLabel("New User Name");
        JLabel password = new JLabel("New Password");
        JLabel newPassword = new JLabel("confarm Password");
        JLabel msg = new JLabel("Invalid User Name or Password ");

        JTextField uname = new JTextField();
        JPasswordField newpassword = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        Font f = new Font("Arial", Font.BOLD, 15);

        // Step 10 : Creating an object of JButton
        JButton signUpbtn = new JButton("SignUp");

        signUP.setLayout(null);

        userName.setBounds(100, 50, 150, 40);
        password.setBounds(100, 140, 150, 40);
        newPassword.setBounds(100,230,150,40);

        uname.setBounds(300, 50, 200, 40);
        newpassword.setBounds(300, 140, 200, 40);
        confirmPassword.setBounds(300,230,200,40);

        signUpbtn.setBounds(280, 330, 140, 50);    //setting location and size of JButton
        signUpbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Login login = new Login();
                mainlogin.setBounds(0,0,610,430);
                login.mainlogin.setVisible(false);
                login.mainlogin = Login();
                login.mainlogin.setVisible(true);
                login.frame.add(mainlogin);
            }
        });
        userName.setFont(f);
        password.setFont(f);
        newPassword.setFont(f);

        uname.setFont(f);
        newpassword.setFont(f);
        confirmPassword.setFont(f);

        signUP.add(userName);
        signUP.add(password);
        signUP.add(newPassword);
        signUP.add(confirmPassword);
        signUP.add(uname);
        signUP.add(newpassword);
        signUP.add(signUpbtn);
        signUP.add(msg);
        signUP.setLayout(null);
        signUP.setVisible(true);
        return signUP;
    }
    public static void main(String a[])
    {
        Login login = new Login();
        login.Login();
    }
}
