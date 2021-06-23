package com.assignments.jdbcAdvance.ui;

import com.assignments.jdbcAdvance.db.AdminAccesser;
import com.assignments.jdbcAdvance.db.PersonAccesser;
import java.util.Scanner;

public class PersonManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PersonAccesser pa = new PersonAccesser();
        AdminAccesser aa = new AdminAccesser();
        int choose;
        if(aa.findAll()) {
            do {
                menu();
                System.out.println("Choose: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        pa.insert();
                        break;
                    case 2:
                        pa.updateById();
                        break;
                    case 3:
                        pa.deleteById();
                        break;
                    case 4:
                        pa.searchById();
                        break;
                    case 5:
                        pa.findAll();
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
        System.err.println("err!!!");
    }
    public static void menu(){
        System.out.println("=====================================");
        System.out.println("1. Create Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Search Student");
        System.out.println("5. Display Student");
        System.out.println("6. Exit");
    }
}
