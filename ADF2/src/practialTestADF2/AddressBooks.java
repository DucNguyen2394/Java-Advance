package com.practialTestADF2;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBooks {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Person> addressBooksArrayList = new ArrayList<>();
    public static void main(String[] args) {
        int choose;
        do{
            showMenu();
            System.out.println("Choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    add();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.err.println("Invalid!!!");
                    break;
            }
        }while (choose != 4);
    }

    public static void showMenu(){
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
    }

    public static void add(){
        int n;
        System.out.println("Enter number contact: ");
        n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            Person person = new Person();
            person.input();

            addressBooksArrayList.add(person);
        }
    }

    public static void findContactByName(){
        int flag = 0;
        String findName;
        System.out.println("Enter the name you want search: ");
        findName = scanner.nextLine();
        for (int i = 0; i < addressBooksArrayList.size(); i++){
            if(addressBooksArrayList.get(i).getName().equalsIgnoreCase(findName)){
                display();
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("Name not found!");
        }
    }
    public static void display(){
        for(int i = 0; i < addressBooksArrayList.size(); i++){
            addressBooksArrayList.get(i).display();
        }
    }
}
