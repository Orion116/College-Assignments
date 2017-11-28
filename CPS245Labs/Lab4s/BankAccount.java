
/***********************************************************************
* 
*	File: BankAccount.java
*
*	Project:  BankAccount
*   
*	Description:  This is part one of Lab3.  Its job is to provide methods
*				  and varibles.
*
*	Author:  Joshua Wiley
*
*	Date:  2-15-15
*
*	Comments:  Specs were a little hard to follow. It wasn't clear what the
*			   Test program did until part three.  Added two class methods 
*			   to send the current numbers to my test programs. Also corrected
*			   the poor programming practices.
* 
**********************************************************************/

public class BankAccount
{
	
	private final double BALANCE = 0;
	private final double INTEREST_RATE = 2;
   
    /*** Class Variables ***/
	
	private double balance, begBalance = BALANCE;
	private double interestRate = INTEREST_RATE;
	private double interest = 0;
	
	/*** Constructors ***/
	
	public BankAccount( double balance, double interestRate )
	{
		this.balance = balance;
		this.begBalance = balance;
		this.interestRate = interestRate;
	}
	
	public BankAccount( double balance )
	{
		this.balance = balance;
		this.begBalance = balance;
		this.interestRate = INTEREST_RATE;
	}
	
	/*** Class Methods -- Accessors ***/
	
	public double getInterestRate()
	{		
		return this.interestRate;
	}
	
	public double getInterest()
	{				 		
		return this.interest;
	}
	
	public double getBalance()
	{
	   	return  this.balance;
	}
	
	public double getbegBalance()
	{
	   	return  this.begBalance;
	}
	
	@Override 
	public String toString()
	{
		return "       Beginning Balance: $" + this.getbegBalance() + " Interest Rate: " + this.getInterestRate() + "%";
	} 
	
	/*** Mutators/transformers ***/
		
	public void deposit( double amount )
	{
		this.balance += amount;
	}
	
	public void withdraw( double amount )
	{
		this.balance -= amount;
	}
	
	public void addInterest()
	{
		this.interest = this.balance * ( this.interestRate / 1200 );
		this.balance = this.balance + this.interest;
	}
	
	
	/*** Application ***/
	
	public static void main( String[] args )
	{
	    /*** Local Variable ***/
		String space = "		 ";
		
		/*** Instantiate objects ***/
        BankAccount test = new BankAccount(500, 2);
		
		/*** Prints Test objects ***/	
		
        System.out.println( "\n---------------- Testing Objects ----------------\n");	
		System.out.println( space + "Balance: $" + test.getBalance() );
										
		test.deposit(20);
		System.out.println( space + "Deposit: $" + test.getBalance() );
		
		test.withdraw(10);
		System.out.println( space + "Withdrawal: $" + test.getBalance() );
		
		System.out.println( space + "Interest: " + test.getInterestRate() + "%" );
		
		System.out.println( space + "toString(): \n" );
		System.out.println( test.toString() );
								
	} 
}