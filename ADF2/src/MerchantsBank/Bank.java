package MerchantsBank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	final String bankName = "Merchants";
	private int nextAccount;
	final int MaximumAccounts = 10;
	private int nextAccountNumber;
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList<Account> acc = new ArrayList<>();
	
	public Bank(){
		
	}	
	public Bank(int nextAccount, int nextAccountNumber) {
		this.nextAccount = nextAccount;
		this.nextAccountNumber = nextAccountNumber;
	}

	public void createAccount(){
		int n;
		System.out.println("Enter number account: ");
		n = Integer.parseInt(scan.nextLine());
		
		for(int i = 0; i < n; i++){
			Account account = new Account();
			System.out.println("Enter customer name: ");
			account.setCustomerName(scan.nextLine());
			System.out.println("Enter account number");
			account.setAccountNumber(scan.nextLine());
			System.out.println("Enter account balance");
			account.setAccountbalance(Double.parseDouble(scan.nextLine()));
			
			acc.add(account);
		}
	}
	public void displayAccountDetails(){
		for(int i = 0; i < acc.size(); i++){
			acc.get(i).display();
		}
	}
	
	public void withdraw(){
		
	}
	
	public void deposit(){
		
	}
}
