package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add, view, update, remove, back;
    
    Home(){
        
        setLayout(null);
        setResizable(false);
        
        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); //image from unsplash
            Image g = b.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(g);
            JLabel image = new JLabel(bg);
            image.setBounds(0, 0, 1120, 630);
            add(image);
        
        JLabel head = new JLabel("Employee Management System");
        head.setBounds(650, 20, 400, 40);
        head.setFont(new Font("Tahoma", Font.BOLD, 25));
        head.setForeground(Color.WHITE);
        image.add(head);
        
         add = new JButton("Add Employee");
        add.setBounds(680, 80, 150, 40);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        image.add(add);
        
         view = new JButton("View Employees");
        view.setBounds(850, 80, 150, 40);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        image.add(view);
        
         update = new JButton("Update Employee");
        update.setBounds(680, 140, 150, 40);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        image.add(update);
        
         remove = new JButton("Remove Employee");
        remove.setBounds(850, 140, 150, 40);
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.addActionListener(this);
        image.add(remove);
        
        back = new JButton("Back to login");
        back.setBounds(770, 200, 150, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
            
        setSize(1120, 630);
        setLocation(120, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        } else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployees();
        } else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployees();
        } else if(ae.getSource() == remove){
            setVisible(false);
            new RemoveEmployee();
        } else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}
