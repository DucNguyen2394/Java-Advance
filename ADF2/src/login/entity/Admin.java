package com.assignments.login.entity;

import java.util.Scanner;

public class Admin extends AbstractModel {
    static Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;

    public Admin(){}

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
