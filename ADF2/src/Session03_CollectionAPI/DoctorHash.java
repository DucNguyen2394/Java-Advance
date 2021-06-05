package Session03_CollectionAPI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DoctorHash {
    public DoctorHash(){
        doctorHashMap = new HashMap();
    }
    static HashMap doctorHashMap;
    void add(){
        String doctorName;
        int hours = 0;
        String code;
        String specialization;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter doctor name: ");
        doctorName = scan.nextLine();
        System.out.println("Enter doctor code: ");
        code = scan.nextLine();
        System.out.println("Enter doctor specialization: ");
        specialization = scan.nextLine();
        System.out.println("Enter doctor hours: ");
        hours = scan.nextInt();

        DoctorDetails doctorDetails = new DoctorDetails(code,doctorName,specialization,hours);

        doctorHashMap.put(code,doctorDetails);
    }
    void display(){
        String searchCode;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter doctor code: ");
        searchCode = scan.nextLine();
        if(doctorHashMap.containsKey(searchCode)){
            System.out.println(doctorHashMap.get(searchCode));
        }else{
            System.out.println("Not found!");
        }
    }
    void publish(){
        System.out.println("the size of doctorHashMap: " + doctorHashMap.size());


        Iterator iter = doctorHashMap.keySet().iterator();
        int i = 1;
        while (iter.hasNext()){
            System.out.println("index: " + i + " " + doctorHashMap.get(iter.next()));
            i++;
        }

    }
}
