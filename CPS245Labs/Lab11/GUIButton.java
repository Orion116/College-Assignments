/*************************************************************************
 *
 * File: GUIButton.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JButtons easier
 *
 *  Date: 4-18-15
 *
 * Comments:
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIButton extends JButton
{
	public GUIButton( String title )
	{
		super( title );

		setBackground( Color.WHITE );
		setForeground( Color.BLUE );
		setPreferredSize( new Dimension( 90,30 ) );
		setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );
		setBorder( new MatteBorder( 2,2,2,2, Color.BLACK ) );
	}
}