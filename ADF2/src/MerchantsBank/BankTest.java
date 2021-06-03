package MerchantsBank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankTest {	
	public static void main(String[] args) {
		ArrayList<Account> acc = new ArrayList<>();
		
		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);
		int choose;
		bank.createAccount();
		bank.displayAccountDetails();
	}
	
	public static void menu(){
		System.out.println("1. Create a new account ");
		System.out.println("2. Display account ");
		System.out.println("2. Withdraw Cash ");
		System.out.println("4. Deposit cash ");
		System.out.println("5. Create a new account ");
	}
}
