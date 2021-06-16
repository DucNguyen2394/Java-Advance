package com.assignments.jdbcAdvance.entity;

public class Person {
    private int id;
    private String fullname;
    private String gender;
    private int age;
    public Person(){ }

    public Person(int id, String fullname, String gender, int age) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
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
}
