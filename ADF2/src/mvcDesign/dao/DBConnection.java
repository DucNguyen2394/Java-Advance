package com.assignments.mvcDesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/demo";
            String user = "root";
            String password = "ducnguyen@94";

            conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    return null;
                }
            }
        }
    }
}
