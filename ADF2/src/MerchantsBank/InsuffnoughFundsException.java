package MerchantsBank;

public class InsuffnoughFundsException extends Exception {
	
	Account account;
	public InsuffnoughFundsException(String s,double balance,double amount ){
		if(balance < 100){
			System.err.println(s);
		}
		if(amount > balance){
			System.err.println(s);
		}
	}

	public String getMessage(){
		return "Balance must be greater than 100";
	}
}
