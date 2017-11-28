/*************************************************************************
 *
 * File: CoffeeOrderGUI.java
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
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MagicSquareGUI
                            implements ActionListener
{
    /*** Class Constants ***/

	public static final int MINIMUM_NUMBER_SQUARE = 1;
	public static final int MAXIMUM_NUMBER_SQUARE = 9;
	public static final int NUMBER_OF_COLUMNS  = 3;
	public static final int NUMBER_OF_ROWS    = 3;

    /*** Class Variables ***/

    private int readNextLineCounter = 0;
    private String oldFileName = "";

					   //Creates text fields
    public static JTextField txtFileName;

					//Creates buttons
    private JButton btnCheckMagicBox;
    private JButton btnClear;
    private JButton btnExit;
    private JButton btnGetNextRecord;
					  //Creates a text area
    private JTextArea txtADisplay = null;

    public static JTextField magicSquare[][] = new JTextField[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    /*** Class Methods ***/
		   //displays the GUI
	public MagicSquareGUI()
	{
		startMagicSquareGUI();
	}
    			//Where the magic starts
    public void startMagicSquareGUI()
    {
		JFrame jfrWindow = null;
		Container c      = null;

    	/*** Create the object ***/

    	jfrWindow = new JFrame();
    	c = jfrWindow.getContentPane();

        /*** Create the GUI components ***/

        buildGUI( c );
		setWindowAttributes( jfrWindow );
    }
				 //Where the magic is built
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

    	/*** Adds the panels to the GUI ***/

		c.setLayout( new BoxLayout( c, BoxLayout.PAGE_AXIS ) );

    	c.add( pnlInput );
    	c.add( pnlButton );
    	c.add( pnlDisplay );
    }
				//Sets how the magic looks
    public void setWindowAttributes( JFrame jfrWindow )
	{
		jfrWindow.setSize( 800, 700 );
		jfrWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jfrWindow.setResizable( false );
    	jfrWindow.setLocation( 200, 40 );
		jfrWindow.setTitle( "Magic Square" );
		jfrWindow.pack();  //Pack made my GUI look like someone sat on it
		jfrWindow.setVisible( true );
	}

    private JPanel inputPanel()
    {
		/*** Local Constants ***/

		final int MAXIMUM_STRING_LENGTH = 3;

        /*** Local variables ***/

	    JPanel pnlInput = null;

		/*** Sets a New panel appearance ***/
									//Use titled border
    	pnlInput = new GUIPanel( 2, "Enter Number Integers Into the Magic Square" );

		pnlInput.setLayout( new GridBagLayout() );

		GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;

    	/*** Creates GUI components ***/

    	for ( int rows = 0; rows < NUMBER_OF_ROWS; rows++ )
    	{
			for ( int columns = 0; columns < NUMBER_OF_COLUMNS; columns++ )
    		{
    			magicSquare[rows][columns] = new GUITextField( MAXIMUM_STRING_LENGTH,
    														   3, "Enter Integer" );

    			/*** Adds the GUI components to the panel ***/

				         //Constraints for magicSquare[rows][columns]
				c.insets = new Insets( 5, 10,0,0);
				c.ipadx  = 50;
				c.ipady  = 50;
				c.gridx  = rows;
				c.gridy  = columns;
    			pnlInput.add( magicSquare[rows][columns], c );
			}
		}

    	return pnlInput;
    }

    private JPanel buttonPanel()
    {
		/*** ***/

		final int MAXIMUM_FILE_NAME = 20;
        /*** Local variables ***/

	    JPanel pnlButton    = null;
	    JLabel lblFileInput = null;

	    pnlButton = new GUIPanel( 1, "" );  //Use untitled border

		pnlButton.setLayout( new FlowLayout() );

		/*** ***/

		lblFileInput = new GUILabel( "Enter File Name:" );
		txtFileName  = new GUITextField( MAXIMUM_FILE_NAME, 1, "Complete file name i.e. Input.txt" );

	    /*** sets the name of the button and enables the action listener ***/

	    btnCheckMagicBox = new GUIButton( "Check Magic Square" );
	    btnCheckMagicBox.addActionListener( this );

	    btnGetNextRecord  = new GUIButton( "Get Next Record" );
		btnGetNextRecord.addActionListener( this );

	    btnClear  = new GUIButton( "Clear" );
	    btnClear.addActionListener( this );

	    btnExit   = new GUIButton( "Exit" );
	    btnExit.addActionListener( this );

	    /*** Adds the GUI components to the panel ***/

	    pnlButton.setBorder( BorderFactory.createEmptyBorder( 15, 15, 15, 15 ) );
	    pnlButton.add( lblFileInput );
	    pnlButton.add( txtFileName );
	    pnlButton.add( btnCheckMagicBox );
    	pnlButton.add( btnGetNextRecord );
		pnlButton.add( btnClear );
    	pnlButton.add( btnExit );

    	return pnlButton;
    }

    private JPanel displayPanel()
    {
        /*** Local variables ***/

    	JPanel pnlOutput = null;
	  	pnlOutput   = new GUIPanel( 2, "Invoice" ); //Use titled border
						  //Sets the display size
    	txtADisplay = new GUITextArea( 5, 35 );

    	/*** Adds the GUI components to the panel ***/

    	pnlOutput.add( txtADisplay );

    	return pnlOutput;
    }

    /*-------------------------------------------------------------------
    * Handle button events -- i.e. user clicks button
    *-------------------------------------------------------------------*/

    public void actionPerformed( ActionEvent e)
    {
    	/*** Performs an action when a button is pressed ***/

    	if ( e.getSource() == btnCheckMagicBox )
    	{
			processCheckMagicBox(1);
        }
        else if (e.getSource() == btnGetNextRecord )
	    {
			clearDisplay();
			nextRecordFile();
		}
    	else if (e.getSource() == btnClear )
	    {
            clearDisplay();
	    }
	    else if (e.getSource() == btnExit )
		{
            System.exit(0);
	    }
    }
				//Clears all the fields
    private void clearDisplay()
    {
		for ( int rows = 0; rows < NUMBER_OF_ROWS; rows++ )
		{
		     for ( int columns = 0; columns < NUMBER_OF_COLUMNS; columns++ )
		   	 {
				 ErrorHighlighting.setTextField( magicSquare[rows][columns], true );
				 magicSquare[rows][columns].setText( " " );
			 }
		 }

    	txtADisplay.setText( " " );
    }

	  			 //The id is passed to so the program knows where to print
	private void processCheckMagicBox( int id )
	{
		int integerValues[][] = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		int count[] = new int[MAXIMUM_NUMBER_SQUARE + 1];

		String errorMessage = "";
		int rows = 0;
		int columns = 0;
		boolean error = false;

		txtADisplay.setText( " " );

		for ( int i = 0; i < count.length; i++ )
			count[i] = 0;

		while (  rows < NUMBER_OF_ROWS && !error )
		{
			while (  columns < NUMBER_OF_COLUMNS && !error )
		    {
				magicSquare[columns][rows].setText( magicSquare[columns][rows].getText().trim() );

    			if ( MagicSquareCO.textFieldValidation( magicSquare[columns][rows].getText() ) )
				{
					errorMessage += "NO Number Entered \n";
					error = true;
				}
				else if ( MagicSquareCO.integerValidation( magicSquare[columns][rows].getText() ) )
				{
					errorMessage += "Error Integer not Entered \n";
					error = true;
				}
				else
				{
					integerValues[rows][columns] = Integer.parseInt(
												   magicSquare[columns][rows].getText() );

					if ( MagicSquareCO.validRange( integerValues[rows][columns], MINIMUM_NUMBER_SQUARE,
																                 MAXIMUM_NUMBER_SQUARE ) )
					{
						errorMessage += "Out of Range ( " + MINIMUM_NUMBER_SQUARE + ", " +
															MAXIMUM_NUMBER_SQUARE + " ) \n";
						error = true;
					}
					else
					{
						count[integerValues[rows][columns]]++;

						if ( count[ integerValues[rows][columns] ] > 1 )
						{
							errorMessage += "Duplicate Integer \n";
							error = true;
						}
						else
						{
							ErrorHighlighting.setTextField( magicSquare[columns][rows], true );
							columns++;
						}
					}
				}

				if ( error )
				{	//Pop up message
					ErrorHighlighting.setTextField( magicSquare[columns][rows], false );
					JOptionPane.showMessageDialog( null,"Invalid Information Entered !\n" + errorMessage );
				}
			}
			//COMMENT GOES HERE
			columns = 0;
			rows++;
		}
		if ( !error )
			error = SumValidation.SumValidation( integerValues );

		if ( !error )
		{
			txtADisplay.setText( "YEAH" );
		}
		else
		{
			txtADisplay.setText( "SORRY YOU LOST THE GAME" );
		}
	}
				 //The id is passed to so the program knows where to print
	private void nextRecordFile()
	{
		File file = null;
		JOptionPaneErrorPopUp errorPopUp = null;
		String readFromTextFile[] = null;

		if ( MagicSquareCO.textFieldValidation( txtFileName.getText() ) )
			errorPopUp = new JOptionPaneErrorPopUp( "Please enter a file name." );
		else
		{
		    String fileName = txtFileName.getText();

		    if ( !fileName.equals( this.oldFileName ) )
		    {
				readNextLineCounter = 0;
				this.oldFileName = fileName;
			}

	    	readNextLineCounter++;
        	readFromTextFile = TextFileReader.readTextFile( fileName, readNextLineCounter );

        	if ( readFromTextFile != null )
        	{
        		setUpMagicSquare( readFromTextFile );

			}
			else
			{
				errorPopUp = new JOptionPaneErrorPopUp( "End of file reached." );
				readNextLineCounter = 0;
			}
		}
	}

	private void setUpMagicSquare( String readFromTextFile[] )
	{
		int rows = 0;
		int columns = 0;
		int textFileIndex = 0;
		for ( textFileIndex = 0; textFileIndex < readFromTextFile.length; textFileIndex++ )
			System.out.println( "ARRAY: " + readFromTextFile[textFileIndex] );

		textFileIndex = 0;

		while (  rows < NUMBER_OF_ROWS && textFileIndex < readFromTextFile.length  )
		{
			while (  columns < NUMBER_OF_COLUMNS && textFileIndex < readFromTextFile.length )
		    {
				magicSquare[columns][rows].setText( readFromTextFile[textFileIndex] );
				columns++;
				textFileIndex++;
			}
			rows++;
			columns = 0;
		}
	}

    /*** Application ***/

    public static void main( String args[] )
    {
		MagicSquareGUI test = new MagicSquareGUI();

		//test.startCoffeeOrderGUI(); TEST OBJECT
	}
}
