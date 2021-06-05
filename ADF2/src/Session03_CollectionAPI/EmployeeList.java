package Session03_CollectionAPI;

import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeList {
    LinkedList link ;
    Scanner scan = new Scanner(System.in);
    public EmployeeList(){
        link = new LinkedList();
    }

    void add(){
        String employeeName;
        System.out.println("Enter the name of employee: ");
        employeeName = scan.nextLine();

        link.add(employeeName);
    }

    void display(){
        for (int i = 0; i < link.size(); i++){
            System.out.println(link.get(i));
        }
    }

    void search(){
        String searchName;
        System.out.println("Enter the name you need search: ");
        searchName = scan.nextLine();
        for (int i = 0; i < link.size(); i++){
            if (link.get(i).equals(searchName)){
                System.out.println("Da tim thay ten");
            }
        }
    }
}
