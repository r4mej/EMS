package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField eductf, fnametf, mothertf, addresstf, phonetf, idtf, emailtf, salarytf, designationtf;
    JLabel empidlabel;
    JButton add, back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId = empId;
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel head = new JLabel("Update Employee Details");
        head.setBounds(300, 30, 500, 50);
        head.setFont(new Font("sans serif", Font.BOLD, 25));
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(50, 150, 150, 30);
        namelbl.setFont(new Font("serif", Font.PLAIN, 20));
        namelbl.setForeground(Color.BLACK);
        add(namelbl);
        
        JLabel lblname = new JLabel();
        lblname.setForeground(Color.BLACK);
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        JLabel fnamelbl = new JLabel(" Father's Name");
        fnamelbl.setBounds(400, 150, 150, 30);
        fnamelbl.setFont(new Font("serif", Font.PLAIN, 20));
        fnamelbl.setForeground(Color.BLACK);
        add(fnamelbl);
        
        fnametf = new JTextField();
        fnametf.setBounds(600, 150, 150,30);
        add(fnametf);
        
        JLabel doblbl = new JLabel("Date of Birth");
        doblbl.setBounds(50, 200, 150, 30);
        doblbl.setFont(new Font("serif", Font.PLAIN, 20));
        doblbl.setForeground(Color.BLACK);
        add(doblbl);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel motherlbl = new JLabel(" Mother's Name");
        motherlbl.setBounds(400, 200, 150, 30);
        motherlbl.setFont(new Font("serif", Font.PLAIN, 20));
        motherlbl.setForeground(Color.BLACK);
        add(motherlbl);
        
        mothertf = new JTextField();
        mothertf.setBounds(600, 200, 150,30);
        add(mothertf);
        
        JLabel salarylbl = new JLabel(" Salary");
        salarylbl.setBounds(400, 250, 150, 30);
        salarylbl.setFont(new Font("serif", Font.PLAIN, 20));
        salarylbl.setForeground(Color.BLACK);
        add(salarylbl);
        
        salarytf = new JTextField();
        salarytf.setBounds(600, 250, 150,30);
        add(salarytf);
        
        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50, 250, 150, 30);
        addresslbl.setFont(new Font("serif", Font.PLAIN, 20));
        addresslbl.setForeground(Color.BLACK);
        add(addresslbl);
        
        addresstf = new JTextField();
        addresstf.setBounds(200, 250, 150,30);
        add(addresstf);
        
        JLabel phonelbl = new JLabel(" Phone #");
        phonelbl.setBounds(400, 300, 150, 30);
        phonelbl.setFont(new Font("serif", Font.PLAIN, 20));
        phonelbl.setForeground(Color.BLACK);
        add(phonelbl);
        
        phonetf = new JTextField();
        phonetf.setBounds(600, 300, 150,30);
        add(phonetf);
        
        JLabel emaillbl = new JLabel("Email Address");
        emaillbl.setBounds(50, 300, 150, 30);
        emaillbl.setFont(new Font("serif", Font.PLAIN, 20));
        emaillbl.setForeground(Color.BLACK);
        add(emaillbl);
        
        emailtf = new JTextField();
        emailtf.setBounds(200, 300, 150,30);
        add(emailtf);
        
        JLabel educlbl = new JLabel(" Highest Education");
        educlbl.setBounds(400, 350, 150, 30);
        educlbl.setFont(new Font("serif", Font.PLAIN, 20));
        educlbl.setForeground(Color.BLACK);
        add(educlbl);
        
        eductf = new JTextField();
        eductf.setBounds(600, 350, 150,30);
        add(eductf);
        
        JLabel designationlbl = new JLabel("Designation");
        designationlbl.setBounds(50, 350, 150, 30);
        designationlbl.setFont(new Font("serif", Font.PLAIN, 20));
        designationlbl.setForeground(Color.BLACK);
        add(designationlbl);
        
        designationtf = new JTextField();
        designationtf.setBounds(200, 350, 150,30);
        add(designationtf);
        
        JLabel idlbl = new JLabel(" Valid ID");
        idlbl.setBounds(400, 400, 150, 30);
        idlbl.setFont(new Font("serif", Font.PLAIN, 20));
        idlbl.setForeground(Color.BLACK);
        add(idlbl);
        
        JLabel lblid = new JLabel();
        lblid.setBounds(600, 400, 150,30);
        add(lblid);
        
        JLabel empidlbl = new JLabel("Employee ID");
        empidlbl.setBounds(50, 400, 150, 30);
        empidlbl.setFont(new Font("serif", Font.PLAIN, 20));
        empidlbl.setForeground(Color.BLACK);
        add(empidlbl);
        
        empidlabel = new JLabel();
        empidlabel.setBounds(200, 400, 150, 30);
        empidlabel.setFont(new Font("serif", Font.PLAIN, 20));
        empidlabel.setForeground(Color.BLACK);
        add(empidlabel);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                fnametf.setText(rs.getString("fname"));
                mothertf.setText(rs.getString("mname"));
                lbldob.setText(rs.getString("dob"));
                addresstf.setText(rs.getString("address"));
                salarytf.setText(rs.getString("salary"));
                emailtf.setText(rs.getString("email"));
                eductf.setText(rs.getString("education"));
                empidlabel.setText(rs.getString("empId"));
                designationtf.setText(rs.getString("designation"));
                phonetf.setText(rs.getString("phone"));
                lblid.setText(rs.getString("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.GREEN);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(240, 40);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String fname = fnametf.getText();
            String mname = mothertf.getText();
            String salary = salarytf.getText();
            String address = addresstf.getText();
            String phone = phonetf.getText();
            String email = emailtf.getText();
            String education = eductf.getText();
            String designation = designationtf.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', mname = '"+mname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully.");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
