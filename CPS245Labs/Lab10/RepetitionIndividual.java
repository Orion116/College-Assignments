/***************************************************************
*
* File: RepetitionIndividual.java
*
* Author: Joshua Wiley
*
* Date: 4/10/15
*
* Description: Allows the user to enter a beginning number
*			   and lets them type sequence of numbers until
*			   a negative number is entered or an invalid input.
*
* Comments: Assumes the sequences doesn't need to be in order.
*
****************************************************************/

import java.util.*;

public class RepetitionIndividual
{
	/*** Class Constants ***/

	private final int MAX_NUMBER = 100000000;
	private final int SENTINEL_NUMBER = -1;

	/*** Class Variables ***/

	Scanner input = new Scanner( System.in );

	private int currentNumber;
	private int sentinelNumber = SENTINEL_NUMBER;
	private int smallestNumber = MAX_NUMBER;
	private int largestNumber = SENTINEL_NUMBER;

    private String displayNumber = "";

    private boolean flag = false;

	/*** Class Methods ***/

	private void repetitionUser()
	{
		/*** Loops until bad input ***/
															//Prompt
		System.out.println( "\n  Enter an integer number or negative number to end. " );

		/****************************************
		*
		*	Loops until invalid data is entered
		*	for exmaple when a letter or negative
		*	number is entered.
		*
		*****************************************/

		do
		{
			currentNumber = getUserInput();

					//Prevents an infinite loop by checking that a number was entered
			if ( !flag )
				flag = checkNumber( currentNumber );

			/*** Keeps track of the numbers ***/

			if ( !flag )
			{
				numberString();
				smallestNumber();
				largestNumber();
			}
		}
		while ( flag == false );

		outputDisplay();
	}

	private void outputDisplay()
	{
		System.out.println( "\n      You entered these numbers: " + displayNumber + "\n" );

		/*** Displays the smallest and largest if & only if there is a number entered  ***/

		if ( smallestNumber != MAX_NUMBER )
		{
			System.out.println( "      Smallest number entered: " + smallestNumber );
			System.out.println( "\n      Largest number entered: " + largestNumber + "\n" );
		}
	}

	private void numberString()
	{
		/*** Local Variables ***/

		String formatString = "%s, ";
		String numberList = String.valueOf( currentNumber );

		/*** Display ***/

        displayNumber += String.format( formatString, numberList );
	}

	private void smallestNumber()
	{
		if ( currentNumber < smallestNumber )
			smallestNumber = currentNumber;
	}

	private void largestNumber()
	{
		if ( currentNumber > largestNumber )
			largestNumber = currentNumber;
	}

	private boolean checkNumber( int currentNumber )
    {
		/*** Local Variables ***/

		boolean status = false;

		if ( currentNumber >= MAX_NUMBER || currentNumber <= sentinelNumber  )
			status = true;

		return status;
	}

	private int getUserInput()
	{
		/*** Catches bad input ***/

		try
		{
			/*** Receives User Input & Prints the question ***/

			System.out.println();
			System.out.print( "  Enter another number: " );
			currentNumber = input.nextInt();
		}
		catch( InputMismatchException exc )
		{
			System.out.println( "\n   Entered invalid input program ended ! ! ! " );
			flag = true;  //sets flag to true to prevent infinite looping.
		}

        return currentNumber;
	}

	/*** Application ***/

	public static void main( String[] args )
	{
		RepetitionIndividual test = new RepetitionIndividual();
		test.repetitionUser();
	}
}