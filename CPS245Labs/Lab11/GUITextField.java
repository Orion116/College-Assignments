/*************************************************************************
 *
 * File: GUITextField.java
 *
 * Author: Joshua Wiley
 *
 * Description: Creates a graphical user interface (GUI) applet
 *              for the CyberPet class.
 *
 *  Date: 4-6-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUITextField extends JTextField
{
	public GUITextField( int columns )
	{
		super( columns );

		setBackground( Color.WHITE );
		setForeground( Color.BLUE );
		setHorizontalAlignment( JTextField.LEFT );
		setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );
		setBorder( new MatteBorder( 2,2,2,2, Color.BLACK ) );
	}
}