package com.project.BankManagement;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class SalaryAccount extends SavingAccount
{
	LocalDate lastTransactionDate;
	static float roi;

	static
	{
		roi=5;
	}
	
	public SalaryAccount() {
		// TODO Auto-generated constructor stub
	}

	public SalaryAccount(int accountNumber,String pass, String accountHolderName, double balance) {
		super(accountNumber, pass ,accountHolderName, balance);
		this.lastTransactionDate = LocalDate.of(2020, 9, 11);
	}
	
	public LocalDate getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(LocalDate lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	
	public static float getRoi() {
		return roi;
	}

	public static void setRoi(float roi) {
		SalaryAccount.roi = roi;
	}

	public boolean deposit(double amount)
	{
		if(isFreeze())
		{
			System.out.println("\n THIS ACCOUNT IS CURRENTLY FROZEN.\n");
			System.out.println("DUE TO NO ACTIVITY IN LAST TWO MONTHS.\n");
			return false;
		}
		else
		{
			if(this.balance - amount >= 0)
			{
				this.balance += amount;
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public boolean withdraw(double amount)
	{
		if(isFreeze())
		{
			System.out.println("\n THIS ACCOUNT IS CURRENTLY FROZEN.\n");
			System.out.println("DUE TO NO ACTIVITY IN LAST TWO MONTHS.\n");
			return false;
		}
		else
		{
			this.balance -= amount;
			return true;
		}
	}
	
	public double calculateIntrest()
	{
		if(this.isFreeze())
		{
			System.out.println("\n THIS ACCOUNT IS CURRENTLY FROZEN.\n");
			System.out.println("DUE TO NO ACTIVITY IN LAST TWO MONTHS.\n");
			return 0;
		}
		else
		{
			double intrest = this.balance * (roi/100);
			System.out.println("THE INTREST YOU WILL GET ON YOUR CURRENT BALANCE IS : " + intrest);
			return intrest;
		}
	}
	
	public boolean isFreeze()
	{
		long diff = ChronoUnit.DAYS.between(lastTransactionDate , LocalDate.now());
		if(diff <= 60)
		{
			System.out.println("diff is : " + diff);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	
}