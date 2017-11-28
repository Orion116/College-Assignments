/***********************************************************************
*
*	File: BankAccountUserMod.java
*
*	Assignment:  BankAccount Modified
*
*	Description:  Models a bank where users are creating a new account
*                 and then can edit the account.
*
*	Author:  Joshua Wiley
*
*	Date:  3-16-15
*
*	Comments:  it would have been easier if we had an array or a case 
*              statement the program would have been easier.  Assumes
*              duplicate names are ok since two accounts could have the 
*              same name.  Max accounts = 6. 
*
**********************************************************************/

import java.util.Scanner;

public class BankAccountUserMod
{
    /*** Class test Method ***/
	
    public void startBankTest()
    {
	    /*** local variables ***/

	    double menuOption;

        BankAccountMod BankAccount1 = null;
	    BankAccountMod BankAccount2 = null;
	    BankAccountMod BankAccount3 = null;
	    BankAccountMod BankAccount4 = null;
	    BankAccountMod BankAccount5 = null;
	    BankAccountMod BankAccount6 = null;

	    /*** Instantiate objects ***/

	    BankAccount1 = new BankAccountMod( "John" );
	    BankAccount2 = new BankAccountMod( "Smith", 500,  100 );
	    BankAccount3 = new BankAccountMod( );
	    BankAccount4 = new BankAccountMod( );
	    BankAccount5 = new BankAccountMod( );
	    BankAccount6 = new BankAccountMod( );
        
	    while ( true )
    	{
	    	 displayMainMenu();
		     menuOption = getUserInput("Menu Option");
			   
			 if ( menuOption == 1 ) //Checks to see if there is an available account open
	         {
		        openAccounts( BankAccount1, BankAccount2, 
				              BankAccount3, BankAccount4,
							  BankAccount5, BankAccount6 );
		     }
		     else if ( menuOption == 2 )
       		 {
		        existingAccounts( BankAccount1, BankAccount2, 
				              BankAccount3, BankAccount4,
							  BankAccount5, BankAccount6 );
		     }
	    	 else if ( menuOption == 3 )
		     {
		          System.exit( 0 );
		     }
		     else
		     {
			     System.out.println("Invalid Option");
		     }
	   }
	}
	
	private void openAccounts( BankAccountMod BankAccount1,
	                           BankAccountMod BankAccount2, 
							   BankAccountMod BankAccount3,
							   BankAccountMod BankAccount4,
							   BankAccountMod BankAccount5,
							   BankAccountMod BankAccount6 )
	{   
	    /*** Limits the number of accounts available ***/
		
		if ( BankAccount1.accountNameExists( BankAccount1.DEFAULT_NAME ) )
			        createNewAccount( BankAccount1 );
			    else if ( BankAccount2.accountNameExists( BankAccount2.DEFAULT_NAME ) )
			        createNewAccount( BankAccount2 );
			    else if ( BankAccount3.accountNameExists( BankAccount3.DEFAULT_NAME ) )
			        createNewAccount( BankAccount3 );
		        else if ( BankAccount4.accountNameExists( BankAccount4.DEFAULT_NAME ) )
			        createNewAccount( BankAccount4 );
		        else if ( BankAccount5.accountNameExists( BankAccount5.DEFAULT_NAME ) )
			        createNewAccount( BankAccount5 );
		        else if ( BankAccount6.accountNameExists( BankAccount6.DEFAULT_NAME ) )
			        createNewAccount( BankAccount6 );
			    else
			        System.out.println( "   Sorry Max Accounts Reached!" );
	}
	
	private void existingAccounts( BankAccountMod BankAccount1,
	                               BankAccountMod BankAccount2, 
		     					   BankAccountMod BankAccount3,
				    			   BankAccountMod BankAccount4,
					    		   BankAccountMod BankAccount5,
						    	   BankAccountMod BankAccount6 )
	{
	    /*** Local variable ***/
		
		double menuOption;
		
		/*** finds all available accounts ***/
		
		System.out.println("    Choose an Account:");
		System.out.println("    ------------------");
		displayExistingAccounts( 1, BankAccount1 );
		displayExistingAccounts( 2, BankAccount2 );
		displayExistingAccounts( 3, BankAccount3 );
		displayExistingAccounts( 4, BankAccount4 );
		displayExistingAccounts( 5, BankAccount5 );
		displayExistingAccounts( 6, BankAccount6 );
		System.out.println("\n    7. Exit Menu \n");

		menuOption = getUserInput("Menu Option");
        
		/*** account access ***/
		
        if ( menuOption == 1 && !BankAccount1.accountNameExists( BankAccount1.DEFAULT_NAME ) )
            accountChanges( BankAccount1 );
        else if ( menuOption == 2 && !BankAccount2.accountNameExists( BankAccount2.DEFAULT_NAME ) )
            accountChanges( BankAccount2 );
        else if ( menuOption == 3 && !BankAccount3.accountNameExists( BankAccount3.DEFAULT_NAME ) )
            accountChanges( BankAccount3 );
        else if ( menuOption == 4 && !BankAccount4.accountNameExists( BankAccount4.DEFAULT_NAME ) )
            accountChanges( BankAccount4 );
        else if ( menuOption == 5 && !BankAccount5.accountNameExists( BankAccount5.DEFAULT_NAME ) )
            accountChanges( BankAccount5 );
        else if ( menuOption == 6 && !BankAccount6.accountNameExists( BankAccount6.DEFAULT_NAME ) )
            accountChanges( BankAccount6 );
        else if ( menuOption == 7 )
		    return;  //void return. Returns to main menu.
		else	           
            System.out.println( "   Invalid Option" );
	}

	private void createNewAccount( BankAccountMod newBank )
	{
	    /*** Local variables ***/
		
	    String name;
	    double interestRate;
	    double withDrawAmount;
	    double depositAmount;
		
		System.out.println("\n---------- Enter New Account Information ----------");
		
		name = getUserName( "Account name" );
		newBank.setName( name );
		
		depositAmount = getUserInput("Beginning Balance");
		newBank.deposit( depositAmount );
		
	    interestRate = getUserInput("Interest Rate % for year ");
        newBank.setInterestRate( interestRate );
        
		/*** checks to see if there is a valid name ***/
		
		if ( !newBank.accountNameExists( newBank.DEFAULT_NAME ) )
		{
		    System.out.println("\n     Account Created \n");
		    System.out.println( newBank.toString() );
		}
		else   
		{
			 System.out.println("\n    ERROR IN ACCOUNT !");
			 System.out.println("    ------------------");
		}
	}
	
	private void accountChanges( BankAccountMod newBank )
	{
        /*** Local Variables ***/
		
		String name;
		double menuOption;
	    double interestRate;
	    double withDrawAmount;
	    double depositAmount;
        
		/*** Displays a Account ***/
		
		System.out.println( "\n    Account Holder: " + newBank.getName() );
	    displayMenu();
		menuOption = getUserInput("Menu Option");
        
		/*** Sub menu options for editing an account ***/
		
		if ( menuOption == 1 )
		{
	        name = getUserName( "New Name" );
			if ( name.equals("")  ||  name.equalsIgnoreCase( newBank.DEFAULT_NAME) )
			    System.out.println("    Invalid Name Change");
		    else
		    {
			    newBank.setName( name );
                System.out.println( newBank.toString() );
			}
		}
	    else if ( menuOption == 2 )
		{
			depositAmount = getUserInput( "Deposit" );
		    newBank.deposit( depositAmount );
		    System.out.println( newBank.toString() );
		}
		else if ( menuOption == 3 )
		{
			withDrawAmount = getUserInput("Withdrawal");
		    newBank.withdraw( withDrawAmount );
			System.out.println( newBank.toString() );
			
			if ( newBank.getBalance() < 0 )
			    System.out.println( "\n    WARNING YOU ARE OVERDRAWN ! \n" );	
		}
		else if ( menuOption == 4 )
		{
			interestRate = getUserInput("Interest Rate % for year ");
            newBank.setInterestRate( interestRate );
			System.out.println( newBank.toString() );
		}
		else if ( menuOption == 5 )
		{    
		    System.out.println("    Interest Add: \n" );
		    newBank.addInterest();
			System.out.println( newBank.toString() );
		}
		else if ( menuOption == 6 )
		{    
		    System.out.println("    Account Information is as Follows: \n" );
			System.out.println( newBank.toString() );
		}
		else if ( menuOption == 7 )
		{
			displayMenu();
		}
		else if ( menuOption == 8 )
		{
		    System.exit( 1 );
		}
		else
		{
			System.out.println("    Invalid Option");
		}
	}

    private double getUserInput( String id)
    {
        /*** Local Variables ***/
		
        double userInput;
	    Scanner input = new Scanner( System.in );

	    /*** Receives User Input & Prints the question ***/

	    System.out.println();
	    System.out.print("      Enter " + id + ": ");
	    userInput = input.nextDouble();
        System.out.println();
	    return userInput;
    }

	private String getUserName( String id)
    {
        /*** Local Variables ***/
		
	    Scanner input = new Scanner( System.in );
        String userInput;

	    /*** Receives User Input & Prints the question ***/

	    System.out.println();
	    System.out.print("      Enter " + id + ": ");
	    userInput = input.nextLine();
		System.out.println();
	    return userInput;
    }

	private void displayMainMenu()
	{
		final String FORMAT_STRING  = "%n    %-50s ";
		
		System.out.printf( FORMAT_STRING, "   Main Menu:");
		System.out.printf( FORMAT_STRING, "   ----------");
		System.out.printf( FORMAT_STRING, "1. Create an Account" );
		System.out.printf( FORMAT_STRING, "2. Access Existing Account" );
		System.out.printf( FORMAT_STRING, "3. Exit Program" );
		System.out.println();
	}

	private void displayMenu()
	{
		final String FORMAT_STRING  = "%n    %-50s ";

		System.out.printf( FORMAT_STRING, "   Account Menu:");
		System.out.printf( FORMAT_STRING, "   -------------");
		System.out.printf( FORMAT_STRING, "1. Change name" );
		System.out.printf( FORMAT_STRING, "2. Deposit" );
		System.out.printf( FORMAT_STRING, "3. Withdrawal" );
		System.out.printf( FORMAT_STRING, "4. Change Interest Rate" );
		System.out.printf( FORMAT_STRING, "5. Calculate Monthly Interest" );
		System.out.printf( FORMAT_STRING, "6. Display Account Information" );
		System.out.printf( FORMAT_STRING, "7. Back to Main Menu Options" );
		System.out.printf( FORMAT_STRING, "8. Exit Program" );
		System.out.println();
	}

	private void displayExistingAccounts( int id, BankAccountMod testBank )
	{
		if ( !testBank.accountNameExists( testBank.DEFAULT_NAME ) )
		{
		   System.out.println();
		   System.out.println("    " + id + "." + testBank.toString() );
		}
	}

    /*** Application ***/

    public static void main(  String[] args )
    {
	    BankAccountUserMod test = new BankAccountUserMod();
	    test.startBankTest();
    }
}