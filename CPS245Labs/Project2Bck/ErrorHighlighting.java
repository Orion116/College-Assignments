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

public class ErrorHighlighting
{
	/*** Text field validation colors ***/

	public static void setTextField( JTextField errorInField, boolean valid )
	{
		if ( valid )
		{
			errorInField.setBackground( Color.WHITE );
			errorInField.setForeground( Color.BLUE );

			/*** Limits the length of the textfield ***/

			//if ( errorInField.getText().length() > MAX_SIZE_STRING )
			//    errorInField.setText( errorInField.getText().substring( 0, MAX_SIZE_STRING - 1 ) );
		}
		else
		{
			errorInField.setBackground( Color.RED );
			errorInField.setForeground( Color.WHITE );
			//errorInField.setText( errorInField.getText() );
			errorInField.requestFocus();
			errorInField.selectAll();
		}
	}
}
