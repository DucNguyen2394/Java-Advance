package com.assignments.studentJDBC;

import java.util.Scanner;

public class StudentTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentPerform sp = new StudentPerform();
        int choose;
        do {
            menu();
            System.out.println("Choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    sp.createStudent();
                    break;
                case 2:
                    sp.updateStudent();
                    break;
                case 3:
                    sp.deleteStudent();
                    break;
                case 4:
                    sp.searchStudent();
                    break;
                case 5:
                    sp.findAll();
                    break;
                case 6:
                    System.out.println("Bye!");
                    break;
                default:
                    System.err.println("invalid!!!");
                    break;
            }

        }while (choose != 5);
    }

    public static void menu(){
        System.out.println("1. Create Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Search Student");
        System.out.println("5. Find all Student");
        System.out.println("6. Exit");
    }
}
