/*************************************************************************
 *
 * File: GUIPanel.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JPanels easier
 *
 * Date: 4-18-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIPanel extends JPanel
{
	Border compound;  //Allows compounded borders
	Font myFont = new Font("Times New Roman", Font.BOLD, 30);
    Color myColor = Color.CYAN;

	public GUIPanel( int borderStyle, String title )
	{
		super();

		setBackground( Color.BLUE );

		if ( borderStyle == 1 ) //Default
			setBorder( new MatteBorder( 2,2,2,2, Color.CYAN ) );
		else
		{
            Border borderColor = BorderFactory.createMatteBorder( 2,2,2,2, Color.CYAN );
			compound = BorderFactory.createCompoundBorder( borderColor, compound );
			setBorder(compound);

			compound = BorderFactory.createTitledBorder( compound, title,
			                          					 TitledBorder.CENTER,
			                          					 TitledBorder.TOP, myFont, myColor );
			setBorder(compound);
		}
	}
}