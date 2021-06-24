package com.assignments.login.mapper;

import com.assignments.login.entity.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin>{
    @Override
    public Admin mapRow(ResultSet rs) {
        Admin admin = new Admin();
        try {
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            return admin;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
