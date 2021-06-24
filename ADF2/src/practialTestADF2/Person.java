package com.practialTestADF2;

import java.util.Scanner;

public class Person {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private String company;
    private String email;
    private int phone;
    public Person(){

    }

    public Person(String name, String company, String email, int phone) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
    public void display(){
        System.out.println(toString());
    }
    public void input(){
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        System.out.println("Enter company: ");
        company = scanner.nextLine();
        System.out.println("Enter email: ");
        email = scanner.nextLine();
        System.out.println("Enter phone: ");
        phone = Integer.parseInt(scanner.nextLine());

    }
}
