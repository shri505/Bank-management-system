package com.project.BankManagement;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args)
	{
		int accIndex=-1;
		int recordIndex=-1;
		int accNo=100;
		BankAccount[] bankAccounts = new BankAccount[20];
		String admin = "Admin",pass = "pass123";
		EndOfDayReport[] dailyReport = new EndOfDayReport[30];
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do
		{
			System.out.println("\n 1. LOGIN PAGE \n 2. CREATE ACCOUNT \n 0. EXIT \n  SELECT YOUR CHOICE :  ");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("\n-----------------------------------------");
					System.out.println(" 1. Admin                                |");
					System.out.println(" 2. User                                 |");
					System.out.println("\n-----------------------------------------");
					System.out.println(" Enter your choice : ");
					int choice4 = sc.nextInt();
					switch(choice4)
					{
						case 1:
						{
							System.out.println(" Enter the admin name : ");
							sc.nextLine();
							String adm = sc.nextLine();
							System.out.println(" Enter the password : ");
							String pas = sc.nextLine();
							
							if(adm.equals(admin) && pas.equals(pass))
							{
								System.out.println("\n--------------------------------------------------------------------");
								System.out.println("| 1. Show daily report                                                |");
								System.out.println("| 2. Add all intrests                                                 |");
								System.out.println("| 3. Display all users                                                |");
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("\n Enter the choice : ");
								int choice5 = sc.nextInt();
								
								switch(choice5)
								{
									case 1:
									{
										System.out.println("\n\n\t FOLLOWING ARE THE ACCOUNTS PRESENT IN YOUR SYSTEM \n");
										System.out.println(" ACCOUNT NUMBER      HOLDER NAME          AMOUNT      ACTIVITY     ");
										for(int count=0;count<=recordIndex;count++)
										{
											dailyReport[count].display();
										}
									}break;
									
									case 2:
									{
										for(int count=0;count<=accIndex;count++)
										{
											bankAccounts[count].balance +=  bankAccounts[count].calculateIntrest();
										}
									}break;
									
									case 3:
									{
										System.out.println("\n\n\t FOLLOWING ARE THE ACCOUNTS PRESENT IN YOUR SYSTEM \n");
										System.out.println(" ACCOUNT NUMBER      HOLDER NAME           BALANCE      ");
										for(int count=0;count<=accIndex;count++)
										{
											bankAccounts[count].display();
										}
									}break;
								}
								
							}
							else
							{
								System.out.println("\n--------------------- INVALID CREDENTIALS -------------------------");
							}
						}break;
						
						case 2:
						{
							System.out.println("\n Enter the Account Number : ");
							int accNumber = sc.nextInt();
							int found=-1;
							for(int ctr=0;ctr<=accIndex;ctr++)
							{
								if(accNumber == bankAccounts[ctr].accountNumber)
								{
									found = ctr;
									break;
								}
							}
							
							if(found == -1)
							{
								System.out.println("\n\t !!!!!!!!!!!!!!!!!! NO SUCH ACCOUNT EXISTS !!!!!!!!!!!!!!!!!!!\n\n");
							}
							else
							{
								System.out.println("\n Enter the password : ");
								sc.nextLine();
								String pas = sc.nextLine();
								if(pas.equals(bankAccounts[found].getPassword()))
								{
									System.out.println("--------------------------------------------------------");
									System.out.println("| 1. WITHDRAWAL                                        |");
									System.out.println("| 2. DEPOSIT                                           |");
									System.out.println("| 3. TRANSACTION                                       |");
									System.out.println("| 4. SHOW INTREST AMOUNT ON BALANCE                    |");
									System.out.println("| 0. EXIT                                              |");
									System.out.println("--------------------------------------------------------");
									System.out.println(" Enter your choice : ");
									int choice2 = sc.nextInt();
									switch(choice2)
									{
										case 1:
										{
											System.out.println("\n\n\t Enter the amount you want to withdraw : ");
											int amount = sc.nextInt();
											if(bankAccounts[found].withdraw(amount))
											{
												dailyReport[++recordIndex] = new EndOfDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amount,"WITHDRAW");
												System.out.println("\n\t WITHDRAWAL SUCCESSFULL \n");
											}
											else
											{
												System.out.println("\n\t WITHDRAWAL UNSUCCESSFULL \n");
											}
										}break;
										
										case 2:
										{
											System.out.println("\n\n\t Enter the amount you want to deposit : ");
											int amount = sc.nextInt();
											if(bankAccounts[found].deposit(amount))
											{
												dailyReport[++recordIndex] = new EndOfDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amount,"DEPOSIT");
												System.out.println("\n\t DEPOSIT SUCCESSFULL \n");
											}
											else
											{
												System.out.println("\n\t DEPOSIT UNSUCCESSFULL \n");
											}
										}break;
										
										case 3:
										{
											System.out.println("\n Enter the Account Number to which you want to transfer money : ");
											int accNum2 = sc.nextInt();
											int next=-1;
											for(int ctr=0;ctr<=accIndex;ctr++)
											{
												if(accNum2 == bankAccounts[ctr].accountNumber)
												{
													next = ctr;
													break;
												}
											}
											if(next==-1)
											{
												System.out.println("\n\t !!!!!!!!!!!!!!!!!! NO SUCH ACCOUNT EXISTS !!!!!!!!!!!!!!!!!!!\n\n");
											}
											else
											{
												System.out.println("\n\t Enter the amount you want to transfer : ");
												int amt = sc.nextInt();
												
												if(bankAccounts[found].withdraw(amt))
												{
													dailyReport[++recordIndex] = new EndOfDayReport(bankAccounts[found].getAccountNumber(),bankAccounts[found].getAccountHolderName(),amt,"WITHDRAW");
													bankAccounts[next].deposit(amt);
													dailyReport[++recordIndex] = new EndOfDayReport(bankAccounts[next].getAccountNumber(),bankAccounts[next].getAccountHolderName(),amt,"DEPOSIT");
													System.out.println("\n\t TRANSFER SUCCESSFULL \n");
												}
												else
												{
													System.out.println("\n\t TRANSFER UNSUCCESSFULL \n");
												}
											}
											
										}break;
										
										case 4:
										{
											bankAccounts[found].calculateIntrest();
										}break;
										
										default : System.out.println("\n INVALID CHOICE ");
										
									}
								}
								else
								{
									System.out.println("\n---------------- INVALID PASSWORD -----------------------");
								}
							}
						}
						
					}
					
				}break;
				
				case 2:
				{
					System.out.println("-----------------------------------------------");
					System.out.println("| 1. SAVINGS ACCOUNT                          |");
					System.out.println("| 2. CURRENT ACCOUNT                          |");
					System.out.println("| 3. SALARY ACCOUNT                           |");
					System.out.println("| 4. LOAN ACCOUNT                             |");
					System.out.println("-----------------------------------------------");

					System.out.println(" SELECT YOUR CHOICE : ");
					int choice1 = sc.nextInt();
					switch(choice1)
					{
						case 1:
						{
							if(accIndex<20)
							{
								System.out.println("\n Set the password for your account : ");
								sc.nextLine();
								String pas = sc.nextLine();
								System.out.println("\n Enter the Account Holder Name : ");
								String accName = sc.nextLine();
								System.out.println("\n Enter the Sarting balance : ");
								double bal = sc.nextDouble();
								bankAccounts[++accIndex] = new SavingAccount(++accNo,pas,accName,bal);
								System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());
							}
							else
							{
								System.out.println("\n\n\t NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
							}
						}break;
						
						case 2:
						{
							if(accIndex<20)
							{
								System.out.println("\n Set the password for your account : ");
								sc.nextLine();
								String pas = sc.nextLine();
								System.out.println("\n Enter the Account Holder Name : ");
								sc.nextLine();								String accName = sc.nextLine();
								System.out.println("\n Enter the Sarting balance : ");
								double bal = sc.nextDouble();
								bankAccounts[++accIndex] = new CurrentAccount(++accNo,pas,accName,bal);
								System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());

							}
							else
							{
								System.out.println("\n\n\t NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
							}
						}break;
						
						case 3:
						{
							if(accIndex<20)
							{
								System.out.println("\n Set the password for your account : ");
								sc.nextLine();
								String pas = sc.nextLine();
								System.out.println("\n Enter the Account Holder Name : ");
								sc.nextLine();								String accName = sc.nextLine();
								System.out.println("\n Enter the Sarting balance : ");
								double bal = sc.nextDouble();
								bankAccounts[++accIndex] = new SalaryAccount(++accNo,pas,accName,bal);
								System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());

							}
							else
							{
								System.out.println("\n\n\t NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
							}
						}break;
						
						case 4:
						{
							if(accIndex<20)
							{
								System.out.println("\n Set the password for your account : ");
								sc.nextLine();
								String pas = sc.nextLine();
								System.out.println("\n Enter the Account Holder Name : ");
								sc.nextLine();								String accName = sc.nextLine();
								System.out.println("\n Enter the Loan amount you have taken : ");
								double loan = sc.nextDouble();
								bankAccounts[++accIndex] = new CurrentAccount(+accNo,pas,accName,loan);
								System.out.println(" YOUR ACCOUNT NUMBER IS : "+ bankAccounts[accIndex].getAccountNumber());

							}
							else
							{
								System.out.println("\n\n\t NO MORE ACCOUNTS CAN BE CREATED NOW \n\n");
							}
						}break;
					}
					
				}break;
				
				default : System.out.println("\n INVALID CHOICE ");
				
			}
			
			
		}while(choice!=0);
		sc.close();
		
		
		
		
	}

}

