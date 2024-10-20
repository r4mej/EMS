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
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
        
        passwordpf.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                actionPerformed(null);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    });
        
        JButton login = new JButton("Login");
            login.setBounds(130, 200, 100, 30);
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
    
    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            String username = usernametf.getText();
            String password = passwordpf.getText();
            
            Conn c = new Conn();
            Conn c1 = new Conn();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            String query1 = "select * from employee where email = '"+username+"' and empid = '"+password+"' ";
            
            ResultSet rs = c.s.executeQuery(query);
            ResultSet rs1 = c1.s.executeQuery(query1);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Welcome! " +usernametf.getText());
                setVisible(false);
                new Home();
            }else if(rs1.next()){
                JOptionPane.showMessageDialog(null, "Welcome, " + "employee " + passwordpf.getText());
                setVisible(false);
                new EmployeeView(passwordpf.getText());
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
