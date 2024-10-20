package ems;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int num = ran.nextInt(99999);
    
    JTextField nametf, mnametf, lnametf, addresstf, phonetf, idtf, emailtf, salarytf, designationtf;
    JDateChooser dcdob;
    JComboBox educcb, salarycb, idcb;
    JLabel empidlabel;
    JButton add, back;
    
    AddEmployee(){
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel head = new JLabel("Add Employee Details");
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 350, 150,30);
        add(dcdob);
        
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
        
        JLabel idlbl = new JLabel("Valid ID Type");
        idlbl.setBounds(430, 400, 150, 30);
        idlbl.setFont(new Font("serif", Font.PLAIN, 20));
        idlbl.setForeground(Color.WHITE);
        add(idlbl);
        
        String valids[] = {"Philsys", "Postal", "UMID", "Passport", "SSS", "ePhilID", "PRC", "Other"};
        
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
        
        empidlabel = new JLabel("" + num);
        empidlabel.setBounds(620, 150, 150, 30);
        empidlabel.setFont(new Font("serif", Font.PLAIN, 20));
        empidlabel.setForeground(Color.WHITE);
        add(empidlabel);
        
        add = new JButton("Add Details");
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
            
            // Validation checks and message box
            
        if (isEmpty(nametf.getText()) || isEmpty(mnametf.getText()) || isEmpty(lnametf.getText()) ||
                isEmpty(((JTextField) dcdob.getDateEditor().getUiComponent()).getText()) ||
                isEmpty(addresstf.getText()) || isEmpty(phonetf.getText()) || isEmpty(emailtf.getText()) ||
                isEmpty(idtf.getText())|| salarycb.getSelectedIndex() == -1 || educcb.getSelectedIndex() == -1 ||
                idcb.getSelectedIndex() == -1){
            showError("Please fill in all required fields.");
            return;
        }
        if (!isValidName(nametf.getText())) {
            showError("Invalid name. Please enter only letters and spaces.");
            return;
        }
        if (!isValidName(mnametf.getText())) {
            showError("Invalid name. Please enter only letters and spaces.");
            return;
        }
        
        if (!isValidName(lnametf.getText())) {
            showError("Invalid name. Please enter only letters and spaces.");
            return;
        }
        // Similar validation checks for other text fields (mname, lname, etc.)
        if (!isValidPhone(phonetf.getText())) {
            showError("Invalid phone number. Please enter a valid phone number format.");
            return;
        }
        if (!isValidAddress(addresstf.getText())) {
            showError("Invalid address. Please enter only letters and spaces.");
            return;
        }
       
        if (!isValidEmail(emailtf.getText())) {
            showError("Invalid email address. Please enter a valid email format.");
            return;
        }
            
            String name = nametf.getText();
            String mname = mnametf.getText();
            String lname = lnametf.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = (String) salarycb.getSelectedItem();
            String address = addresstf.getText();
            String phone = phonetf.getText();
            String email = emailtf.getText();
            String education = (String) educcb.getSelectedItem();
            //String designation = designationtf.getText();
            String vid = idtf.getText();
            String id = (String) idcb.getSelectedItem();
            String empId = empidlabel.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+empId+"','"+name+"','"+mname+"','"+lname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+id+"','"+vid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully.");
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
    
    private boolean isEmpty(String str) {
    return str == null || str.trim().isEmpty();
}
    
    private boolean isValidName(String name) {
        
        return name.matches("[a-zA-Z ]+");
    }

    private boolean isValidPhone(String phone) {
        //unfinished regex
        return phone.matches("[0-9\\-\\+\\(\\)]+");  // Basic phone number format check
    }

    private boolean isValidEmail(String email) {
        //unfinished
        return email.matches("^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[a-zA-Z]{2,}$");
    }
    
    private boolean isValidAddress(String address) {
        // idk
        return address.matches("[a-zA-Z ]+");
    }
    

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
