package com.example.labStudent;

import sun.applet.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentTest {
    static Scanner scan = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int choose,n;
        do {
            menu();
            System.out.println("Choose: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose){
                case 1:
                    System.out.println("Enter n Student: ");
                    n= Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < n; i++){
                        Student std = new Student();
                        std.input();
                        studentList.add(std);
                    }
                    break;
                case 2:
                    for(Student s : studentList){
                        s.display();
                    }
                    break;
                case 3:
                    System.out.println("Start save file");
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                    try {
                        fw = new FileWriter("C:\\Users\\HL2020\\IdeaProjects\\ADF2\\student.txt");
                        bw = new BufferedWriter(fw);
                        for (Student s : studentList){
                            s.readLine();
                            bw.write(s.readLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Not found");
                    } catch (IOException e){
                        System.out.println("Err save file");
                        e.printStackTrace();
                    } finally {
                        try{
                            if(bw != null){
                                bw.close();
                            } if(fw != null){
                                fw.close();
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }

                    break;
                case 4:
                    System.out.println("Start read file");
                    FileReader fr = null;
                    BufferedReader br = null;
                    try{
                        fr = new FileReader("C:\\Users\\HL2020\\IdeaProjects\\ADF2\\student.txt");
                        br = new BufferedReader(fr);
                        String ch = null;
                        while ((ch = br.readLine()) != null){
                            System.out.println(ch);
                            Student std = new Student();
                                String[] s = ch.split(",");
                                std.id = s[0];
                                std.name = s[1];
                                std.age = Integer.parseInt(s[2]);
                                std.address = s[3];
                                std.gpa = Float.parseFloat(s[4]);
                                studentList.add(std);
                        }
                    } catch (Exception e){
                    } finally {
                        try{
                            if(br != null){
                                br.close();
                            }if(fr != null){
                                fr.close();
                            }
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }



                    break;
                case 5:
                    System.out.println("Bye!!!");
                    break;
                default:
                    System.out.println("Invalid!!!");
                    break;
            }
        } while (choose != 5);
    }

    public static void menu(){
        System.out.println("1.Enter Infomation student ");
        System.out.println("2. Display student");
        System.out.println("3. save");
        System.out.println("4. read");
        System.out.println("5. Exit");
    }
}
