package ems;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemployeeId, cemployeeName;
    JButton search, search1, view, print, update, back;
    
    ViewEmployees(){
        setLayout(null);
        setResizable(false);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(30,20,150,20);
        add(searchlbl);
        
        JLabel searchlbl1 = new JLabel("Search by Employee Name");
        searchlbl1.setBounds(450,20,160,20);
        add(searchlbl1);
        
        cemployeeName = new Choice();
        cemployeeName.setBounds(620, 20, 150, 20);
        add(cemployeeName);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
                cemployeeName.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(30, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(350, 20, 80, 20);
        search.addActionListener(this);
        add(search);
        
        search1 = new JButton("Search");
        search1.setBounds(800, 20, 80, 20);
        search1.addActionListener(this);
        add(search1);
        
        view = new JButton("View");
        view.setBounds(30, 70, 80, 20);
        view.addActionListener(this);
        add(view);
        
        print = new JButton("Print");
        print.setBounds(130, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(230, 70, 80, 20);
        update.setBackground(Color.GREEN);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(330, 70, 80, 20);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1000, 700);
        setLocation(250, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == search1){
            String query1 = "select * from employee where name = '"+cemployeeName.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
               
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee(cemployeeId.getSelectedItem());
        }
        else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == update){
            setVisible(false);
            new UpdateEmployee1(cemployeeId.getSelectedItem());
        } else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new ViewEmployees();
    }
}
