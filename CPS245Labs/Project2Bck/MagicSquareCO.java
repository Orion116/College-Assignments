/*************************************************************************
 *
 * File: CoffeeOrderGUI.java
 *
 * Author: Joshua Wiley
 *
 * Description:  Models a coffee shops ordering system that prints an invoice
 *				 to the GUI component or the system console
 *
 * Date: 4-24-15
 *
 * Comments: I made the GUI non-resizable.  See tool tips for help.  Shipping
 *			 invoices uses all caps.
 *
 *************************************************************************/

import javax.swing.*;
import java.awt.*;

public class MagicSquareCO
{

    public static boolean textFieldValidation( String value )
    {
	    /*** Local variables ***/

		boolean error = false;  //Error checking

		/*** Validates the information before it is displayed ***/

		if ( !validateString( value ) )
		{
			error = true;
		}

		//else use default

		return error;
	}

    public static boolean integerValidation( String value )
    {
	    /*** Local variables ***/

		boolean error = false;  //Error checking
		JOptionPaneErrorPopUp errorPopUp = null;

		/*** Validates the information before it is displayed ***/

		try
		{

            //Checks to that the input can be parsed
			if ( errorInParse( value ) )
			{
				error = true;
			}

			//else use default
		}
		catch( ExceptionHandling e )
		{
			errorPopUp = new JOptionPaneErrorPopUp( "Invalid Input" );
		}

		return error;
	}

    private static boolean validateString( String newString )
    {
        boolean status = false;
					   //Makes sure the string is not empty
        if ( newString.trim().length() >= 1 )
            status = true;

        return status;
    }

  	private static boolean errorInParse( String parseString ) throws ExceptionHandling
	{
		/*** Local variable ***/

		boolean error = false;

		int parseValue;

		/*** Try/Catch for parsing the input ***/

		try
		{
			parseValue = Integer.parseInt( parseString );  //converts an integer to string

		}
		catch ( NumberFormatException exc ) //ExceptionHandling e )
		{
			error = true;
			throw new ExceptionHandling( "Invalid Input" );
   		}

		return error;
	}

	public static boolean validRange( double value,
									  double minValue,
									  double maxValue )
	{
		/*** Local Variable ***/

		boolean error = true;

		/*** Checks if value is in range ***/

		if ( value >= minValue && value <= maxValue )
			error = false;

		return error;
	}
}