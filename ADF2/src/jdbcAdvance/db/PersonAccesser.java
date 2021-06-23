package com.assignments.jdbcAdvance.db;

import com.assignments.jdbcAdvance.entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonAccesser extends Connector implements IStudent {
    List<Student> studentList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    int flag = 0;
    @Override
    public List<Student> findAll() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student";
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setFullname(rs.getString("fullname"));
                    student.setAge(rs.getInt("age"));
                    student.setGender(rs.getString("gender"));
                    student.setMark(rs.getFloat("mark"));

                    System.out.println(rs.getInt("id") + " " + rs.getString("fullname") + " "+ rs.getString("gender")
                            + " " + rs.getInt("age") + " " +rs.getFloat("mark"));

                    studentList.add(student);
                }
                return studentList;
            } catch (SQLException throwables) {
                return null;
            }
        }
        return null;
    }
    @Override
    public int insert() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO student (fullname, gender, age, mark) VALUES (?,?,?,?)";
        int id = 0;
        if (conn != null) {
            try {
                System.out.println("Enter number student ");
                int n = Integer.parseInt(scan.nextLine());
                for(int i = 0; i < n; i++) {
                    Student student = new Student();
                    student.input();
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    ps.setString(1, student.getFullname());
                    ps.setString(2, student.getGender());
                    ps.setInt(3, student.getAge());
                    ps.setFloat(4, student.getMark());
                    ps.executeUpdate();

                    rs = ps.getGeneratedKeys();
                    studentList.add(student);

                    if (rs.next()){
                        id = rs.getInt(1);
                    }
                    conn.commit();
                }
                return id;
            } catch (SQLException e) {
                return 0;
            }
        }
        return 0;
    }
    @Override
    public List<Student> updateById() {
        Connection conn = getConnection();
        String sql = "UPDATE student set fullname = ? , gender = ? , age = ? , mark = ? WHERE id = ?";
        PreparedStatement ps = null;
        if(conn != null){
            try {
                System.out.println("Enter student ID update: ");
                int n = Integer.parseInt(scan.nextLine());
                for(int i = 0; i < studentList.size(); i++){
                    if (studentList.get(i).getId() == n){
                        Student student = new Student();
                        student.input();
                        ps = conn.prepareStatement(sql);

                        ps.setString(1,student.getFullname());
                        ps.setString(2, student.getGender());
                        ps.setInt(3,student.getAge());
                        ps.setFloat(4,student.getMark());
                        ps.setInt(5,n);
                        ps.executeUpdate();

                        studentList.add(student);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    System.out.println("Not found");
                }
                return studentList;
            } catch (SQLException throwables) {
                return null;
            }
        }
        return null;
    }
    @Override
    public List<Student> deleteById() {
        Connection conn = getConnection();
        String sql = "DELETE FROM student WHERE id = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int flag = 0;
        if(conn != null){
            try{
                System.out.println("Enter ID student delete: ");
                int n = Integer.parseInt(scan.nextLine());
                for (Student std : studentList){
                    if (std.getId() == n){
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, n);
                        ps.executeUpdate();
                        System.out.println("Delete done!");
                        studentList.add(std);
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    System.err.println("Not found!!!");
                }
                return studentList;
            }catch (SQLException e){
                return null;
            }
        }
        return null;
    }
    @Override
    public void searchById() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE id = ?";
        if (conn != null){
            try{
                System.out.println("Enter id student search: ");
                int n = Integer.parseInt(scan.nextLine());
                for(Student std : studentList){
                    if(std.getId() == n){
                        System.out.println(" done");
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1,n);
                        System.out.println(" done222");
                        rs = ps.executeQuery();
                        while (rs.next()){
                            System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("fullname")
                            + " gender: " + rs.getString("gender") + " age: " + rs.getInt("age") + " mark: " + rs.getFloat("mark"));
                        }
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    System.out.println("Not found!!!");
                }
            }catch(SQLException e){
                System.err.println("Error!!!");
            }
        }
    }
}
