package ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EMS extends JFrame implements ActionListener{
    
        EMS(){
            
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(Color.BLACK);
            
            JLabel head = new JLabel("Employee Management System");
            head.setBounds(310, 30, 1200, 60);
            head.setFont(new Font("Tahoma", Font.PLAIN, 40));
            head.setForeground(Color.WHITE);
            add(head);
            
            ImageIcon b = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg")); //image from unsplash
            Image g = b.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(g);
            JLabel image = new JLabel(bg);
            image.setBounds(50, 100, 1050, 500);
            add(image);
            
            JButton click = new JButton("Click here to continue");
            click.setBounds(360, 50, 300, 40);
            click.setBackground(Color.WHITE);
            click.setForeground(Color.BLACK);
            click.addActionListener(this);
            image.add(click);
            
            
            setSize(1170, 650);
            setLocation(100, 50);
            setVisible(true);
            
        }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
        
    public static void main(String[] args) {
        new EMS();
    }
    
}
