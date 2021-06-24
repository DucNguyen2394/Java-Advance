package com.assignments.login.mapper;

import com.assignments.login.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs) {
        Student student = new Student();
        try {
            student.setId(rs.getLong("id"));
            student.setFullname(rs.getString("fullname"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setMark(rs.getFloat("mark"));

            System.out.println(rs.getInt("id") + " " + rs.getString("fullname") + " "+ rs.getString("gender")
                    + " " + rs.getInt("age") + " " +rs.getFloat("mark"));
            return student;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
