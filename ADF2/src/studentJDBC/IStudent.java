package com.assignments.studentJDBC;

import java.sql.Connection;
import java.util.List;

public interface IStudent {
    Connection getConnection();

    int createStudent();

    List<Student> findAll();

    List<Student> updateStudent();

    List<Student> searchStudent();

    List<Student> deleteStudent();
}
