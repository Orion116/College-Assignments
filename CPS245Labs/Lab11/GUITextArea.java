/*************************************************************************
 *
 * File: GUITextArea.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JTextArea easier
 *
 *  Date: 4-18-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUITextArea extends JTextArea
{
	public GUITextArea( int rows, int columns )
	{
		super( rows, columns );

		setBackground( Color.WHITE );
		setForeground( Color.BLUE );
		setFont( new Font( "Times New Roman", Font.BOLD, 18 ) );
		setBorder( new MatteBorder( 2,2,2,2, Color.BLACK ) );
		setEditable( false );  //Sets the text field so no one can edit the text
	}
}