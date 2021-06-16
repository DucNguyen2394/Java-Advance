package com.assignments.jdbcAdvance.db;

import com.assignments.jdbcAdvance.entity.Student;

import java.util.List;

public interface IStudent {
    List<Student> findAll();

    int insert();

    List<Student> updateById();

    List<Student> deleteById();

    void searchById();
}
