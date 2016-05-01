package Project;

public class SavingsAccount extends Account {
	
	double accountAnnualInterestRate = Account.getAnnualInterestRate();
	private int numberWithdraw;
	private double minBalance = 300.00;
	int maxWith = 3;

	public SavingsAccount(){};
	
	public SavingsAccount(double balance){
		setBalance(balance);
		setAnnualInterestRate(3.0);
	}
	
	void setNumberWithdraw(int num){ this.numberWithdraw = num; }
	
	
	@Override
	public void withdraw(double amt){
		
	double balanceSum = getBalance() - amt;
	
	if (balanceSum >= minBalance){
		if (maxWith > 0) {
			super.withdraw(amt);
			toString();
			System.out.println("Withdraw Complete");
			this.maxWith -= 1;
			}
		else{
			toString();
			System.out.println("Unalbe to perfrom withdraw\nA Savings Account can withdraw maximum 3 times in a month");
		}
		}
	else{
		toString();
		System.out.printf("Unable to perform withdrawal\nA Savings Account should maintain a minimum balance $   %.2f\n", minBalance);
	}
	}
	
	
	@Override
	public String toString(){
		System.out.printf("Account Number: %d, Account Balance: $  %.2f\n", super.getID(), super.getBalance());
		return super.toString();
	}
}