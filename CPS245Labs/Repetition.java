a/***********************************************************
*
* Authors: Josh Wiley and Jakob Patten
*
* Date: 4/10/15
*
* Description: Allows the user to enter a beginning number
*			   and lets them type consecutive numbers
*			   as long as it is one greater than the
*			   previous number.
*
* Comments:
*
***********************************************************/

import java.util.*;

public class Repetition
{
	/*** Class Constants ***/

	private final double MAX_NUMBER = 100000000;

	/*** Class Variables ***/

	Scanner input = new Scanner( System.in );

	private double currentNumber;
    private double sentinelNumber = -1;
    private double nextNumber = 1;

    private String displayNumber = "";

	/*** Class Methods ***/

	private void repetitionUser()
	{
		/*** Local variables ***/

		boolean flag = false;

		/*** Loops until bad input ***/

		System.out.println( "  Enter a consecutive number or -1 to end. " );
		do
		{
			currentNumber = getUserInput();
			flag = checkNumber( currentNumber, nextNumber );

			if ( !flag )
			{
				displayConsecutiveNumbers();
				nextNumber = currentNumber + 1;
			}
		}
		while ( flag == false );
			System.out.println( "\n      You entered these numbers: " + displayNumber + "\n" );
	}

	private void displayConsecutiveNumbers()
	{
		/*** Local Variables ***/

		String formatString = "%s, ";
		String numberList = String.valueOf( currentNumber );

		/*** Display ***/

        displayNumber += String.format( formatString, numberList );
	}

	private boolean checkNumber( double currentNumber, double nextNumber )
    {
		boolean status = false;
		if ( currentNumber != nextNumber || currentNumber >= MAX_NUMBER || currentNumber == sentinelNumber  )
			status = true;
		return status;
	}

	private double getUserInput()
	{
		/*** Receives User Input & Prints the question ***/

		try
		{
			System.out.println();
			System.out.print( "  Enter another number: " );
			currentNumber = input.nextDouble();
			System.out.println();

		}
		catch( InputMismatchException exc )
		{
			System.out.println( "\n   Entered invalid input program ended ! ! ! \n" );
		}

        return currentNumber;
	}

	/*** Application ***/

	public static void main( String[] args )
	{
		Repetition test = new Repetition();
		test.repetitionUser();
	}
}

