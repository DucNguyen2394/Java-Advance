package com.assignments.studentJDBC;

import java.util.Scanner;

public class Student {
    static Scanner scanner = new Scanner(System.in);

    private int id;
    private String fullname;
    private String gender;
    private int age;
    private float mark;
    public Student(){ }
    public Student(int id, String fullname, String gender, int age, float mark) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.mark = mark;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void input(){
        System.out.println("Enter student name: ");
        fullname = scanner.nextLine();
        System.out.println("Enter student gender: ");
        gender = scanner.nextLine();
        System.out.println("Enter student age: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student mark: ");
        mark = Float.parseFloat(scanner.nextLine());
    }

}
