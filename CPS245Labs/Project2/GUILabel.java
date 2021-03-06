/*************************************************************************
 *
 * File: GUILabel.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JLabels
 *
 * Date: 4-18-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUILabel extends JLabel
{
	public GUILabel( String title )
	{
		super( title );

		setForeground( Color.BLUE );
		setHorizontalAlignment( SwingConstants.LEFT );
		setFont( new Font( "Times New Roman", Font.BOLD, 22 ) );
	}
}
