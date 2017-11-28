/***********************************************************************
*
*	File: TestEmployeePayRoll.java
*
*	Assignment:  EmployeePayRoll
*
*	Description:  UI for employee pay roll.  Tests "all methods"
*
*	Author:  Joshua Wiley
*
*	Date:  2-28-15
*
*	Comments:  Assumes hours worked is between 0 and 168.  Pay rate 
*              between 0 and 200.  NOTE: pay rate of zero is volunteering.
*
**********************************************************************/

import java.util.Scanner;

public class TestEmployeePayRoll
{
    /*** Class test Method ***/

    public void startEmployeePayTest()
    {
        //local variables

        EmployeePayRoll payRoll = null;

        /*** Instantiate objects ***/

        payRoll = new EmployeePayRoll();
  
        /*** Retieves User Defined numbers --- Assumes Valid Input ***/
	
        getUserInput( payRoll );

        /*** Prints User Defined numbers --- Assumes Valid Input ***/

        displayEmployeeData(payRoll);
    }

    /*** helper methods ***/

    private void displayEmployeeData( EmployeePayRoll testPayRoll )
    {
        /*** Formats output --- Local Variables ***/

        String FormatString0 = "%n %35s %n %n";
        String FormatString1 = "%24s %10s %n";
        String FormatString2 = "%24s %,10.2f %n";
		String FormatString3 = "%24s $%,9.2f %n";

        /*** Prints Employee Data out ***/

        System.out.printf( FormatString0, "*** Testing Input State ***" );
        System.out.printf( FormatString1, "Employee Name:", testPayRoll.getEmployeeName( ));
        System.out.printf( FormatString2, "Hours Worked:", testPayRoll.getHoursWorked() );   
        System.out.printf( FormatString3, "Pay Rate:", testPayRoll.getPayRate() );
        System.out.printf( FormatString3, "Gross pay:", testPayRoll.calculateGrossPay());
		System.out.printf( FormatString0, "******* toString() ********" );
	    System.out.println(testPayRoll.toString());
        System.out.println();
    }
    
    private void getUserInput( EmployeePayRoll test )
    {
        /*** Receives User Input & Prints the question ***/

        System.out.println("\n\n----------Beginning User Input Test----------");
        getInput(test, "Employee Name: ");
        getInput(test,"Hours Worked: ");
        getInput(test,"Pay Rate: ");
    }

    private void getInput( EmployeePayRoll test, String id ) 
    {
        /*** Local Variables ***/
        Scanner input = new Scanner( System.in );
        double userInput;
		String FormatString = "%n %14s %s";
		
		/*** Selection statements ***/
		
        System.out.printf( FormatString, "Enter", id );
		
        if ( id  == "Employee Name: " )
		
            test.setEmployeeName(input.nextLine() );
		 
        else  
        {
            userInput = input.nextDouble();  //Gets user input

            if( id == "Hours Worked: " && userInput >= 0 && userInput <= 168 )  //Numeric input must >= to 0 and must be <= 168           
            {
                  test.setHoursWorked( userInput );
            }
			
            if( id == "Pay Rate: " && userInput >= 0 && userInput <= 200 )   //Can keep track of volunteer hours worked ie pay rate 0 
            {
                  test.setPayRate( userInput );
            }
            
        }
    }

    /*** Application ***/

    public static void main(  String[] args )
    {
        TestEmployeePayRoll test = new TestEmployeePayRoll();
        test.startEmployeePayTest();
    }
}