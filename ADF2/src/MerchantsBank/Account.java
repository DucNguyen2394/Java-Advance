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
	
	public boolean setCustomerName(String customerName) {
			if(customerName.length() < 1 ){
				System.err.println("Can't null");
				return false;
			}
			else if(customerName.matches("[a-z A-Z]+") == false){
				System.out.println("Does not contain number in the name");
				return false;
			}else{
				this.customerName = customerName;
				return true;			
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
	
	public boolean setAccountbalance(double accountbalance) {
		try{
			if(accountbalance < 100){
				throw new InsuffnoughFundsException("Balance must be greater than 100",accountbalance,0);
				
			}else{
				this.accountbalance = accountbalance;	
				return true;
			}
		}catch(InsuffnoughFundsException e){
			e.getMessage();
		}catch(NumberFormatException e){
			System.out.println("Balance is not String");
		}
		return true;
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
