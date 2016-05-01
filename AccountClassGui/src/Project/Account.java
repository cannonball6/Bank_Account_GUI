package Project;
import java.util.Date;

public abstract class Account {
	private static int nextID = 1000; //this is where account numbers will start
	private int id = 0;
	private double balance = 0.0;
	protected static double annualInterestRate = 0.0;
	private Date date = new Date(); 
	
	
	Account(){ id = nextID++; } //default constructor
	Account(double theBalance, double rate){
		id = nextID++;
		balance = theBalance;
		annualInterestRate = rate;
		}
	/////////////////////Setters/////////////////////
	public void setID(int newId){
		id = newId;
	}
	void setBalance(double Newbalance){
		balance = Newbalance;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate){
		annualInterestRate = newAnnualInterestRate;
	}
	
	///////////////////////Getters////////////////////
	public int getID(){return id;} 
	public double getBalance(){return balance;}
	static double getAnnualInterestRate(){return annualInterestRate;}
	String getDateCreated(){
		return date.toString();}
	double getMonthlyInterestRate(){
		return annualInterestRate / 1200.00;
	}
	double getMonthlyInterest(){
		return balance * getMonthlyInterestRate();
		}
	
	//Methods
	public void withdraw(double amt){
		if (amt > 0){
			balance -= amt;
		}
	}
	public void deposit(double amt) {
		setBalance(getBalance() + amt);
	}
	
	//Display Methods
	void displayAccount(Account accounts){
		System.out.printf("%14d%23.2f%12.2f%33s\n", accounts.getID(), accounts.getMonthlyInterest(), accounts.getBalance(),accounts.getDateCreated());
	}
	//print array of accounts
	void displayAccounts(Account accounts[]){
		
		for(int i = 0; i < 5; ++i) {
			System.out.printf("%14d%23.2f%12.2f%33s\n", 
		accounts[i].getID(), 
		accounts[i].getMonthlyInterest(),
		accounts[i].getBalance(),
		accounts[i].getDateCreated());
		}
	}

	void printAccount(){
		System.out.printf("%s%4d%s%f\n", "Account Number: ", getID(), ", Account Balance: ", getBalance());
	}
}
