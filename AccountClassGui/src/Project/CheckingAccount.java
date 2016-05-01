package Project;

public class CheckingAccount extends Account {

	double annualInterestRate = 0;
	
	CheckingAccount(){};
	
	public CheckingAccount(double balance){
		
		setBalance(balance);
	}
	
	double accountAnnualInterestRate() {return annualInterestRate;}
	
	double minBalance() {return 0;}
	
	@Override
	public
	void withdraw(double amt){
		super.withdraw(amt);
		toString();
		System.out.println("Withdraw Complete");
	}
	
}
