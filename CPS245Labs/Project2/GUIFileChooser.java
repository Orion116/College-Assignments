/*************************************************************************
*
* File: GUIFileChooser.java
*
* Author: Joshua Wiley
*
* Description: Creates a file chooser
*
* Date:5-20-15
*
* Comments:
*
*************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GUIFileChooser extends JFileChooser
{
	private GUIFileChooser()
	{
		super();
	}

	public static String GUIFileChooser()
	{
		/*** Creates a file chooser ***/

		JFileChooser chooser = new JFileChooser();
			//Sets to the current directory
        chooser.setCurrentDirectory( new java.io.File(".") );

		/*** Local variables ***/

		String fileName = "";
		File file = null;
		int result = chooser.showOpenDialog( null );

        if ( result == APPROVE_OPTION)
        {
            file = chooser.getSelectedFile();
            fileName = file.getPath();
    	}
    	return fileName;
	}
}