package ems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class EmployeeView extends JFrame implements ActionListener{
    

    JLabel empidlabel, namelabel, mnamelabel, lnamelabel, salarylabel, addresslabel, phonelabel, emaillabel, educlabel, idlabel, vidlabel;
    JComboBox salarycb, educcb, idcb;
    JButton add, back;
    String empId, empName;
    JDateChooser dcdob;
    
    EmployeeView(String empId){
        this.empId = empId;
        setResizable(false);
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel head = new JLabel("Employee " + empId);
        head.setBounds(320, 30, 500, 50);
        head.setFont(new Font("sans serif", Font.BOLD, 25));
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel namelbl = new JLabel("First Name");
        namelbl.setBounds(50, 150, 150, 30);
        namelbl.setFont(new Font("serif", Font.PLAIN, 20));
        namelbl.setForeground(Color.BLACK);
        add(namelbl);
        
        namelabel = new JLabel();
        namelabel.setBounds(200, 150, 150,30);
        add(namelabel);
        
        JLabel fnamelbl = new JLabel("Middle Name");
        fnamelbl.setBounds(50, 200, 150, 30);
        fnamelbl.setFont(new Font("serif", Font.PLAIN, 20));
        fnamelbl.setForeground(Color.BLACK);
        add(fnamelbl);
        
        mnamelabel = new JLabel();
        mnamelabel.setBounds(200, 200, 150, 30);
        add(mnamelabel);
        
        JLabel doblbl = new JLabel("Date of Birth");
        doblbl.setBounds(50, 350, 150, 30);
        doblbl.setFont(new Font("serif", Font.PLAIN, 20));
        doblbl.setForeground(Color.BLACK);
        add(doblbl);
        //430, 150, 150, 30
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 350, 150, 30);
        lbldob.setForeground(Color.BLACK);
        add(lbldob);
        
        JLabel motherlbl = new JLabel("Last Name");
        motherlbl.setBounds(50, 250, 150, 30);
        motherlbl.setFont(new Font("serif", Font.PLAIN, 20));
        motherlbl.setForeground(Color.BLACK);
        add(motherlbl);
        
        lnamelabel = new JLabel();
        lnamelabel.setBounds(200, 250, 150,30);
        add(lnamelabel);
        
        JLabel salarylbl = new JLabel("Salary");
        salarylbl.setBounds(430, 250, 150, 30);
        salarylbl.setFont(new Font("serif", Font.PLAIN, 20));
        salarylbl.setForeground(Color.BLACK);
        add(salarylbl);
        
        String salary[] = {"Grade 1 (13K)", "Grade 2 (14K)", "Grade 3 (15K)", "Grade 4 (16K)", "Grade 5 (17K)"};
        
        salarylabel = new JLabel();
        salarylabel.setBounds(620, 250, 150,30);
        salarylabel.setBackground(Color.BLACK);
        add(salarylabel);
        
        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50, 300, 150, 30);
        addresslbl.setFont(new Font("serif", Font.PLAIN, 20));
        addresslbl.setForeground(Color.BLACK);
        add(addresslbl);
        
        addresslabel = new JLabel();
        addresslabel.setBounds(200, 300, 150,30);
        add(addresslabel);
        
        JLabel phonelbl = new JLabel("Phone #");
        phonelbl.setBounds(430, 300, 150, 30);
        phonelbl.setFont(new Font("serif", Font.PLAIN, 20));
        phonelbl.setForeground(Color.BLACK);
        add(phonelbl);
        
        phonelabel = new JLabel();
        phonelabel.setBounds(620, 300, 150,30);
        add(phonelabel);
        
        JLabel emaillbl = new JLabel("Email Address");
        emaillbl.setBounds(430, 200, 150, 30);
        emaillbl.setFont(new Font("serif", Font.PLAIN, 20));
        emaillbl.setForeground(Color.BLACK);
        add(emaillbl);
        
        emaillabel = new JLabel();
        emaillabel.setBounds(620, 200, 150,30);
        add(emaillabel);
        
        JLabel educlbl = new JLabel("Highest Education");
        educlbl.setBounds(430, 350, 150, 30);
        educlbl.setFont(new Font("serif", Font.PLAIN, 20));
        educlbl.setForeground(Color.BLACK);
        add(educlbl);
        
        String courses[] = {"Elem UnderGrad", "Elem Grad", "HS UnderGrad", "HS Grad", "SHS UnderGrad", "SHS Grad", "College UnderGrad", "College Grad"};
        
        educlabel = new JLabel();
        educlabel.setBounds(620, 350, 150,30);
        educlabel.setBackground(Color.BLACK);
        add(educlabel);
        
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
        idlbl.setForeground(Color.BLACK);
        add(idlbl);
        
        String valids[] = {"Philsys", "Postal", "UMID", "Passport", "SSS", "ePhilID", "PRC", "Other"};
        
        idlabel = new JLabel();
        idlabel.setBounds(620, 400, 150,30);
        add(idlabel);

        JLabel vidlbl = new JLabel("Valid ID #");
        vidlbl.setBounds(430, 450, 150, 30);
        vidlbl.setFont(new Font("serif", Font.PLAIN, 20));
        vidlbl.setForeground(Color.BLACK);
        add(vidlbl);
        
        vidlabel = new JLabel();
        vidlabel.setBounds(620, 450, 150,30);
        add(vidlabel);
        
        JLabel empidlbl = new JLabel("Employee ID");
        empidlbl.setBounds(430, 150, 150, 30);
        empidlbl.setFont(new Font("serif", Font.PLAIN, 20));
        empidlbl.setForeground(Color.BLACK);
        add(empidlbl);
        
        empidlabel = new JLabel();
        empidlabel.setBounds(620, 150, 150, 30);
        empidlabel.setFont(new Font("serif", Font.PLAIN, 20));
        empidlabel.setForeground(Color.BLACK);
        add(empidlabel);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                empidlabel.setText(rs.getString("empId"));
                namelabel.setText(rs.getString("name"));
                mnamelabel.setText(rs.getString("mname"));
                lnamelabel.setText(rs.getString("lname"));
                lbldob.setText(rs.getString("dob"));
                addresslabel.setText(rs.getString("address"));
                phonelabel.setText(rs.getString("phone"));
                salarylabel.setText(rs.getString("salary"));
                emaillabel.setText(rs.getString("email"));
                educlabel.setText(rs.getString("education"));
                idlabel.setText(rs.getString("id"));
                vidlabel.setText(rs.getString("vid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        add = new JButton("Update Details");
//        add.setBounds(450, 550, 150, 40);
//        add.setBackground(Color.GREEN);
//        add.setForeground(Color.BLACK);
//        add.addActionListener(this);
//        add(add);
        
        back = new JButton("Back to login");
        back.setBounds(350, 550, 150, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(240, 40);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new EmployeeView("");
    }
}
