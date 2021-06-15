package com.assignments.studentJDBC;

import java.util.List;

public interface IStudent {

    int createStudent();

    List<Student> findAll();

    List<Student> updateStudent();

    List<Student> searchStudent();

    List<Student> deleteStudent();
}
