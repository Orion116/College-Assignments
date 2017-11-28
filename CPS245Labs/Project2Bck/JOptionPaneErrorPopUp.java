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

import java.awt.*;
import javax.swing.*;

public class JOptionPaneErrorPopUp extends JOptionPane
{
	public JOptionPaneErrorPopUp( String message )
	{
		JOptionPane.showMessageDialog( null, message );
	}
}