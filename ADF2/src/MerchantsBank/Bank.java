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
			do{
				account.setCustomerName(scan.nextLine());
			}while((account.getCustomerName() == null) || (account.getCustomerName().matches("[a-z A-Z]+") == false));
			
			System.out.println("Enter account number");
			account.setAccountNumber(scan.nextLine());	
									
			System.out.println("Enter account balance");
			
			do{
				account.setAccountbalance(Double.parseDouble(scan.nextLine()));				
			}while(account.getAccountbalance() < 100);
	
			acc.add(account);
		}
	}
	public void displayAccountDetails(){
		for(int i = 0; i < acc.size(); i++){
			acc.get(i).display();
		}
	}
	
	public void withdraw(){
		double amount;
		if(acc.size() < 1){
			System.err.println("No account have been created yet!");
		}
		for(int i = 0; i < acc.size(); i++){
			String findAccount;
			System.out.println("Enter the account number to withdraw: ");
			try{
				findAccount = scan.nextLine();
					if(findAccount.length() < 1){
						throw new NullPointerException();
					}else if(!(findAccount.equalsIgnoreCase(acc.get(i).getAccountNumber()))){
						System.err.println("Not found!");
					}else if(findAccount.equalsIgnoreCase(acc.get(i).getAccountNumber())){
						try{
							System.out.println("Enter amount customer withdraw: ");
							amount = Double.parseDouble(scan.nextLine());
							if(amount > acc.get(i).getAccountbalance()){
								throw new InsuffnoughFundsException("invalid!!!",acc.get(i).getAccountbalance(),amount);							
						}
							acc.get(i).setAccountbalance(acc.get(i).getAccountbalance() - amount);
							displayAccountDetails();
						}catch(InsuffnoughFundsException e){
							
						}
					}
				}
				catch(NullPointerException e){
					System.out.println("ko dc null");
			}
		}
	}
	
	public void deposit(){
		double amount;
		if(acc.size() < 1){
			System.err.println("No account have been created yet!");
		}
		for(int i = 0; i < acc.size(); i++){
			String findAccount;
			System.out.println("Enter the account number to deposit: ");
			try{
				findAccount = scan.nextLine();
					if(findAccount.length() < 1){
						throw new NullPointerException();
					}else if(!(findAccount.equalsIgnoreCase(acc.get(i).getAccountNumber()))){
						System.err.println("Not found!");
					}else if(findAccount.equalsIgnoreCase(acc.get(i).getAccountNumber())){
						System.out.println("Enter amount customer deposit: ");
						try {
							amount = Double.parseDouble(scan.nextLine());
						if(amount <= 0){
								throw new InsuffnoughFundsException("invalid!!!",acc.get(i).getAccountbalance(),amount);
						}
							acc.get(i).setAccountbalance(acc.get(i).getAccountbalance() + amount);
							displayAccountDetails();
							} catch (InsuffnoughFundsException e) {
								e.printStackTrace();
							} catch (NumberFormatException e){
								System.out.println("Amount not String");
							}
					}
					
			}catch(NullPointerException e){
				System.out.println("ko dc null");
			}
		}
		
	}
}
