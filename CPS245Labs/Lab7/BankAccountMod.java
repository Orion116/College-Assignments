/***********************************************************************
*
*	File: BankAccountUserMod.java
*
*	Assignment:  BankAccount Modified
*
*	Description:  Models a bank 
*
*	Author:  Joshua Wiley
*
*	Date:  3-16-15
*
*	Comments:  Add stuff to validate external objects.
*
**********************************************************************/

public class BankAccountMod
{   
    /*** Class Constances ***/
	
    public static final String DEFAULT_NAME = "No Name";
	private static final double BALANCE = 0.0;
	private static final double INTEREST_RATE = 2.0;
    private static final double INTEREST = 0.0;
    private static final double MAX_BALANCE = 1000001.0;
	
	/*** Class Variables ***/
	
	private String name = DEFAULT_NAME;
	private double balance = BALANCE;
	private double interestRate = INTEREST_RATE;
	private double interest = INTEREST;
	
	/*** Constructors ***/
	
	public BankAccountMod()
	{
	    this.name = DEFAULT_NAME;
		this.balance = BALANCE;
		this.interestRate = INTEREST_RATE;
	    this.interest = INTEREST;
	}
	public BankAccountMod( String name )
	{
	    this.setName( name );
		this.balance = BALANCE;
		this.interestRate = INTEREST_RATE;
		this.interest = INTEREST;
	}
	
	public BankAccountMod( double balance )
	{
	    this.name = DEFAULT_NAME;
		this.deposit( balance );
		this.interestRate = INTEREST_RATE;
		this.interest = INTEREST;
	}
	
	public BankAccountMod( String name, double balance, double interestRate )
	{
	    this.setName( name );
	    this.deposit( balance );
		this.setInterestRate( interestRate );
		this.interest = INTEREST;
	}
	
	
	/*** Class Methods -- Accessors ***/
	
	public String getName()
	{
		return this.name;
	}
	
	public double getBalance()
	{
	   	return  this.balance;
	}
	
	public double getInterestRate()
	{		
		return this.interestRate;
	}
	
	public double getInterest()
	{				 		
		return this.interest;
	}
		
	@Override 
	public String toString()
	{
	    /*** Local Constants ***/
	
	    final String FORMAT_STRING  = "%15s %10s "; 
		final String FORMAT_STRING1 = "%10s $%,9.2f ";
		final String FORMAT_STRING2 = "%10s %5.2f ";
		
		/*** Local Variables ***/
	
	    String returnString = "";
		
		returnString += String.format( FORMAT_STRING, "Name:", this.getName() ); 
		returnString += String.format( FORMAT_STRING1, "Balance:", this.getBalance() );
		returnString += String.format( FORMAT_STRING2, "Interest Rate:", this.getInterestRate() );
		returnString += String.format( FORMAT_STRING1, "Interest:", this.getInterest() );
		
		return returnString;
	} 
	
	/*** Mutators/transformers ***/
	
	public void setName(String name)
	{
	    if ( validateName( name ) )
		   this.name = name;
		else
		    this.name = DEFAULT_NAME;   //set to default if new account and/or invalid name
	}
		
	public void deposit( double amount )
	{
	    if ( validateBalance( amount ) )
		   this.balance += amount;
	}
	
	public void withdraw( double amount )
	{
	    if ( validateBalance( amount ) )
		   this.balance -= amount;
	}
	 
	public void setInterestRate( double rate )
	{
		if ( validateInterestRate( rate ) )
		    this.interestRate = rate;
	 }
	 
	 public void addInterest()
	 {
	    if ( this.balance > 0)  // Cannot calculate - interest
		{
		    this.interest = this.balance * ( this.interestRate / 1200 );
		    this.balance = this.balance + this.interest;	
		} 
	 }
	 
	 /*** Helper methods ***/
	 
	 public boolean validateName( String name )
	 {
	 	 /*** Local Variable ***/
		 
		 boolean status = false;
		 
		 if ( name.length() > 0 && name.length() < 15 )
		    status = true;
		 	
	     return status; 
	 }
	 
	 public boolean validateBalance( Double balance )
	 {
	     /*** Local Variable ***/
		 
		 boolean status = false;
	 	 
		 if ( balance >= 0 && balance < MAX_BALANCE )
		 	status = true;
		 
		 return status;
	 }
	 
	 public boolean validateInterestRate( Double interestRate )
	 {
	     /*** Local Variable ***/
		 
		 boolean status = false;
	 	 
		 if ( interestRate >= 0 && interestRate < 100 )
		 	status = true;
		 
		 return status;
	 }
	 
	 public boolean accountNameExists( String name )
	 {
	 	  /*** Local Variable ***/
		 
		 boolean status = false;
	 	 
		 if ( this.getName().equalsIgnoreCase( name ) )
		 	status = true;
		 
		 return status;
	 }
}