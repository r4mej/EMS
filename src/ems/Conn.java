package ems;

import java.sql.*;

public class Conn {

    private static final String HOST = "employeemanagementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection c;
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///" + HOST, USER, PASSWORD);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
