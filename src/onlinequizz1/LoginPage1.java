package onlinequizz1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginPage1 extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;
    JPasswordField passwordField;
    Connection con;

    LoginPage1() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/frist1image.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(0, 0, 600, 500);
        add(image);
        JLabel heading = new JLabel("Simple Quiz");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("italic", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(750, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(700, 200, 300, 25);
        tfname.setFont(new Font("Times Now Roman", Font.BOLD, 20));
        add(tfname);

        JLabel passLabel = new JLabel("Enter your password");
        passLabel.setBounds(750, 250, 300, 20);
        passLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        passLabel.setForeground(new Color(30, 144, 254));
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(700, 300, 300, 25);
        passwordField.setFont(new Font("Times Now Roman", Font.BOLD, 20));
        add(passwordField);

        rules = new JButton("Login");
        rules.setBounds(735, 350, 120, 25);
        rules.setForeground(Color.WHITE);
        rules.setBackground(new Color(30, 144, 254));
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 350, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/simple_quiz";
            String username = "root";
            String password = "9949";
            con = DriverManager.getConnection(url, username, password);
            
            
          
            con.setCatalog("simple_quiz");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    private void createDatabase(String dbName) {
    try {
        Statement stmt = con.createStatement();
        String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
        stmt.executeUpdate(createDBQuery);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.rules) {
            String name = tfname.getText();
           
            String password = new String(passwordField.getPassword());

            
            boolean authenticated = authenticate(name, password);
            if (authenticated) {
                setVisible(false);
                new Rules(name);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
            }
        } else if (ae.getSource() == this.back) { 
            setVisible(false);
            
        }
    }

    private boolean authenticate(String username, String password) {
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM login1 WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new LoginPage1();
    }
}