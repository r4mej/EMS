package ems;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete, back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setLayout(null);
    
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setForeground(Color.WHITE);
        labelempId.setBounds(50, 46, 100, 30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(150, 50, 150, 30);
        add(cEmpId);
    
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setForeground(Color.WHITE);
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone #");
        labelphone.setForeground(Color.WHITE);
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setForeground(Color.WHITE);
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setForeground(Color.WHITE);
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setForeground(Color.WHITE);
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                        try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);

                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(50, 300, 100, 30);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(190, 300, 100, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("icons/train.jpg")); //image from unsplash
            Image g = b.getImage().getScaledInstance(650, 400, Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(g);
            JLabel image = new JLabel(bg);
            image.setBounds(350, 0, 650, 400);
            add(image);
        
        setSize(1000, 400);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully.");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
