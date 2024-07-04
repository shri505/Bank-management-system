package com.project.BankManagement;
public class LoanAccount extends BankAccount
{
	double roi;
	
	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public LoanAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public LoanAccount(int accountNumber,String pass, String accountHolderName, double balance) {
		super(accountNumber,pass, accountHolderName,-(balance));
		if(balance < 200000)
		{
			this.roi = 5;
		}
		else if(balance < 500000)
		{
			
		}
	}
	
	public boolean deposit(double amount)
	{
		if(this.balance == 0)
		{
			System.out.println("\n\t YOU HAVE NO LOAN REMAINING NO DEPOSIT POSSIBLE \n");
			return false;
		}
		else
		{
			this.balance = this.balance + amount;
			return true;
		}
	}
	
	public boolean withdraw(double amount)
	{
		return false;
	}
	
	
	@Override
	public double calculateIntrest() 
	{
		double intrest = this.balance * (roi/100);
		System.out.println("THE INTREST YOU WILL HAVE TO PAY ON YOUR CURRENT LOAN BALANCE IS : " + intrest);
		return intrest;
	}

}

