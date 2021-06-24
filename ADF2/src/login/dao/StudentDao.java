package com.assignments.login.dao;

import com.assignments.login.entity.Student;
import com.assignments.login.mapper.StudentMapper;

import java.util.List;
import java.util.Scanner;

public class StudentDao extends AbstractDao<Student> {
    Long id;
    static Scanner scanner = new Scanner(System.in);
    public List<Student> findAll(){
        String sql = "Select * from student";
        return query(sql,new StudentMapper());
    }

    public Long save(){
        Student student = new Student();
        student.input();
        String sql = "INSERT INTO student (fullname, gender, age, mark) VALUES (?,?,?,?)";
        return insert(sql,student.getFullname(),student.getGender(),student.getAge(),student.getMark());
    }

    public void updateById(){
        Student student = new Student();
        System.out.println("Enter id update: ");
        id = Long.parseLong(scanner.nextLine());
        student.input();
        String sql = "UPDATE student set fullname = ? , gender = ? , age = ? , mark = ? WHERE id = ?";
        update(sql,student.getFullname(),student.getGender(),student.getAge(),student.getMark(),id);
    }

    public void deleteById(){
        System.out.println("Enter id delete: ");
        id = Long.parseLong(scanner.nextLine());
        String sql = "DELETE FROM student WHERE id = ?";
        update(sql,id);
    }

    public List<Student> findById(){
        System.out.println("Enter id search: ");
        id = Long.parseLong(scanner.nextLine());
        String sql = "Select * from student where id = ?";
        return query(sql,new StudentMapper(),id);
    }

}
