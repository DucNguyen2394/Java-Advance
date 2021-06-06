package MerchantsBank;

import java.util.ArrayList;

public class InsuffnoughFundsException extends Exception {
	
	public InsuffnoughFundsException(String s,double balance,double amount){
		super();
		if(balance < 100){
			System.err.println(s);
		}
		if(amount > balance){
			System.err.println(s);
		}
		if(amount <= 0){
			System.err.println(s);
		}
	}

	public String getMessage(){
		return "Balance must be greater than 100";
	}
}
