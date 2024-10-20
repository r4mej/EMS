//ermm idk how to use this so i hardcoded the table cuz it worked better
package ems;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.event.TableModelListener;
import net.proteanit.sql.DbUtils;
import javax.swing.table.*;

public class EmployeeTableModel implements TableModel {

  private String[] columnNames = {"Employee Id", "Name", "Middle name", "Last name", "Date of birth", "Salary", "Email"};
  private ResultSet rs;

  public EmployeeTableModel(ResultSet rs) {
    this.rs = rs;
  }

  @Override
  public int getRowCount() {

    try {
      rs.last();
      return rs.getRow();
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}