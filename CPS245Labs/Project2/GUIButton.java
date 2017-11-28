/*************************************************************************
 *
 * File: GUIButton.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JButtons
 *
 * Date: 5-20-15
 *
 * Comments: Added tooltips
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIButton extends JButton
{
	public GUIButton( String title, String toolTip, int width )
	{
		super( title );

		setToolTipText( toolTip );
		setBackground( Color.CYAN );
		setForeground( Color.BLUE );
		setPreferredSize( new Dimension( width, 50 ) );
		setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );
		setBorder( new MatteBorder( 2,2,2,2, Color.BLUE ) );
	}
}
