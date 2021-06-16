package com.assignments.jdbcAdvance.db;

import java.sql.*;

public class Connector {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/studentdemo";
            String user = "root";
            String password = "ducnguyen@94";

            return DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    public void close(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(PreparedStatement ps){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
