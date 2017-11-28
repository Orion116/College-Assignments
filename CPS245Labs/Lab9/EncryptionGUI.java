/*************************************************************************
 *
 * File: EncryptionGUI.java
 *
 * Author: Joshua Wiley
 *
 * Description: Creates a graphical user interface (GUI) applet
 *              for the CyberPet class.
 *
 *  Date: 4-6-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EncryptionGUI extends Applet
                            implements ActionListener
{
    /*** Class Constants ***/

    private static final int MAX_SIZE_CHAR = 1;
    private static final int MAX_SIZE_SHIFT = 3;

    /*** Class Variables ***/

    private JTextField txtShift;
    private JTextField txtOriginalChar;
    private JTextField txtEncryptedChar;

    private JButton btnEncrypt;
    private JButton btnDecrypt;
    private JButton btnClear;

    private JTextArea txtADisplay = null;

    private Encryption cypher = null;

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

    	/*** Adds the panels to the GUI of the applet ***/

		c.setLayout( new GridLayout( 3, 1 ) );

    	c.add( "North",  pnlInput );
    	c.add( "Center", pnlButton );
    	c.add( "South",  pnlDisplay );
    }

    private JPanel inputPanel()
    {
        /*** Local variables ***/

	    JPanel pnlInput = null;

    	JLabel lblInput      = null;
		JLabel lblEncryption = null;
		JLabel lblDecryption = null;

		/*** Sets a New panel appearence ***/

    	pnlInput = new JPanel();

		pnlInput.setLayout( new GridLayout( 3, 2) );

        pnlInput.setBorder( BorderFactory.createLineBorder( Color.blue ) );

    	/*** Creates GUI compents ***/

    	lblInput = new JLabel( "     # Digits To Shift:" );
    	txtShift = new JTextField( MAX_SIZE_SHIFT );

        txtShift.setText( String.valueOf(txtShift.getText() ) );
		txtShift.setToolTipText( "( + or - max 26 )" );

    	lblEncryption   = new JLabel( "     Original Character:" );
    	txtOriginalChar = new JTextField( MAX_SIZE_CHAR );

        txtOriginalChar.setText( String.valueOf( txtOriginalChar.getText() ) );
		txtOriginalChar.setToolTipText( " i.e. '1' or 'a' or 'A' " );

    	lblDecryption   = new JLabel( "     Encrypted Character:" );
    	txtEncryptedChar = new JTextField( MAX_SIZE_CHAR );

        txtEncryptedChar.setText( " " );
		txtEncryptedChar.setToolTipText( " i.e. '1' or 'a' or 'A' " );

    	/*** Adds the GUI compents to the panel ***/

    	pnlInput.add( "North", lblInput );
    	pnlInput.add( "North", txtShift );

    	pnlInput.add( "Center", lblEncryption );
		pnlInput.add( "Center", txtOriginalChar );

    	pnlInput.add( "South", lblDecryption );
		pnlInput.add( "South", txtEncryptedChar );

    	return pnlInput;
    }

    private JPanel buttonPanel()
    {
		/*** Local Constants ***/

		final int WIDTH  = 80;
        final int HEIGTH = 30;

        /*** Local variables ***/

	    JPanel pnlButton = null;

	    pnlButton = new JPanel();

        pnlButton.setBorder( BorderFactory.createLineBorder( Color.blue ) );

	    /*** sets the name of the button and enables the action listener ***/

	    btnEncrypt = new JButton( "Encrypt" );
	    btnEncrypt.addActionListener( this );
		btnEncrypt.setPreferredSize( new Dimension( WIDTH, HEIGTH ) );

   	    btnDecrypt = new JButton( "Decrypt" );
	    btnDecrypt.addActionListener( this );
	    btnDecrypt.setPreferredSize( new Dimension( WIDTH, HEIGTH ) );

	    btnClear   = new JButton( "Clear" );
	    btnClear.addActionListener( this );
	    btnClear.setPreferredSize( new Dimension( WIDTH, HEIGTH ) );

	    /*** Adds the GUI compents to the panel ***/

	    pnlButton.add( btnEncrypt );
	    pnlButton.add( btnDecrypt );
    	pnlButton.add( btnClear );

    	return pnlButton;
    }

    private JPanel displayPanel()
    {
        /*** Local variables ***/

    	JPanel pnlOutput = null;
	  	pnlOutput   = new JPanel();

    	txtADisplay = new JTextArea( 5, 15);
        txtADisplay.setEditable( false );  //Sets the text field so no one can edit the text

        pnlOutput.setBorder( BorderFactory.createLineBorder( Color.blue ) );

    	/*** Adds the GUI compents to the panel ***/

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
    	/*** Create the object ***/

        cypher = new Encryption();

        /*** Create the GUI components ***/

    	buildGUI( this );

        /*** sets size of applet ****/

    	setSize( 300, 300 );
    }

    /*-------------------------------------------------------------------
    * Handle button events -- i.e. user clicks button
    *-------------------------------------------------------------------*/

    public void actionPerformed( ActionEvent e)
    {
    	/*** Sense which button is pressed then updates the display with the correct information ***/

    	if ( e.getSource() == btnEncrypt)
    	{
			encryptHandle();
        }

    	else if (e.getSource() == btnDecrypt )
    	{
            decryptHandle();
	    }

    	else if (e.getSource() == btnClear )
	    {
            clearHandle();
	    }
    }

   private void encryptHandle()
   {
	   /*** Local variables ***/

	   int shift;
	   char newcharacter;
	   String encryptString;

	   /*** Try and Catch ***/

       try
       {
           if ( txtShift.getText().trim().length() > 0
                && txtOriginalChar.getText().trim().length() > 0 ) //Checks that there are no blank input boxes
           {
    	       shift = Integer.parseInt( txtShift.getText().trim() );  //converts an integer to string
    	       newcharacter = txtOriginalChar.getText().trim().charAt( 0 ); //converts string to char

               if ( ( cypher.validateShift( shift ) ) && ( cypher.validateCharacter( newcharacter ) ) )
   	   	       {
		           cypher.setShift( shift );
   		           cypher.setCharacter( newcharacter );

                   newcharacter = cypher.encrypt( newcharacter, shift );
                   encryptString = String.valueOf( newcharacter ); //converts to string

   			       txtEncryptedChar.setText( encryptString );

   		           txtADisplay.setText( reportStatus( cypher ) );
   		       }

   		       else
   		           JOptionPane.showMessageDialog( null, "Invalid Input" );
            }
            else
                JOptionPane.showMessageDialog( null, "Invalid Input" );
       }
       catch ( NumberFormatException exc )
       {
    		JOptionPane.showMessageDialog( null, "Invalid Input" );
       }
       catch ( StringIndexOutOfBoundsException exc )
       {
    		JOptionPane.showMessageDialog( null, "Invalid Input" );
       }

  }

   private void decryptHandle()
   {
	   /*** Local variables ***/

       int shift;
       char newcharacter;
       String encryptString;

	   /*** Try and Catch ***/

       try
       {
           if ( txtShift.getText().trim().length() > 0
               && txtEncryptedChar.getText().trim().length() > 0 )  //Checks that there are no blank input boxes
           {
               shift = Integer.parseInt( txtShift.getText().trim() ); //converts an integer to string
               newcharacter = txtEncryptedChar.getText().trim().charAt( 0 ); //converts string to char

               if ( ( cypher.validateShift( shift ) ) && ( cypher.validateCharacter( newcharacter ) ) )
               {
                   newcharacter = cypher.decrypt( newcharacter, shift );
                   encryptString = String.valueOf( newcharacter ); //converts to string

                   cypher.setShift( shift );
                   cypher.setCharacter( newcharacter );

                   txtOriginalChar.setText( encryptString );

                   txtADisplay.setText( reportDecrypt( cypher ) );
               }

               else
                   JOptionPane.showMessageDialog( null, "Invalid Input" );
            }
            else
                JOptionPane.showMessageDialog( null, "Invalid Input" );
       }
       catch ( NumberFormatException exc )
       {
           JOptionPane.showMessageDialog( null, "Invalid Input" );
       }
       catch ( StringIndexOutOfBoundsException exc )
       {
           JOptionPane.showMessageDialog( null, "Invalid Input" );
       }

  }

    public void clearHandle()
    {
		cypher.setShift( cypher.SHIFT );
    	cypher.setCharacter( ' ' );

    	txtShift.setText( "" );
    	txtOriginalChar.setText( " " );
    	txtEncryptedChar.setText( " " );

    	txtADisplay.setText( " " );
    }

    private String reportStatus( Encryption cypher )
    {
    	/*** Local Variables ***/

    	String returnString = "";

    	returnString +=  "              Output:          ";
    	returnString +=  "\n    Shift: " + cypher.getShift();
    	returnString +=  "\n    Original Character: " + cypher.getCharacter();
    	returnString +=  "\n    Encryption Character: " + cypher.encrypt( cypher.getCharacter(), cypher.getShift() );

    	return returnString;
    }

    private String reportDecrypt( Encryption cypher )
    {
    	/*** Local Variables ***/

    	String returnString = "";

		returnString +=  "              Output:          ";
    	returnString +=  "\n    Shift: " + cypher.getShift();
    	returnString +=  "\n    Encryption Character: " + cypher.encrypt( cypher.getCharacter(), cypher.getShift() );
    	returnString +=  "\n    Decryption Character: " + cypher.getCharacter();

    	return returnString;
    }
}