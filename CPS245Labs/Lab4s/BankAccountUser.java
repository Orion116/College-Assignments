/***********************************************************************
* 
*	File: BankAccountUser.java
*
*	Project:  BankAccount
*   
*	Description:  Tests "all methods" of the program BankAccount
*
*	Author:  Joshua Wiley
*
*	Date:  2-21-15
*
*	Comments:  Specs were a little hard to follow. Assumed user input 
*                  was for all variables and a new balance was printed after
*                  each method was tested. Not sure what you meant by put all 
*                  print statements in "main" as you showed us in class to use 
*                  helper method. Assume valid input.
* 
**********************************************************************/

import java.util.Scanner;

public class BankAccountUser
{
    /*** Class test Method ***/

    public void startBankTest()
    {
	//local variables

	double begBalance;
	double interestRate;
	double withDrawAmount;
	double depositAmount;		
	BankAccount BankAccount1 = null;
	BankAccount BankAccount2 = null;
	
	/*** Instantiate objects ***/
	
	BankAccount1 = new BankAccount( 500 );
	BankAccount2 = new BankAccount( 500, 10 );
	
        /*** Prints predefined Numbers ***/ 
	
	System.out.println("\n\n----------Predefined Values Test----------");
	displayBankAccount("Beginning Balance $500, Default Interest Rate of 2%, Deposit $20, Withdrawal $40", BankAccount1,20,40);
	displayBankAccount("Beginning Balance $500, Interest Rate 10%, Deposit $20, Withdrawal $40", BankAccount2,20,40);
	System.out.println();
	
	/*** Retieves User Defined numbers --- Assumes Valid Input ***/ 

	System.out.println("\n----------Beginning User Input Test----------");	
	begBalance = getUserInput("Beginning Balance");
	interestRate = getUserInput("Interest Rate % for year ");
	depositAmount = getUserInput("Deposit Amount");       
	withDrawAmount = getUserInput("Withdrawal Amount");

	/*** Resets beginning balance and interest rate ***/

	BankAccount1 = new BankAccount(begBalance,interestRate);
	BankAccount2 = new BankAccount( 500, 10 );
        
        /*** Prints User Defined numbers --- Assumes Valid Input ***/ 

 	displayBankAccount("User Inputed", BankAccount1,depositAmount,withDrawAmount);
	displayBankAccount("Beginning Balance $500, Current Interest Rate of 10%, Deposit $20, Withdrawal $40", BankAccount2,20,40);
    }

    /*** helper methods ***/

    private void displayBankAccount(String id, BankAccount testBank, double depositAmount, double withDrawAmount)
    {
        /*** Formats output --- Local Variables ***/
  
	String FormatString1 = "%25s %s %,9.2f%n%n"; 
        String FormatString2 = "%25s %,11.2f%s%n%n";		
	
        /*** Prints Bank Stuff out ***/
	
	System.out.println( "\n   ***Testing " + id + " State***\n");	
	System.out.printf( FormatString1, "Beginning Balance:", "$", testBank.getBalance());
	System.out.printf( FormatString2, "Interest Rate:", testBank.getInterestRate(), "%");
										
	testBank.deposit(depositAmount);
	System.out.printf( FormatString1, "Deposit:", "$",       depositAmount); 
	System.out.printf( FormatString1, "New balance:", "$",  testBank.getBalance());
		
	testBank.withdraw(withDrawAmount);
	System.out.printf( FormatString1, "Withdrawal:", "$",   withDrawAmount);
	System.out.printf( FormatString1, "New balance:", "$",  testBank.getBalance());
		
	testBank.addInterest();
	System.out.printf( FormatString1, "Added Interest:", "$", testBank.getInterest() );
	System.out.printf( FormatString1, "Final balance:", "$", testBank.getBalance() );
	System.out.println(testBank.toString());	
	System.out.println();
    }
    
    private double getUserInput( String id)
    {
        /*** Local Variables ***/

	Scanner input = new Scanner( System.in );
        double userInput;

	/*** Recieves User Input & Prints the question ***/	

	System.out.println();
	System.out.print("      Enter " + id + ": ");
	userInput = input.nextDouble();

	return userInput;
    }
    
    /*** Application ***/

    public static void main(  String[] args )
    {
	BankAccountUser test = new BankAccountUser();
	test.startBankTest();							
    } 
}	