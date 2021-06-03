package MerchantsBank;

public class Account {
	private String customerName;
	private String accountNumber;
	private double accountbalance;
	
	public Account(){
		
	}
	public Account(String customerName, String accountNumber, double accountbalance) {
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountbalance = accountbalance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		boolean check = false;
		while(check){
			try{
				this.customerName = customerName;
			}catch(NullPointerException e){
				System.out.println("cant NULL!!!");
				check = false;
			}
		}
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	@Override
	public String toString() {
		return "Account [customerName=" + customerName + ", accountNumber=" + accountNumber + ", accountbalance="
				+ accountbalance + "]";
	}
	
	public void display(){
		System.out.println(toString());
	}
	
}
