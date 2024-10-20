package ems;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

//CAUTION: sorry for the inefficient table code lol(the deadline for this project suddenly changed)

public class ViewEmployees extends JFrame implements ActionListener{
    
    JTable table;
    private JComboBox<String> searchCriteria;
    private JTextField searchField;
    //Choice cemployeeId, cemployeeName;
    JButton search, search1, view, view1, print, print1, update, update1, back, reset;
    
    ViewEmployees(){
        setLayout(null);
        setResizable(false);
        
        JLabel searchlbl = new JLabel("Search by:");
        searchlbl.setBounds(30,20,150,20);
        add(searchlbl);
        
        String[] searchCriteriaOptions = {"Name", "Mname", "Lname", "EmpID"};
        searchCriteria = new JComboBox<>(searchCriteriaOptions);
        searchCriteria.setBounds(30, 50, 150, 20);
        add(searchCriteria);
        
        searchField = new JTextField();
        searchField.setBounds(210, 50, 150, 20);
        add(searchField);
        
        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.getSelectionModel().addListSelectionListener(event -> {
                boolean isRowSelected = table.getSelectedRowCount() > 0;
                view.setVisible(isRowSelected);
                update.setVisible(isRowSelected);
        });
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
             for (int i = 0; i < table.getColumnCount(); i++) {
    String newHeaderName;
    switch (i) {
      case 0:
        newHeaderName = "Employee Id";
        break;
      case 1:
        newHeaderName = "Name";
        break;
      // 
        case 2:
        newHeaderName = "Middle Name";
        break;
        case 3:
        newHeaderName = "Last Name";
        break;
        case 4:
        newHeaderName = "Date of birth";
        break;
        case 5:
        newHeaderName = "Salary";
        break;
        case 6:
        newHeaderName = "Email";
        break;
      default:
        newHeaderName = table.getColumnModel().getColumn(i).getHeaderValue().toString();
    }
    table.getColumnModel().getColumn(i).setHeaderValue(newHeaderName);
  }
            while(rs.next()){
//                cemployeeId.add(rs.getString("empId"));
//                cemployeeName.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select empId, name, mname, lname, dob, salary, email from employee"); // Modified query

            table = new JTable(DbUtils.resultSetToTableModel(rs));
            for (int i = 0; i < table.getColumnCount(); i++) {
    String newHeaderName;
    switch (i) {
      case 0:
        newHeaderName = "Employee Id";
        break;
      case 1:
        newHeaderName = "Name";
        break;
      // 
        case 2:
        newHeaderName = "Middle Name";
        break;
        case 3:
        newHeaderName = "Last Name";
        break;
        case 4:
        newHeaderName = "Date of birth";
        break;
        case 5:
        newHeaderName = "Salary";
        break;
        case 6:
        newHeaderName = "Email";
        break;
      default:
        newHeaderName = table.getColumnModel().getColumn(i).getHeaderValue().toString();
    }
    table.getColumnModel().getColumn(i).setHeaderValue(newHeaderName);
  }
            table.setDefaultEditor(Object.class, null);  // Prevent cell editing


        }catch(Exception e){
            e.printStackTrace();
        }

                    
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(30, 110, 900, 800);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(380, 50, 80, 20);
        search.addActionListener(this);
        add(search);
        
        view = new JButton("View");
        view.setBounds(480, 50, 80, 20);
        view.addActionListener(this);
        add(view);
        //view.setVisible(false); // Initially invisible
        
        print = new JButton("Print");
        print.setBounds(680, 50, 80, 20);
        print.addActionListener(this);
        add(print);

        
        update = new JButton("Update");
        update.setBounds(580, 50, 80, 20);
        update.setBackground(Color.GREEN);
        update.addActionListener(this);
        add(update);
        //update.setVisible(false); // Initially invisible

        back = new JButton("Back");
        back.setBounds(850, 50, 80, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        reset = new JButton("Reset view");
        reset.setBounds(30, 80, 100, 20);
        reset.setBackground(Color.BLUE);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);
        
        setSize(1000, 700);
        setLocation(250, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search) {
              String selectedCriteria = (String) searchCriteria.getSelectedItem();
              String searchTerm = searchField.getText();

              String query = "select empId, name, mname, lname, dob, salary, email from employee where " + selectedCriteria + " like '%" + searchTerm + "%'";

              try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                for (int i = 0; i < table.getColumnCount(); i++) {
    String newHeaderName;
    switch (i) {
      case 0:
        newHeaderName = "Employee Id";
        break;
      case 1:
        newHeaderName = "Name";
        break;
      // 
        case 2:
        newHeaderName = "Middle Name";
        break;
        case 3:
        newHeaderName = "Last Name";
        break;
        case 4:
        newHeaderName = "Date of birth";
        break;
        case 5:
        newHeaderName = "Salary";
        break;
        case 6:
        newHeaderName = "Email";
        break;
      default:
        newHeaderName = table.getColumnModel().getColumn(i).getHeaderValue().toString();
    }
    table.getColumnModel().getColumn(i).setHeaderValue(newHeaderName);
  }
              } catch (Exception e) {
                e.printStackTrace();
              }
        }
        else if (ae.getSource() == view) {
        // Get selected employee ID from the table model (assuming single selection)
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
          String selectedId = (String) table.getModel().getValueAt(selectedRow, 0); // Assuming employee ID is in the first column (index 0)
          new ViewEmployee(selectedId);
        } else {
          // Handle no selection case (show message? nah just show nothing lol)
        }
      }
       
        else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == update){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
          String selectedId = (String) table.getModel().getValueAt(selectedRow, 0);
          new UpdateEmployee1(selectedId);
        } else {
        }
      }
        else if(ae.getSource() == reset){
            // Reset table to show all employees with desired columns
        String query = "select empId, name, mname, lname, dob, salary, email from employee";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            for (int i = 0; i < table.getColumnCount(); i++) {
    String newHeaderName;
    switch (i) {
      case 0:
        newHeaderName = "Employee Id";
        break;
      case 1:
        newHeaderName = "Name";
        break;
      // 
        case 2:
        newHeaderName = "Middle Name";
        break;
        case 3:
        newHeaderName = "Last Name";
        break;
        case 4:
        newHeaderName = "Date of birth";
        break;
        case 5:
        newHeaderName = "Salary";
        break;
        case 6:
        newHeaderName = "Email";
        break;
      default:
        newHeaderName = table.getColumnModel().getColumn(i).getHeaderValue().toString();
    }
    table.getColumnModel().getColumn(i).setHeaderValue(newHeaderName);
  }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new ViewEmployees();
    }
}
