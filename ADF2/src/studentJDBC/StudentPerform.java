package com.assignments.studentJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPerform extends Connector implements IStudent{
    List<Student> studentList = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    @Override
    public int createStudent() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        String sql = "insert INTO student( fullname, gender, age, mark) values (?, ?, ?, ?)";
        if(conn != null) {
                try {
                    System.out.println("Enter number student ");
                    int n = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < n; i++) {
                        Student student = new Student();
                        student.input();
                        ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

                        ps.setString(1, student.getFullname());
                        ps.setString(2, student.getGender());
                        ps.setInt(3, student.getAge());
                        ps.setFloat(4, student.getMark());
                        ps.executeUpdate();

                        rs = ps.getGeneratedKeys();
                        studentList.add(student);
                    }
                    if(rs != null){
                        id = rs.getInt(1);
                    }
                    conn.commit();
                    return id;
                 }catch (SQLException throwables) {
                    return Integer.parseInt(null);
                } finally {
                    close(rs);
                    close(ps);
                    close(conn);
                }
        }
        return Integer.parseInt(null);
    }

    @Override
    public List<Student> findAll() {
        Connection conn = getConnection();
        String sql = "Select * from student";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(conn != null){
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while ((rs.next())){
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setFullname(rs.getString("fullname"));
                    student.setGender(rs.getString("gender"));
                    student.setAge(rs.getInt("age"));
                    student.setMark(rs.getFloat("mark"));

                    System.out.println(rs.getInt("id") + " " + rs.getString("fullname") + " "+ rs.getString("gender")
                            + " " + rs.getInt("age") + " " +rs.getFloat("mark"));
                    studentList.add(student);
                }
                return studentList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }finally {
                close(rs);
                close(ps);
                close(conn);
            }
        }
        return null;
    }

    @Override
    public List<Student> updateStudent() {
        Connection conn = getConnection();
        String sql = "UPDATE student set fullname = ? , gender = ? , age = ? , mark = ? WHERE id = ?";
        PreparedStatement ps = null;
        if(conn != null){
            try {
                System.out.println("Enter student ID update: ");
                int n = Integer.parseInt(scan.nextLine());
                for(int i = 0; i < studentList.size(); i++){
                    System.out.println("size:" + studentList.size());
                    System.out.println("id: " + studentList.get(i).getId());
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
                        break;
                    }
                    System.out.println("Not found!!!");
                }
                return studentList;
            } catch (SQLException throwables) {
                return null;
            } finally {
                close(ps);
                close(conn);
            }
        }
        return null;
    }

    @Override
    public List<Student> searchStudent() {
        Connection conn = getConnection();
        String sql = "SELECT * FROM student WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int flag = 0;
        if(conn != null) {
            try {
                System.out.println("Enter student id search: ");
                int n = Integer.parseInt(scan.nextLine());
                for (Student std : studentList) {
                    if (std.getId() == n) {
                        System.out.println(" done");
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, n);

                        rs = ps.executeQuery();

                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " " + rs.getString("fullname")
                                    + " " + rs.getString("gender")
                                    + " " + rs.getInt("age") + " " + rs.getFloat("mark"));
                        }
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    System.out.println("not found!");
                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
                return null;
            }finally {
                close(ps);
                close(conn);
            }
        }
        return null;
    }

    @Override
    public List<Student> deleteStudent() {
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
            }finally {
                close(ps);
                close(conn);
            }
        }
        return null;
    }
}
