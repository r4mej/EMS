package ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField usernametf;
    JPasswordField passwordpf;
    
    Login(){
        
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(30, 20, 100, 30);
        usernamelbl.setForeground(Color.WHITE);
        add(usernamelbl);
        
         usernametf = new JTextField();
        usernametf.setBounds(110, 20, 210, 30);
        add(usernametf);
        
        JLabel passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(30, 70, 100, 30);
        passwordlbl.setForeground(Color.WHITE);
        add(passwordlbl);
        
         passwordpf = new JPasswordField();
        passwordpf.setBounds(110, 70, 210, 30);
        add(passwordpf);
        
        JButton login = new JButton("Login");
            login.setBounds(150, 150, 100, 30);
            login.setBackground(Color.WHITE);
            login.setForeground(Color.BLACK);
            login.addActionListener(this);
            add(login);
              
        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg")); //image from unsplash
            Image g = b.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(g);
            JLabel image = new JLabel(bg);
            image.setBounds(350, 0, 262, 262);
            add(image);
            
        setSize(600, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            String username = usernametf.getText();
            String password = passwordpf.getText();
            
            Conn c = new Conn();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Welcome! " +usernametf.getText());
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
                setVisible(false);
                new EMS();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}
