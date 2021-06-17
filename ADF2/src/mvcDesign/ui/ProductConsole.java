package com.assignments.mvcDesign.ui;

import com.assignments.mvcDesign.controller.ProductService;
import com.assignments.mvcDesign.entity.Product;

import java.util.Scanner;

public class ProductConsole {
    static Scanner sc = new Scanner(System.in);
    ProductService productService = new ProductService();
    public ProductConsole(){

    }
    private int menu(){
        System.out.println("---Product Menu---");
        System.out.println("1. Create ");
        System.out.println("2. Display");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");
        int choice = readInt(1, 5);
        return choice;
    }

    private int readInt(int min, int max){
        int choice;
        while (true){
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= min && choice <= max){
                    break;
                }
            }catch (NumberFormatException e){
                e.getMessage();
            }
        }
        return choice;
    }
    public void start(){
        while (true){
            int choice = menu();
            switch (choice){

            }
        }
    }
    private Double readDouble(int min, double max){
        double price;
        while (true){
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price >= min && price <= max){
                    break;
                }
            }catch (NumberFormatException e){
                e.getMessage();
            }
        }
        return price;
    }

    public void addProduct(){
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter desc");
        String desc = sc.nextLine();
        System.out.println("Enter price: ");
        double price = readDouble(0,Double.MAX_VALUE);
        Product product = new Product(name, desc,price);

    }
}
