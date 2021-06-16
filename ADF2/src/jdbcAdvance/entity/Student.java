package com.assignments.jdbcAdvance.entity;

import java.util.Scanner;

public class Student extends Person{
    private float mark;
    static Scanner scanner = new Scanner(System.in);

    public Student(){}
    public Student(float mark) {
        this.mark = mark;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void input(){
        System.out.println("Enter student name: ");
        setFullname(scanner.nextLine());
        System.out.println("Enter student gender: ");
        setGender(scanner.nextLine());
        System.out.println("Enter student age: ");
        setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter student mark: ");
        mark = Float.parseFloat(scanner.nextLine());
    }
}
