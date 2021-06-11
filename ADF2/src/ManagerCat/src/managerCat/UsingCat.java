package managerCat;

import java.util.Scanner;

public class UsingCat {
	public static void main(String args[]){
		ManagerCat managerCat = new ManagerCat();
		Scanner scan = new Scanner(System.in);
		int choose;
		do{
			menu();
			System.out.println("Choose ");
			choose = Integer.parseInt(scan.nextLine());
			switch(choose){
			case 1:
				managerCat.enter();
				break;
			case 2:
				managerCat.display();
				break;
			case 3:
				managerCat.sort();
				break;
			case 4:
				managerCat.find();
				break;
			case 5:
				System.out.println("Bye! ");
				break;
			default:
				System.out.println("Invalid!!! ");
				break;
			}
		}while(choose != 5);
	}
	
	public static void menu(){
		System.out.println("1.Enter n number cat ");
		System.out.println("2.Display your cat ");
		System.out.println("3.Sort the list cat by color ");
		System.out.println("4.Search info cat by type ");
		System.out.println("5.Exit ");
	}
}
