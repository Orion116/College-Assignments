/*************************************************************************
 * 
 * File: CyberPetApplet.java
 *
 * Author: Joshua Wiley
 *
 * Description: Creates a graphical user interface (GUI) applet
 *              for the CyberPet class.
 *
 *  Date: 3-29-15
 *
 * Comments: Enjoy testing
 *
 *************************************************************************/

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CyberPetApplet extends Applet
                            implements ActionListener
{
   /*** Constants ***/

   private static final int MAX_SIZE_NAME = 15;

   /*** ***/
   
   private JTextField nameInput;
   private JTextField sizeInput;
   private JTextField activityInput;
   private JTextField foodInput;
   
   private JButton    btnName;
   private JButton    btnSize;
   private JButton    btnActivity;
   private JButton    btnFoodType; 
   private JButton    btnEncounter; 
   private JButton    btnPetChange;
    
   private CyberPet pet1 = null;
   private CyberPet pet2 = null;
   private JLabel lblDisplay = null;
   
   /*** ***/
    
	private void buildGUI()
	{
        /*** ***/
			
        final int WIDTH = 445;
		final int HEIGHT = 35;
	    
		/*** ***/
		
		JPanel pnlTitle     = null;
		JPanel pnlName      = null;
		JPanel pnlSize      = null;
	    JPanel pnlActivity  = null;
		JPanel pnlFood      = null;
		JPanel pnlOutput    = null;
		JPanel pnlEncounter = null;
		
		setLayout( null ); //
		
		/*** ***/
		
		pnlTitle     = titlePanel();
		pnlName      = namePanel();
		pnlSize      = sizePanel();
		pnlActivity  = activityPanel();
		pnlFood      = foodPanel();
		pnlOutput    = outputPanel();
		pnlEncounter = encounterPanel();
		
		/*** ***/
		
		add( pnlTitle );
		add( pnlName );
		add( pnlSize );
		add( pnlActivity );
		add( pnlFood );
		add( pnlOutput );
		add( pnlEncounter );
		
		/*** ***/
		
		pnlTitle.setBounds(     30, 5,  WIDTH, HEIGHT );
		pnlName.setBounds(      30, 35,  WIDTH, HEIGHT );
		pnlSize.setBounds(      30, 70,  WIDTH, HEIGHT );
		pnlActivity.setBounds(  30, 105,  WIDTH, HEIGHT );
		pnlFood.setBounds(      30, 140, WIDTH, HEIGHT );
		pnlOutput.setBounds(    30, 175, WIDTH, HEIGHT );
		pnlEncounter.setBounds( 30, 215, WIDTH, HEIGHT );
	}
	
	private JPanel titlePanel()
	{
	    /*** ***/
		
		JPanel pnlTitle = null;
		JLabel lblTitle = null;
		JLabel lblBlankSpace = null;
		
		pnlTitle = new JPanel(); //
		
		/*** ***/
		
		lblTitle = new JLabel( "CyberPet Applet" );
		lblBlankSpace = new JLabel( "" );
		
		/*** ***/
		
		pnlTitle.add( lblTitle );
		pnlTitle.add( lblBlankSpace );
		
		return pnlTitle;
	}
	
	private JPanel namePanel()
	{
	    /*** ***/
		
		JPanel pnlName = null;
		JLabel lblName = null;
		
		/*** ***/
		
		pnlName = new JPanel();
		
		/*** ***/
		
		lblName = new JLabel( "Name:" );
		nameInput = new JTextField( MAX_SIZE_NAME );
        nameInput.setText( pet1.getPetName() );
		
		/*** ***/
		
	    btnName  = new JButton( "Name" );
	    btnName.addActionListener( this );
		
		/*** ***/
		
		pnlName.add( lblName );
		pnlName.add( nameInput );
		pnlName.add( btnName );
		
		return pnlName;
	}

	private JPanel sizePanel()
	{
        /*** ***/
		
		JPanel pnlSize  = null;
		JLabel lblSize = null;
		
		/*** ***/
		
		pnlSize = new JPanel();
		
		/*** ***/
		
		lblSize = new JLabel( "Size:" );
		
		/*** ***/
		
		sizeInput = new JTextField( MAX_SIZE_NAME );
        sizeInput.setText( pet1.getPetSize() );
		sizeInput.setToolTipText( "big / small" );
		
		/*** ***/
		
	    btnSize  = new JButton( "Size" );
	    btnSize.addActionListener( this );
		btnSize.setToolTipText( "big / small" );
		
		/*** ***/
		
		pnlSize.add( lblSize );
		pnlSize.add( sizeInput );
		pnlSize.add( btnSize );
		
		return pnlSize;
	}	

	private JPanel activityPanel()
	{
	    /*** ***/
		
		JPanel pnlActivity  = null;
		JLabel lblActivity = null;
		
		/*** ***/
		
		pnlActivity = new JPanel();
		
		/*** ***/
		
		lblActivity = new JLabel( "Activity:" );
		
		/*** ***/
		
		activityInput = new JTextField( MAX_SIZE_NAME );
        activityInput.setText( pet1.getActivity() );
		activityInput.setToolTipText( "eating / sleeping / thinking" );
		
	    btnActivity  = new JButton( "Activity" );
	    btnActivity.addActionListener( this );
		btnActivity.setToolTipText( "eating / sleeping / thinking" );
		
		/*** ***/
		
		pnlActivity.add( lblActivity );
		pnlActivity.add( activityInput );
		pnlActivity.add( btnActivity );
		
		return pnlActivity;
	}	

	private JPanel foodPanel()
	{
	    /*** ***/
		
		JPanel pnlFood  = null;
		JLabel lblFoodType = null;
		
		/*** ***/
		
		pnlFood = new JPanel();
		
		/*** ***/
		
		lblFoodType = new JLabel( "Food Type:" );
		foodInput = new JTextField( MAX_SIZE_NAME );
        foodInput.setText( pet1.getFoodType() );
		foodInput.setToolTipText( "fly / beetle / hot dog" );
		
	    btnFoodType  = new JButton( "Food Type" );
	    btnFoodType.addActionListener( this );
		btnFoodType.setToolTipText( "fly / beetle / hot dog" );
		
		pnlFood.add( lblFoodType );
		pnlFood.add( foodInput );
		pnlFood.add( btnFoodType );
		
		return pnlFood;
	}	
	
	private JPanel outputPanel()
	{
	    /*** ***/
		
	    JPanel pnlOutput = null;
		
		/*** ***/
		
		pnlOutput = new JPanel();
		lblDisplay = new JLabel( reportStatus( pet1 ) ); 
		
	    pnlOutput.add( lblDisplay );
		
		return pnlOutput;
	}
	
	private JPanel encounterPanel()
	{
	    /*** ***/
		
		JPanel pnlEncounter  = null;
		
		/*** ***/
		
		pnlEncounter = new JPanel();
		
		/*** ***/
		
	    btnEncounter  = new JButton( "Encounter" );
	    btnEncounter.addActionListener( this );
		btnEncounter.setToolTipText( "Encounter another CyberPet" );
		
		btnPetChange  = new JButton( "Change Pet" );
	    btnPetChange.addActionListener( this );
		btnPetChange.setToolTipText( "Switches between CyberPets" );
		
		pnlEncounter.add( btnEncounter );
		pnlEncounter.add( btnPetChange );
		
		return pnlEncounter;
	}	
	
	/*-------------------------------------------------------------------
    * The init() method gets called automatically whenever a browser
    * displays an applet.  Method instantiates the instance variables,
    * including the CyberPet and GUI components that will be displayed
    * on the applet
    *-------------------------------------------------------------------*/
	
    public void init()
    { 
	    /*** Create the CyberPets ***/
	   
        pet1 = new CyberPet( "Socrates" );
		pet2 = new CyberPet( "Fred", "big", "nothing", false, false, true );
       	   	   
        /*** Create the GUI components ***/
       	 
		buildGUI();

        /*** sets size and location of applet ****/
		
		setSize( 500, 300 );
		setLocation( 0, 15 );
    }

    /*-------------------------------------------------------------------
     * Handle button events -- i.e. user clicks button
     *-------------------------------------------------------------------*/

    public void actionPerformed( ActionEvent e)
    {
	   	/*** ***/	
	     if ( e.getSource() == btnName)
		 {
		     nameHandle();
         }
		 
		 else if (e.getSource() == btnSize )
		 {
             sizeHandle();
		 }
		 
		 else if (e.getSource() == btnActivity )
		 {
             activityHandle();
		 }
		 
		 else if (e.getSource() == btnFoodType )
		 {
		     foodTypeHandle(); 
		 }
		 
		 else if (e.getSource() == btnEncounter )
		 {
		     encounterHandle();
		 }
		 
		 else if (e.getSource() == btnPetChange )
		 {
             changePetHandle();
		 }
    }
	
	private void nameHandle()
	{
		 if ( pet1.validateName( nameInput.getText() ) ) 
	     {
		        pet1.setPetName( nameInput.getText() );
			    lblDisplay.setText( reportStatus( pet1 ) );
		 }
		 else 
		     lblDisplay.setText( "Invalid Name: " + reportStatus(pet1) );
	}

	private void sizeHandle()
	{
		 if ( pet1.validateSize( sizeInput.getText() ) )
		 {
			 pet1.sizing( sizeInput.getText() );
			 lblDisplay.setText( reportStatus( pet1 ) );
		 }
		 else
			 lblDisplay.setText( "Invalid Size: " + reportStatus(pet1) );
	}
	
	private void activityHandle()
	{
		if ( pet1.validateActivity( activityInput.getText() ) )
		{
		    pet1.setActivity( activityInput.getText() );
		    lblDisplay.setText( reportStatus( pet1 ) );
		}
		else
		    lblDisplay.setText( "Invalid Activity: " + reportStatus(pet1) );
	}
		
	private void foodTypeHandle()
	{
         if ( pet1.validateFoodType( foodInput.getText() ) )
		 {
		     pet1.setFoodType( foodInput.getText() );
		     lblDisplay.setText( reportStatus( pet1 ) );
		 }
		 else
			 lblDisplay.setText( "Invalid Food Type: " + reportStatus(pet1));
	}	
		
	private void encounterHandle()
	{
         lblDisplay.setText( "A " + pet1.getPetSize() + " " + pet1.getPetName() + " encounters "
			                  + pet2.getPetSize() + " " + pet2.getPetName() + ". " 
							  + pet1.getPetName() +" says"+ pet1.encounter( pet2 )  );
	}
		
	private void changePetHandle()
	{    
	     /*** Local variable ***/
		 
	     CyberPet tempPet = null;
		 
		 tempPet = pet1;
		 pet1 = pet2;
		 pet2 = tempPet;
		 lblDisplay.setText( reportStatus( pet1 ) );
	}	
		
    private String reportStatus( CyberPet pet1 )
    {	
		/*** Local Variables ***/
		
	    String returnString = "";
		
		returnString +=  " " + pet1.getPetName(); 
		returnString +=  " is " + pet1.getPetSize();
		returnString +=  " and is " + pet1.getActivity();
		
		if ( pet1.getActivity().equals( "eating" ) && !( pet1.getFoodType().equals( pet1.FOOD_NOTHING ) ) )
		    returnString += " a " + pet1.getFoodType();
		
		returnString += ".";
		
		return returnString;
    }
}