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
import java.util.Date;
import java.text.*;
import java.time.LocalDate;

public class CoffeeOrderGUI
                            implements ActionListener
{
    /*** Class Constants ***/

	private static final int MAX_SIZE_STRING = 20;
	private static final int MAX_SIZE_STATE  = 2;
	private static final int MAX_SIZE_ZIP    = 5;

    /*** Class Variables ***/

					   //Creates text fields
    private JTextField txtName;
    private JTextField txtStreet;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtZipcode;
    private JTextField txtQtyOrdered;
					//Creates buttons
    private JButton btnCreate;
    private JButton btnPrint;
    private JButton btnClear;
    private JButton btnExit;
					  //Creates a text area
    private JTextArea txtADisplay = null;
				//Makes accessing these values less messy
    private int zipCode = 0;
    private int qtyOrdered = 0;

    /*** Class Methods ***/
		   //displays the GUI
	public CoffeeOrderGUI()
	{
		startCoffeeOrderGUI();
	}
    			//Where the magic starts
    public void startCoffeeOrderGUI()
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
		jfrWindow.setTitle( "MyJava Coffee Outlet" );
		//jfrWindow.pack();  Pack made my GUI look like someone sat on it
		jfrWindow.setVisible( true );
	}

    private JPanel inputPanel()
    {
        /*** Local variables ***/

	    JPanel pnlInput      = null;
    	JLabel lblName       = null;
		JLabel lblStreet     = null;
    	JLabel lblCity       = null;
		JLabel lblState      = null;
    	JLabel lblZipcode    = null;
		JLabel lblQtyOrdered = null;

		/*** Sets a New panel appearance ***/
									//Use titled border
    	pnlInput = new GUIPanel( 2, "Enter Shipping Information" );

		pnlInput.setLayout( new GridBagLayout() );

		GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;

    	/*** Creates GUI components ***/

    	lblName = new GUILabel( "Name:" );
    	txtName = new GUITextField( MAX_SIZE_STRING, true,
    	                            "Full Name i.e. John Smith" );
        txtName.setText( txtName.getText() );

    	lblStreet = new GUILabel( "Street Address:" );
    	txtStreet = new GUITextField( MAX_SIZE_STRING, true,
    								  "Delivery Address i.e. 1000 College Ave." );
        txtStreet.setText( txtStreet.getText() );

    	lblCity = new GUILabel( "City:" );
    	txtCity = new GUITextField( MAX_SIZE_STRING, true,
    								"City i.e. Green Bay" );
        txtCity.setText( txtCity.getText() );

    	lblState = new GUILabel( "State:" );
    	txtState = new GUITextField( MAX_SIZE_STATE, true,
    								 "U.S. Abbreviation i.e. WI " );
        txtState.setText( txtState.getText() );

    	lblZipcode = new GUILabel( "Zipcode:" );
    	txtZipcode = new GUITextField( MAX_SIZE_ZIP, false,
    								   "U.S. 5 Digit Zipcode in the range [01001-99950]" );
        txtZipcode.setText( txtZipcode.getText() );

    	lblQtyOrdered = new GUILabel( "Number of Bags to order:" );
    	txtQtyOrdered = new GUITextField( MAX_SIZE_ZIP, false,
    					"Sold in 2 lb. bags for $5.50 per bag.  Must be between ( 1-1500 )" );
        txtQtyOrdered.setText( txtQtyOrdered.getText() );

    	/*** Adds the GUI components to the panel ***/

				  //Constraints for lblName
		c.weighty   = .1;
		c.gridx     = 0;
		c.gridy     = 0;
    	pnlInput.add( lblName, c );
				  //Constraints for txtName
		c.weightx   = .1;
    	c.gridx     = 1;
		c.gridy     = 0;
		c.gridwidth = 2;  //Expands the cell width 2 cells
		pnlInput.add( txtName, c );
				//Constraints for lblStreet
		c.gridx     = 0;
		c.gridy     = 1;
		c.gridwidth = 1;  //Back to default cell width 1 cells
    	pnlInput.add( lblStreet, c );
				//Constraints for txtStreet
		c.gridx     = 1;
		c.gridy     = 1;
		c.gridwidth = 2;
		pnlInput.add( txtStreet, c );
				  //Constraints for lblCity
		c.weightx   = 0.1;
		c.gridx     = 0;
		c.gridy     = 2;
		c.gridwidth = 1;
    	pnlInput.add( lblCity, c );
				  //Constraints for txtCity
		c.weightx   = 0.1;
		c.gridx     = 1;
		c.gridy     = 2;
		pnlInput.add( txtCity, c );
				  //Constraints for lblState
		c.weightx   = 0.1;
		c.gridx     = 2;
		c.gridy     = 2;
    	pnlInput.add( lblState, c );
				  //Constraints for txtState
    	c.weightx   = 0.1;
		c.gridx     = 3;
		c.gridy     = 2;
		pnlInput.add( txtState,c );
				  //Constraints for lblZipcode
		c.weightx   = 0.1;
		c.gridx     = 4;
		c.gridy     = 2;
    	pnlInput.add( lblZipcode, c );
				  //Constraints for txtZipcode
    	c.weightx   = 0.1;
		c.gridx     = 5;
		c.gridy     = 2;
		pnlInput.add( txtZipcode, c );
				  //Constraints for lblQtyOrdered
		c.weightx   = 0.1;
		c.gridx     = 1;
		c.gridy     = 3;
    	pnlInput.add( lblQtyOrdered, c );
				//Constraints for txtQtyOrdered
		c.gridx    = 2;
		c.gridy    = 3;
		pnlInput.add( txtQtyOrdered, c );

    	return pnlInput;
    }

    private JPanel buttonPanel()
    {
        /*** Local variables ***/

	    JPanel pnlButton = null;

	    pnlButton = new GUIPanel( 1, "" );  //Use untitled border

		pnlButton.setLayout( new FlowLayout() );

	    /*** sets the name of the button and enables the action listener ***/

	    btnCreate = new GUIButton( "Create Invoice" );
	    btnCreate.addActionListener( this );

	    btnPrint  = new GUIButton( "Print Invoice" );
		btnPrint.addActionListener( this );

	    btnClear  = new GUIButton( "Clear" );
	    btnClear.addActionListener( this );

	    btnExit   = new GUIButton( "Exit" );
	    btnExit.addActionListener( this );

	    /*** Adds the GUI components to the panel ***/

	    pnlButton.setBorder( BorderFactory.createEmptyBorder( 15, 15, 15, 15 ) );
	    pnlButton.add( btnCreate );
    	pnlButton.add( btnPrint );
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
    	txtADisplay = new GUITextArea( 19, 52 );

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

    	if ( e.getSource() == btnCreate)
    	{
			processInvoice(1);
        }
        else if (e.getSource() == btnPrint )
	    {
			processInvoice(2);
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
    public void clearDisplay()
    {
    	txtName.setText( " " );
    	setTextField( txtName, true );
    	txtStreet.setText( " " );
    	setTextField( txtStreet, true );
    	txtCity.setText( " " );
    	setTextField( txtCity, true );
    	txtState.setText( " " );
    	setTextField( txtState, true );
    	txtZipcode.setText( " " );
    	setTextField( txtZipcode, true );
    	txtQtyOrdered.setText( " " );
    	setTextField( txtQtyOrdered, true );
    	txtADisplay.setText( " " );
    }

	  			 //The id is passed to so the program knows where to print
	private void processInvoice( int id )
	{
		txtADisplay.setText( " " );

		if ( invoiceValidation() )
		{
			displayInvoice( id );
		}
	}
				 //The id is passed to so the program knows where to print
	private void displayInvoice( int id )
	{
		/*** Local Constants ***/

		final int ARRIVAL_DATE = 14;

		final String FORMATSTRING_0 = "%n";
		final String FORMATSTRING_1 = "%26s  %-1s %n";
		final String FORMATSTRING_2 = "%26s %13s $%7.2f %n";
		final String FORMATSTRING_3 = "%26s%n";
		final String FORMATSTRING_4 = "%30s %3d %5s $%7.2f %n";
		final String FORMATSTRING_5 = "%18s    %-1s %n";
		final String FORMATSTRING_6 = "%18s    %-1s, %-1s %5s %n";

		/*** Local Variables ***/

		String displayString = "";
		int large = CoffeeOrders.largeBoxesNeeded( qtyOrdered );
		int medium = CoffeeOrders.mediumBoxesNeeded( qtyOrdered );
		int small = CoffeeOrders.smallBoxesNeeded( qtyOrdered );

		/*** The date stuff ***/

		SimpleDateFormat dateFormat = new SimpleDateFormat( "MMMMM dd, YYYY" );
    	Date currentDate = new Date();

		String currentDateString = dateFormat.format( currentDate );
		String arrivalDateString = futureDate( currentDate, ARRIVAL_DATE );

		/*** Display code ***/

		displayString += String.format( FORMATSTRING_0 );
		displayString += String.format( FORMATSTRING_1, "Customer Name:",
		                                txtName.getText().toUpperCase() );
		displayString += String.format( FORMATSTRING_1, "Number of Bags Ordered:",
		                                txtQtyOrdered.getText() );
		displayString += String.format( FORMATSTRING_2, "Purchase Price:", " ",
										CoffeeOrders.calculatePurchasePrice( qtyOrdered ) );
		displayString += String.format( FORMATSTRING_0 );
		displayString += String.format( FORMATSTRING_3, "Boxes Used:" );
		displayString += String.format( FORMATSTRING_4, "Large:", large, "Cost:",
										CoffeeOrders.boxSizeCost( large,
										                          CoffeeOrders.LARGE_BOX_PRICE ) );
		displayString += String.format( FORMATSTRING_4, "Medium:", medium, "Cost:",
										CoffeeOrders.boxSizeCost( medium,
										                          CoffeeOrders.MEDIUM_BOX_PRICE ) );
		displayString += String.format( FORMATSTRING_4, "Small:", small, "Cost:",
										CoffeeOrders.boxSizeCost( small,
										                          CoffeeOrders.SMALL_BOX_PRICE ) );
		displayString += String.format( FORMATSTRING_0 );
		displayString += String.format( FORMATSTRING_0 );
		displayString += String.format( FORMATSTRING_2, "Total Cost:", " ",
										CoffeeOrders.totalPrice( qtyOrdered,
										                         large, medium, small ) );
		displayString += String.format( FORMATSTRING_0 );
		displayString += String.format( FORMATSTRING_1, "Date of Order:",
										currentDateString ); // CoffeeOrders.getDate( 10 ) );
		displayString += String.format( FORMATSTRING_1, "Expected Date of Arrival:",
										arrivalDateString );
        displayString += String.format( FORMATSTRING_0 );

        displayString += String.format( FORMATSTRING_5, "Shipping Address:",
                                        txtStreet.getText().toUpperCase() );
        displayString += String.format( FORMATSTRING_6, " ", txtCity.getText().toUpperCase(),
        								txtState.getText(), txtZipcode.getText().toUpperCase() );

		/*** This code is either display it or print it ***/

		if ( id == 1 )
			txtADisplay.setText( displayString );
		if ( id == 2 )
		   System.out.print( displayString );
	}

	private String futureDate( Date currentDate, int plusDays )
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "MMMMM dd, YYYY" );
		Calendar cal = Calendar.getInstance();
		cal.add( Calendar.DATE, plusDays );
		Date arrivalDate = cal.getTime();

		String arrivalDateString = dateFormat.format( arrivalDate );

		return arrivalDateString;
	}

    private boolean invoiceValidation()
    {
	    /*** Local variables ***/

		String errorMessage = "";
		boolean status = false; //Return variable
		boolean error = false;  //Error checking

		/*** Validates the information before it is displayed ***/

		if ( !CoffeeOrders.validateString( txtName.getText() ) )
		{
			errorMessage += "Blank Name \n";
			setTextField( txtName, false );
			error = true;
		}
		else
		    setTextField( txtName, true );

		if ( !CoffeeOrders.validateString( txtStreet.getText() ) )
		{
			errorMessage += "Blank Street Address \n";
			setTextField( txtStreet, false );
			error = true;
		}
		else
			setTextField( txtStreet, true );

		if ( !CoffeeOrders.validateString( txtCity.getText() ) )
		{
			errorMessage += "Blank City \n";
			setTextField( txtCity, false );
			error = true;
		}
		else
			setTextField( txtCity, true );

		if ( txtState.getText().length() < 2 ||
			 !CoffeeOrders.validateState( txtState.getText().substring( 0, 2 ).toUpperCase() ) )
		{
			errorMessage += "US Only - State Must be Abbr. i.e. WI \n";
			setTextField( txtState, false );
			error = true;
		}
		else
		{										//Capitalizes the first two letters entered
			txtState.setText( txtState.getText().substring( 0, 2 ).toUpperCase() );
			setTextField( txtState, true );
		}
			//Checks the length of the of the text field
		if ( !CoffeeOrders.validateString( txtZipcode.getText() ) )
		{
			errorMessage += "Blank Zipcode \n";
			setTextField( txtZipcode, false );
			error = true;
		}
		else if ( txtZipcode.getText().trim().length() != 5 )
		{
			errorMessage += "Zipcode not 5 digits \n";
			setTextField( txtZipcode, false );
			error = true;
		}
		else
		 {     //Checks to that the input can be parsed
			if ( errorInParse( txtZipcode.getText().trim(), 1 ) ||
			     !CoffeeOrders.validateZipcode( zipCode ))
			{
				errorMessage += "Zipcode Error - US Postal ( 01001-99950) \n";
				setTextField( txtZipcode, false );
				error = true;
			}
			else
				setTextField( txtZipcode, true );
        }
        	//Checks the length of the of the text field
		if ( !CoffeeOrders.validateString( txtQtyOrdered.getText() ) )
		{
			errorMessage += "Blank Quantity \n";
			setTextField( txtQtyOrdered, false );
			error = true;
		}
		else
		{		//Checks to that the input can be parsed
			if ( errorInParse( txtQtyOrdered.getText().trim(), 2 ) ||
				 !CoffeeOrders.validateQuantity( qtyOrdered ) )
			{
				errorMessage += "Quantity Must be in range ( 1-1500 ) \n";
				setTextField( txtQtyOrdered, false );
				error = true;
			}
			else
			{
				setTextField( txtQtyOrdered, true );
			}
		}

		if ( error )
		{								  //Pop up message
			JOptionPane.showMessageDialog( null,"Invalid Information Entered !\n" + errorMessage );
		}
        else
            status = true;

        return status;
 	}

	private boolean errorInParse( String parseString, int id )
	{
		/*** Local variable ***/

		boolean error = false;

		/*** Try/Catch for parsing the input ***/

		try
		{
			if ( id == 1 )
				zipCode = Integer.parseInt( parseString );  //converts an integer to string
			if ( id == 2)
				qtyOrdered = Integer.parseInt( parseString );  //converts an integer to string
		}
		catch ( NumberFormatException exc )
		{
			if ( id == 1 )
			{
				setTextField( txtZipcode, false );
				txtZipcode.requestFocus();
			    txtZipcode.selectAll();
			}
			if ( id == 2)
			{
			    setTextField( txtQtyOrdered, false );
			    txtQtyOrdered.requestFocus();
			    txtQtyOrdered.selectAll();
			}

		    error = true;
   		}

		return error;
	}

	/*** Text field validation colors ***/

	private void setTextField( JTextField errorInField, boolean valid )
	{
		if ( valid )
		{
			errorInField.setBackground( Color.WHITE );
			errorInField.setForeground( Color.BLUE );

			/*** Limits the length of the textfield ***/

			if ( errorInField.getText().length() > MAX_SIZE_STRING )
			    errorInField.setText( errorInField.getText().substring( 0, MAX_SIZE_STRING - 1 ) );
		}
		else
		{
			errorInField.setBackground( Color.RED );
			errorInField.setForeground( Color.WHITE );
			errorInField.setText( errorInField.getText() );
			errorInField.requestFocus();
			errorInField.selectAll();
		}
	}

    /*** Application ***/

    public static void main( String args[] )
    {
		CoffeeOrderGUI test = new CoffeeOrderGUI();

		//test.startCoffeeOrderGUI(); TEST OBJECT
	}
}
