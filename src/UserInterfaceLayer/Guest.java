package UserInterfaceLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guest
{
    JFrame frame = new JFrame("Manager Infromation System");
    Font font1 = new Font("Arial", Font.BOLD, 15);
    JPanel panel = new JPanel();
    public void mainFrame()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu print, SEARCH_BY, help;
        print = new JMenu("Print");
        SEARCH_BY = new JMenu("SEARCH BY");
        help = new JMenu("Help");
        JMenuItem searchByName,searchByAge,searchByID,aboutUS,changePassword;
        searchByID = new JMenuItem("Search By ID");
        searchByID.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchByIDForGuest();
                panel.setBounds(50,150,800,650);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        searchByName = new JMenuItem("Search By Name");
        searchByName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchByNameForGuest();
                panel.setBounds(50,150,800,650);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        searchByAge = new JMenuItem("Search By Age");
        searchByAge.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.setVisible(false);
                Search search = new Search();
                panel = search.searchByAgeForGuest();
                panel.setBounds(50,150,700,500);
                panel.setVisible(true);
                frame.getContentPane().add(panel);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });

        aboutUS = new JMenuItem("About Us");
        aboutUS.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //manager.search(2);
            }
        });
        changePassword = new JMenuItem("Change Password");
        changePassword.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //manager.search(2);
            }
        });
        print.setFont(font1);
        SEARCH_BY.setFont(font1);
        help.setFont(font1);
        aboutUS.setFont(font1);
        changePassword.setFont(font1);
        searchByAge.setFont(font1);
        searchByID.setFont(font1);
        searchByName.setFont(font1);
        menuBar.setBounds(0, 0, 1500, 40);
        menuBar.setBackground(Color.pink);
        SEARCH_BY.add(searchByName);
        SEARCH_BY.add(searchByID);
        SEARCH_BY.add(searchByAge);
        help.add(aboutUS);
        help.add(changePassword);
        menuBar.add(SEARCH_BY);
        menuBar.add(print);
        menuBar.add(help);

        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0,40,1500,50);
        ImageIcon searchIcon = new ImageIcon(getClass().getResource("icons8-search-50.png"));
        JButton search = new JButton();
        search.setIcon(searchIcon);
        search.setBounds(50,50,searchIcon.getIconWidth(),searchIcon.getIconHeight());
        toolBar.add(search);
        ImageIcon printIcon = new ImageIcon(getClass().getResource("icons8-print-50.png"));
        JButton printButton = new JButton();
        printButton.setIcon(printIcon);
        printButton.setBounds(50,50,printIcon.getIconWidth(),printIcon.getIconHeight());
        toolBar.add(printButton);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBounds(0, 0, 1500, 725);
        frame.add(menuBar);
        frame.add(toolBar);
    }
    public static void main(String args [])
    {
        Guest guest = new Guest();
        guest.mainFrame();
    }
}
