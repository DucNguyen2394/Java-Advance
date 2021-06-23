package com.assignments.jdbcAdvance.db;

import com.assignments.jdbcAdvance.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminAccesser extends Connector{
    List<Admin> adminList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public boolean findAll(){
        String username,password;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from admin";
        try{
            if(conn != null){
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    Admin admin = new Admin();
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    System.out.println("ok");
                    adminList.add(admin);
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                    for (Admin a : adminList) {
                        if (a.getUsername().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(password)) {
                            return true;
                        }
                        System.err.println("invalid");
                    }

                }
            }
        }catch (SQLException e) {
            return false;
        }
        return false;
    }


}
