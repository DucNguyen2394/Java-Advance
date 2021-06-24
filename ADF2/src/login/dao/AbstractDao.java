package com.assignments.login.dao;

import com.assignments.login.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<T> {
    Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentdemo";
            String username = "root";
            String password = "ducnguyen@94";

            return DriverManager.getConnection(url,username,password);
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
    List<T> query(String sql, RowMapper<T> rowMapper, Object... params){
        List<T> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            setParameter(ps, params);
            rs = ps.executeQuery();
            while (rs.next()){
                result.add(rowMapper.mapRow(rs));
            }
            return result;
        }catch (SQLException e){
            return null;
        }finally {
            close(rs);
            close(ps);
            close(conn);
        }
    }
    private void setParameter(PreparedStatement ps,Object... params){
        try{
            for(int i = 0; i < params.length; i++){
                Object param = params[i];
                int index = i + 1;
                if (param instanceof Long){
                    ps.setLong(index,(Long)param);
                }
                if (param instanceof  String){
                    ps.setString(index, (String) param);
                }
                if (param instanceof  Integer){
                    ps.setInt(index, (int) param);
                }
                if (param instanceof  Float){
                    ps.setFloat(index, (Float) param);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(String sql, Object... params){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            setParameter(ps,params);
            ps.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            close(ps);
            close(conn);
        }
    }
    public Long insert(String sql, Object... params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long id = null;
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            setParameter(ps,params);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                id = rs.getLong(1);
            }
            conn.commit();
            return id;
        }catch (SQLException e){
            return null;
        }finally {
            close(rs);
            close(ps);
            close(conn);
        }
    }


}
