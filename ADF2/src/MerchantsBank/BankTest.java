package MerchantsBank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankTest {	
	public static void main(String[] args) {
		ArrayList<Account> acc = new ArrayList<>();

		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);
		int choose;
		do{
			System.out.println("Choose ");
			choose = Integer.parseInt(scan.nextLine());
			switch(choose){
			case 1:
				bank.createAccount();
				break;
			case 2:
				bank.displayAccountDetails();	
				break;
			case 3:
				bank.withdraw();
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("BYE ");
				break;
			default:
				System.out.println("Invalid ");
				break;
			}
		}while(choose != 5);
	}
	
	public static void menu(){
		System.out.println("1. Create a new account ");
		System.out.println("2. Display account ");
		System.out.println("2. Withdraw Cash ");
		System.out.println("4. Deposit cash ");
		System.out.println("5. EXIT ");
	}
}
