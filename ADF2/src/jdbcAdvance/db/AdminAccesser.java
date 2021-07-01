package com.assignments.jdbcAdvance.db;

import com.assignments.jdbcAdvance.entity.Admin;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                    adminList.add(admin);
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                    for (Admin a : adminList) {
                        if (a.getUsername().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(md5(password))) {
                            return true;
                        }
                    }

                }
            }
        }catch (SQLException e) {
            return false;
        }
        return false;
    }

    public int insert(){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO admin(username, password) VALUES (?,?)";
        int id = 0;
        if (conn != null){
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                Admin admin = new Admin();
                admin.register();
                ps.setString(1,admin.getUsername());
                ps.setString(2,md5(admin.getPassword()));
                ps.executeUpdate();
                rs= ps.getGeneratedKeys();
                adminList.add(admin);
                if (rs.next()){
                    id = rs.getInt(1);
                }
                conn.commit();
                return id;
            } catch (SQLException e) {
                return 0;
            }
        }
        return 0;
    }

    public String md5(String c){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(c.getBytes(StandardCharsets.UTF_8));
            String result = new String(md.digest());

            return result;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
