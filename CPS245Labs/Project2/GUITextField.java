/*************************************************************************
 *
 * File: GUITextField.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JTextField easier
 *
 * Date: 4-18-15
 *
 * Comments:
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUITextField extends JTextField
{
	public GUITextField( int columns, int align, String toolTip, int fontSize )
	{
		super( columns );

		if ( align == 1 )   //Left align letters
			setHorizontalAlignment( JTextField.LEFT );
		else if ( align == 2 )         //Right aligns numbers
			setHorizontalAlignment( JTextField.RIGHT );
		else if ( align == 3 )
			setHorizontalAlignment( JTextField.CENTER );

		setToolTipText( toolTip );
		setForeground( Color.BLUE );
		setFont( new Font( "Times New Roman", Font.BOLD, fontSize ) );
		setBorder( new MatteBorder( 2,2,2,2, Color.CYAN ) );
	}
}
