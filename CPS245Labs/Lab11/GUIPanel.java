/*************************************************************************
 *
 * File: GUIPanel.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JPanels easier
 *
 *  Date: 4-18-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIPanel extends JPanel
{
	public GUIPanel()
	{
		super();

		setBackground( Color.BLUE );
		setBorder( new MatteBorder( 2,2,2,2, Color.RED ) );
	}
}