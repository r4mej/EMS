package ems;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    //Choice cEmpId;
    JTextField empIdField;
    JButton delete, confirmDelete, back;
    JLabel lblName, lblMname, lblLname, lblId, lblAddress, lblPhone, lblDob, lblSalary;

    RemoveEmployee() {
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setLayout(null);

        JLabel labelempId = new JLabel("Search by Employee Id:");
        labelempId.setForeground(Color.WHITE);
        labelempId.setBounds(50, 30, 140, 30);
        add(labelempId);

        empIdField = new JTextField();
        empIdField.setBounds(200, 35, 90, 25);
        add(empIdField);
        
        empIdField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Call method to fetch and display employee info
                    fetchEmployeeInfo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
         //       cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelid = new JLabel("Emp Id:");
        labelid.setForeground(Color.WHITE);
        labelid.setBounds(50, 80, 100, 30);
        add(labelid);

        lblId = new JLabel();
        lblId.setForeground(Color.WHITE);
        lblId.setBounds(200, 80, 100, 30);
        add(lblId);
        
        JLabel labelname = new JLabel("Name:");
        labelname.setForeground(Color.WHITE);
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);

        lblName = new JLabel();
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(200, 100, 100, 30);
        add(lblName);

        JLabel labelMname = new JLabel("Middle Name:");
        labelMname.setForeground(Color.WHITE);
        labelMname.setBounds(50, 120, 100, 30);
        add(labelMname);

        lblMname = new JLabel();
        lblMname.setForeground(Color.WHITE);
        lblMname.setBounds(200, 120, 100, 30);
        add(lblMname);

        JLabel labelLname = new JLabel("Last Name:");
        labelLname.setForeground(Color.WHITE);
        labelLname.setBounds(50, 140, 100, 30);
        add(labelLname);

        lblLname = new JLabel();
        lblLname.setForeground(Color.WHITE);
        lblLname.setBounds(200, 140, 100, 30);
        add(lblLname);
        
        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setForeground(Color.WHITE);
        labelAddress.setBounds(50, 160, 100, 30);
        add(labelAddress);

        lblAddress = new JLabel();
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setBounds(200, 160, 100, 30);
        add(lblAddress);
        
        JLabel labelPhone = new JLabel("Contact #:");
        labelPhone.setForeground(Color.WHITE);
        labelPhone.setBounds(50, 180, 100, 30);
        add(labelPhone);

        lblPhone = new JLabel();
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setBounds(200, 180, 100, 30);
        add(lblPhone);
        
        JLabel labelDob = new JLabel("Date of Birth:");
        labelDob.setForeground(Color.WHITE);
        labelDob.setBounds(50, 200, 100, 30);
        add(labelDob);

        lblDob = new JLabel();
        lblDob.setForeground(Color.WHITE);
        lblDob.setBounds(200, 200, 100, 30);
        add(lblDob);
        
        JLabel labelSalary = new JLabel("Salary:");
        labelSalary.setForeground(Color.WHITE);
        labelSalary.setBounds(50, 220, 100, 30);
        add(labelSalary);

        lblSalary = new JLabel();
        lblSalary.setForeground(Color.WHITE);
        lblSalary.setBounds(200, 220, 100, 30);
        add(lblSalary);
        
        

//        try {
//            Conn c = new Conn();
//            String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "' ";
//            ResultSet rs = c.s.executeQuery(query);
//
//            while (rs.next()) {
//                lblName.setText(rs.getString("name"));
//                lblMname.setText(rs.getString("mname"));
//                lblLname.setText(rs.getString("lname"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        cEmpId.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent ie) {
//                try {
//                    Conn c = new Conn();
//                    String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "' ";
//                    ResultSet rs = c.s.executeQuery(query);
//
//                    while (rs.next()) {
//                        lblName.setText(rs.getString("name"));
//                        lblMname.setText(rs.getString("mname"));
//                        lblLname.setText(rs.getString("lname"));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        delete = new JButton("Delete");
        delete.setBounds(50, 300, 100, 30);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        confirmDelete = new JButton("Confirm");
        confirmDelete.setBounds(50, 300, 100, 30);
        confirmDelete.setBackground(Color.WHITE);
        confirmDelete.setForeground(Color.BLACK);
        confirmDelete.setVisible(false); // Initially hide the confirm button
        confirmDelete.addActionListener(this);
        add(confirmDelete);

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                confirmDelete.setVisible(true); // Show confirm button after confirmation
                try {
                Conn c = new Conn();
                String query = "delete from employee where empId = '" + empIdField.getText() + "' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully.");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                confirmDelete.setVisible(false); // Hide confirm button after deletion
                delete.setVisible(true); // Show original delete button again
            }
                delete.setVisible(false); // Hide original delete button
            }
//        } else if (ae.getSource() == confirmDelete) {
//            // Perform the actual deletion here
//            try {
//                Conn c = new Conn();
//                String query = "delete from employee where empId = '" + empIdField.getText() + "' ";
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Employee information deleted successfully.");
//                setVisible(false);
//                new Home();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                confirmDelete.setVisible(false); // Hide confirm button after deletion
//                delete.setVisible(true); // Show original delete button again
//            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

     private void fetchEmployeeInfo() {
        String empId = empIdField.getText();
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + empId + "' ";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                lblId.setText(rs.getString("empid"));
                lblName.setText(rs.getString("name"));
                lblMname.setText(rs.getString("mname"));
                lblLname.setText(rs.getString("lname"));
                lblAddress.setText(rs.getString("address"));
                lblPhone.setText(rs.getString("phone"));
                lblDob.setText(rs.getString("dob"));
                lblSalary.setText(rs.getString("salary"));
                // ... set text for other labels (mname, lname)
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
