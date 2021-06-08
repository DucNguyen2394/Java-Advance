package com.example.labStudent;

import java.io.Serializable;
import java.util.Scanner;

public class Student {
    String id;
    String name;
    int age;
    String address;
    float gpa;
    Scanner scan = new Scanner(System.in);
    public Student(){}
    public Student(String id, String name, int age, String address, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + "]";
    }
    public void display(){
        System.out.println(toString());
    }
    public void input(){
        System.out.println("Enter ID: ");
        id = scan.nextLine();
        System.out.println("Enter name: ");
        name = scan.nextLine();
        System.out.println("Enter age: ");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("Enter address: ");
        address = scan.nextLine();
        System.out.println("Enter GPA: ");
        gpa = Float.parseFloat(scan.nextLine());
    }

    public String readLine(){
        return id + "," + name + "," + age + "," + address + "," + gpa + "\n" ;
    }

}
