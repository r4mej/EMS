package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class UpdateEmployee2 extends JFrame implements ActionListener{
    
    JTextField eductf, nametf, mnametf, lnametf, addresstf, phonetf, idtf, emailtf;
    JLabel empidlabel;
    JComboBox salarycb, educcb, idcb;
    JButton add, back;
    String empName;
    JDateChooser dcdob;
    
    UpdateEmployee2(String empName){
        this.empName = empName;
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel head = new JLabel("Update Employee Details");
        head.setBounds(320, 30, 500, 50);
        head.setFont(new Font("sans serif", Font.BOLD, 25));
        head.setForeground(Color.WHITE);
        add(head);
        
        JLabel namelbl = new JLabel("First Name");
        namelbl.setBounds(50, 150, 150, 30);
        namelbl.setFont(new Font("serif", Font.PLAIN, 20));
        namelbl.setForeground(Color.WHITE);
        add(namelbl);
        
        nametf = new JTextField();
        nametf.setBounds(200, 150, 150,30);
        add(nametf);
        
        JLabel fnamelbl = new JLabel("Middle Name");
        fnamelbl.setBounds(50, 200, 150, 30);
        fnamelbl.setFont(new Font("serif", Font.PLAIN, 20));
        fnamelbl.setForeground(Color.WHITE);
        add(fnamelbl);
        
        mnametf = new JTextField();
        mnametf.setBounds(200, 200, 150, 30);
        add(mnametf);
        
        JLabel doblbl = new JLabel("Date of Birth");
        doblbl.setBounds(50, 350, 150, 30);
        doblbl.setFont(new Font("serif", Font.PLAIN, 20));
        doblbl.setForeground(Color.WHITE);
        add(doblbl);
        //430, 150, 150, 30
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 350, 150, 30);
        lbldob.setForeground(Color.WHITE);
        add(lbldob);
        
        JLabel motherlbl = new JLabel("Last Name");
        motherlbl.setBounds(50, 250, 150, 30);
        motherlbl.setFont(new Font("serif", Font.PLAIN, 20));
        motherlbl.setForeground(Color.WHITE);
        add(motherlbl);
        
        lnametf = new JTextField();
        lnametf.setBounds(200, 250, 150,30);
        add(lnametf);
        
        JLabel salarylbl = new JLabel("Salary");
        salarylbl.setBounds(430, 250, 150, 30);
        salarylbl.setFont(new Font("serif", Font.PLAIN, 20));
        salarylbl.setForeground(Color.WHITE);
        add(salarylbl);
        
        String salary[] = {"Grade 1 (13K)", "Grade 2 (14K)", "Grade 3 (15K)", "Grade 4 (16K)", "Grade 5 (17K)"};
        
        salarycb = new JComboBox(salary);
        salarycb.setBounds(620, 250, 150,30);
        salarycb.setBackground(Color.WHITE);
        add(salarycb);
        
        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50, 300, 150, 30);
        addresslbl.setFont(new Font("serif", Font.PLAIN, 20));
        addresslbl.setForeground(Color.WHITE);
        add(addresslbl);
        
        addresstf = new JTextField();
        addresstf.setBounds(200, 300, 150,30);
        add(addresstf);
        
        JLabel phonelbl = new JLabel("Phone #");
        phonelbl.setBounds(430, 300, 150, 30);
        phonelbl.setFont(new Font("serif", Font.PLAIN, 20));
        phonelbl.setForeground(Color.WHITE);
        add(phonelbl);
        
        phonetf = new JTextField();
        phonetf.setBounds(620, 300, 150,30);
        add(phonetf);
        
        JLabel emaillbl = new JLabel("Email Address");
        emaillbl.setBounds(430, 200, 150, 30);
        emaillbl.setFont(new Font("serif", Font.PLAIN, 20));
        emaillbl.setForeground(Color.WHITE);
        add(emaillbl);
        
        emailtf = new JTextField();
        emailtf.setBounds(620, 200, 150,30);
        add(emailtf);
        
        JLabel educlbl = new JLabel("Highest Education");
        educlbl.setBounds(430, 350, 150, 30);
        educlbl.setFont(new Font("serif", Font.PLAIN, 20));
        educlbl.setForeground(Color.WHITE);
        add(educlbl);
        
        String courses[] = {"Elem UnderGrad", "Elem Grad", "HS UnderGrad", "HS Grad", "SHS UnderGrad", "SHS Grad", "College UnderGrad", "College Grad"};
        
        educcb = new JComboBox(courses);
        educcb.setBounds(620, 350, 150,30);
        educcb.setBackground(Color.WHITE);
        add(educcb);
        
//        JLabel designationlbl = new JLabel("Designation");
//        designationlbl.setBounds(50, 350, 150, 30);
//        designationlbl.setFont(new Font("serif", Font.PLAIN, 20));
//        designationlbl.setForeground(Color.WHITE);
//        add(designationlbl);
//        
//        designationtf = new JTextField();
//        designationtf.setBounds(200, 350, 150,30);
//        add(designationtf);
        
        JLabel idlbl = new JLabel("Valid ID Type");
        idlbl.setBounds(430, 400, 150, 30);
        idlbl.setFont(new Font("serif", Font.PLAIN, 20));
        idlbl.setForeground(Color.WHITE);
        add(idlbl);
        
        String valids[] = {"Philsys", "Postal", "UMID", "Drivers License", "Passport", "SSS", "ePhilID", "PRC", "Other"};
        
        idcb = new JComboBox(valids);
        idcb.setBounds(620, 400, 150,30);
        add(idcb);

        JLabel vidlbl = new JLabel("Valid ID #");
        vidlbl.setBounds(430, 450, 150, 30);
        vidlbl.setFont(new Font("serif", Font.PLAIN, 20));
        vidlbl.setForeground(Color.WHITE);
        add(vidlbl);
        
        idtf = new JTextField();
        idtf.setBounds(620, 450, 150,30);
        add(idtf);
        
        JLabel empidlbl = new JLabel("Employee ID");
        empidlbl.setBounds(430, 150, 150, 30);
        empidlbl.setFont(new Font("serif", Font.PLAIN, 20));
        empidlbl.setForeground(Color.WHITE);
        add(empidlbl);
        
        empidlabel = new JLabel();
        empidlabel.setBounds(620, 150, 150, 30);
        empidlabel.setFont(new Font("serif", Font.PLAIN, 20));
        empidlabel.setForeground(Color.WHITE);
        add(empidlabel);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where name = '"+empName+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                empidlabel.setText(rs.getString("empId"));
                nametf.setText(rs.getString("name"));
                mnametf.setText(rs.getString("mname"));
                lnametf.setText(rs.getString("lname"));
                lbldob.setText(rs.getString("dob"));
                addresstf.setText(rs.getString("address"));
                phonetf.setText(rs.getString("phone"));
                salarycb.setSelectedItem(rs.getString("salary"));
                emailtf.setText(rs.getString("email"));
                educcb.setSelectedItem(rs.getString("education"));
                idtf.setText(rs.getString("vid"));
                idcb.setSelectedItem(rs.getString("id"));
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
            String name = nametf.getText();
            String mname = mnametf.getText();
            String lname = lnametf.getText();
            String salary = (String) salarycb.getSelectedItem();
            String address = addresstf.getText();
            String phone = phonetf.getText();
            String email = emailtf.getText();
            String education = (String) educcb.getSelectedItem();
            String vid = idtf.getText();
            String id = (String) idcb.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set name = '"+name+"', mname = '"+mname+"', lname = '"+lname+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"',id = '"+id+"', vid = '"+vid+"' where name = '"+empName+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully.");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new ViewEmployees();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee2("");
    }
}
