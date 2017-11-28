/*************************************************************************
 *
 * File: IntField.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform IntTextField
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;

public class IntField extends GUITextField
{
	/*** Class Variables ***/

	private int minBound = MagicSquareGUI.MINIMUM_NUMBER_SQUARE;
	private int maxBound = MagicSquareGUI.MAXIMUM_NUMBER_SQUARE;

	/*** Class Methods ***/

	public IntField( int columns, int align, String toolTip, int fontSize, int min, int max )
	{
		super( columns, align, toolTip, fontSize );

		this.minBound = min;
		this.maxBound = max;
	}

	/*** Accessor ***/

	public int getInt() throws ExceptionHandling
	{
		/*** Local Constants ***/

		final String text = getText();

		/*** Local Variables ***/

		int stringToInt = 0;

		/*** Try/Catch to get parsing error ***/

		try
		{
			if ( text != null && text.trim().length() != 0 )
			{
				stringToInt = Integer.parseInt(text);
			}
			else
			{
				ErrorHighlighting.setTextField( this, false );
				throw new ExceptionHandling( "No Integer Entered");
			}
		}
		catch( NumberFormatException e )
		{
			ErrorHighlighting.setTextField( this, false );
			throw new ExceptionHandling( "No Integer Entered" );
		}
		validRange( stringToInt, this.minBound, this.maxBound );

		return stringToInt;
	}

	/*** Setter ***/

	public void setInt(int value)
	{
		setText(String.valueOf(value));
	}

	/*** Helper Method ***/

	private void validRange( int value,
							 int minValue,
							 int maxValue ) throws ExceptionHandling
	{
		/*** Checks if value is in range ***/

		if ( value < minValue || value > maxValue )
		{
			ErrorHighlighting.setTextField( this, false );
			throw new ExceptionHandling( minValue, maxValue);
		}
	}
}
