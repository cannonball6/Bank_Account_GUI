package Project;
public class CDAccount extends Account {
	
	private int duration;  //in months
	private double CDannualInterestRate;
	
	CDAccount(){};

	CDAccount(int duration, double CDannualInterestRate){//constructor
		this.duration = duration;
		this.CDannualInterestRate = CDannualInterestRate;
	}
	
	public CDAccount(double balance, int duration, double CDannualInterestRate){//constructor
		
		setBalance(balance);
		this.duration = duration;
		this.CDannualInterestRate = CDannualInterestRate;
	}

	////////////setters//////////////////
	
	void setDuration(int duration){this.duration = duration;}
	
	public void setCDAnnualInterestRate( double CDannualInterestRate){
		this.CDannualInterestRate = CDannualInterestRate;
	}
	////////////getters////////////////
	public int getDuration(){return this.duration;}
	public double getCDannualInterestRate(){return this.CDannualInterestRate;}
	public double getMatureBalance(){
		return this.getBalance() + (((this.getBalance() * this.getCDannualInterestRate())/100) * (9.0/12.0));
	}
	
	@Override
	double getMonthlyInterestRate(){
		return (CDannualInterestRate / 12);}
	

	@Override
	public void withdraw(double amt) {
		// TODO Auto-generated method stub
		
	}
	
}
	
