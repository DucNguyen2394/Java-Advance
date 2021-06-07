package Session04_FileReadWrite;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public CopyFile(){

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String path = scan.next();
        File fileName = new File(path);
        String location = path.substring(0,path.indexOf(fileName.getName()));

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream  = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String copy = scan.next();

        if (copy.equals(location)){
            System.out.println("Copy thanh cong");
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }else{
            try {
                outputStream = new FileOutputStream(copy + fileName.getName());
                int data;
                while(true){
                    try {
                        if (!(data = inputStream.read() != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        outputStream.write(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
