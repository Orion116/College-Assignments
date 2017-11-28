/*************************************************************************
 *
 * File: NumberReplacementGUI.java
 *
 * Author: Joshua Wiley
 *
 * Description: Creates a graphical user interface (GUI) applet
 *              for the CO of NumberReplacement.
 *
 *  Date: 4-18-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberReplacementGUI extends Applet
                            implements ActionListener
{
    /*** Class Constants ***/

    private static final int MAX_SIZE_STRING = 100;

    /*** Class Variables ***/

    private String convertedString = null;

    private JTextField txtOriginalString;

    private JButton btnConvert;
    private JButton btnClear;

    private JTextArea txtADisplay = null;

    /*** Class Methods ***/

    private void buildGUI( Container c )
    {
        /*** Local variables ***/

	    JPanel pnlInput   = null;
	    JPanel pnlButton  = null;
	    JPanel pnlDisplay = null;

	    /*** Sets what the panels to their respective methods will do ***/

    	pnlInput   = inputPanel();
    	pnlButton  = buttonPanel();
    	pnlDisplay = displayPanel();

		c.setLayout( new BoxLayout( c, BoxLayout.PAGE_AXIS ) );

    	/*** Adds the panels to the GUI of the applet ***/

    	c.add( pnlInput );
    	c.add( pnlButton );
    	c.add( pnlDisplay );
    }

    private JPanel inputPanel()
    {
        /*** Local variables ***/

	    JPanel pnlInput = null;
    	JLabel lblTitle = null;
		JLabel lblInput = null;

		/*** Sets a New panel appearance ***/

    	pnlInput = new GUIPanel();

		pnlInput.setLayout( new GridLayout( 3, 2) );

    	/*** Creates GUI components ***/

    	lblTitle = new GUILabel( "Switch Digits to Words" );

    	lblInput   = new GUILabel( "Input a Sentence ( Preferably with a single digit ) and Click Convert" );
    	txtOriginalString = new GUITextField( MAX_SIZE_STRING );

        txtOriginalString.setText( "  " + txtOriginalString.getText() );

    	/*** Adds the GUI components to the panel ***/

    	pnlInput.add( "North", lblTitle );

    	pnlInput.add( "Center", lblInput );
		pnlInput.add( "Center", txtOriginalString );

    	return pnlInput;
    }

    private JPanel buttonPanel()
    {
        /*** Local variables ***/

	    JPanel pnlButton = null;

	    pnlButton = new GUIPanel();

		pnlButton.setLayout( new FlowLayout() );

	    /*** sets the name of the button and enables the action listener ***/

	    btnConvert = new GUIButton( " Convert " );
	    btnConvert.addActionListener( this );

	    btnClear   = new GUIButton( "  Clear  " );
	    btnClear.addActionListener( this );

	    /*** Adds the GUI components to the panel ***/

	    pnlButton.add( btnConvert );
    	pnlButton.add( btnClear );

    	return pnlButton;
    }

    private JPanel displayPanel()
    {
        /*** Local variables ***/

    	JPanel pnlOutput = null;
	  	pnlOutput   = new GUIPanel();

    	txtADisplay = new GUITextArea( 16, 45 );

    	/*** Adds the GUI components to the panel ***/

    	pnlOutput.add( txtADisplay );

    	return pnlOutput;
    }

    /*-------------------------------------------------------------------
    * The init() method gets called automatically whenever a browser
    * displays an applet.  Method instantiates the instance variables,
    * including the object and GUI components that will be displayed
    * on the applet
    *-------------------------------------------------------------------*/

    public void init()
    {
        /*** Create the GUI components ***/

    	buildGUI( this );

        /*** sets size of applet ****/

    	setSize( 700, 520 );
    }

    /*-------------------------------------------------------------------
    * Handle button events -- i.e. user clicks button
    *-------------------------------------------------------------------*/

    public void actionPerformed( ActionEvent e)
    {
    	/*** Sense which button is pressed then updates the display with the correct information ***/

    	if ( e.getSource() == btnConvert)
    	{
			if ( txtOriginalString.getText().trim().length() <= 0 )
			{
				JOptionPane.showMessageDialog( null, "Please Enter a Sentence" );
			}
			else
			{
           		convertedString = numbersProcessing( txtOriginalString.getText() );
           		txtADisplay.setText( "\n     " + convertedString );
			}
        }

    	else if (e.getSource() == btnClear )
	    {
            clearHandle();
	    }
    }

    private String numbersProcessing( String originalString )
   {
	   /*** Local variables ***/

	   String returnString = originalString;

       returnString = NumberReplacement.replaceWithString( originalString, "0", "zero");
       returnString = NumberReplacement.replaceWithString( returnString, "1", "one");
       returnString = NumberReplacement.replaceWithString( returnString, "2", "two");
       returnString = NumberReplacement.replaceWithString( returnString, "3", "three");
       returnString = NumberReplacement.replaceWithString( returnString, "4", "four");
       returnString = NumberReplacement.replaceWithString( returnString, "5", "five");
       returnString = NumberReplacement.replaceWithString( returnString, "6", "six");
       returnString = NumberReplacement.replaceWithString( returnString, "7", "seven");
       returnString = NumberReplacement.replaceWithString( returnString, "8", "eight");
       returnString = NumberReplacement.replaceWithString( returnString, "9", "nine");

       return returnString;
  }

    public void clearHandle()
    {
    	txtOriginalString.setText( " " );

    	txtADisplay.setText( " " );
    }
}