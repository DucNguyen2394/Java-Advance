package com.assignments.login.dao;

import com.assignments.login.entity.Admin;
import com.assignments.login.mapper.AdminMapper;
import java.util.List;
import java.util.Scanner;

public class AdminDao extends AbstractDao<Admin> {
    static Scanner scanner = new Scanner(System.in);
    String username, password;
    public boolean checkLogin(){
        try {

            String sql = "Select * from admin ";
            System.out.println("enter username: ");
            username = scanner.nextLine();
            System.out.println("enter password: ");
            password = scanner.nextLine();
            List<Admin> adminList = query(sql,new AdminMapper(), username,password);

            for(Admin a : adminList){

                if(a.getUsername().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(password)){
                    return true;
                }
                System.err.println("sai roi");
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        AdminDao a = new AdminDao();

        a.checkLogin();
    }
}
