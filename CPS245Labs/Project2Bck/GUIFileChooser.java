/*************************************************************************
*
* File: GUIFileChooser.java
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

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GUIFileChooser extends JFileChooser
{
	private GUIFileChooser()
	{
	}
	public static String GUIFileChooser()
	{
		String fileName = "";

        JFileChooser chooser = new JFileChooser();
        //textFileFilter.addChoosableFileFilter(new FileNameExtensionFilter( "Text Files", ".txt" ) );
        int result = chooser.showOpenDialog( null );
        File file = null;
        if (result == 0)
        {
            file = chooser.getSelectedFile();
            fileName = file.getPath();
    	}
    	return fileName;
	}
}