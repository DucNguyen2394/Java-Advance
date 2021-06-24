package com.assignments.login.ui;

import com.assignments.login.dao.AdminDao;
import com.assignments.login.dao.StudentDao;

import java.util.Scanner;

public class StudentManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentDao sd = new StudentDao();
        AdminDao ad = new AdminDao();
        int choose;
        if(ad.checkLogin()) {
            do {
                menu();
                System.out.println("Choose: ");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        sd.findAll();
                        break;
                    case 2:
                        sd.save();
                        break;
                    case 3:
                        sd.updateById();
                        break;
                    case 4:
                        sd.deleteById();
                        break;
                    case 5:
                        sd.findById();
                        break;
                    case 6:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.err.println("invalid!!!");
                        break;
                }

            } while (choose != 6);
        }
        else {
            System.err.println("sai roi!!!");
        }
    }

    public static void menu(){
        System.out.println("=====================================");
        System.out.println("1. Display Student");
        System.out.println("2. Create Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");
    }
}
