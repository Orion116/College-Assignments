/*****************************************************************
 *
 * File: TestCyberPet.java
 *
 * Author: Joshua Wiley
 *
 * Date: 4-9-15 
 *
 * Description: This application program tests the CyberPet object.
 *
 * Comment: I assumed no user input was required as none was in specifications.
 *
 *****************************************************************/

public class TestCyberPet
{
    public void startTestCyberPet()
	 {
	 	 /*** Class Variables ***/
		 
        CyberPet pet1 = new CyberPet( );
        CyberPet pet2 = new CyberPet( "Scout", "big", false, false, true );
		String FormatString1 = "%n %64s %n%n";
		
		/*** Display test default ***/
		System.out.printf( FormatString1, "************************* Test Default ***********************" );
        displayCyberPet( pet1 );
		
		/*** Display test Initialized ***/
		System.out.printf( FormatString1, "******************* Test Initialized " + pet2.getPetName() + " *******************" );
        displayCyberPet( pet2 );
		
		/*** Display changes name ***/
		System.out.printf( FormatString1,"*********** Changed Initialized Name " + pet2.getPetName() + " to Jeff ***********" );
		pet2.setPetName( "Jeff" );
		displayCyberPet( pet2 );
		
		/*** Display state ***/
		System.out.printf( FormatString1, "******** Changed Initialized State " + pet2.getPetState() + " to Eating ********" );
		pet2.eating( );
		displayCyberPet( pet2 );
		
		/*** Display state ***/
		System.out.printf( FormatString1, "******** Changed Initialized State " + pet2.getPetState() + " to Sleeping ********" );
		pet2.sleeping( );
		displayCyberPet( pet2 );
		
		/*** Display state ***/
		System.out.printf( FormatString1, "******* Changed Initialized State " + pet2.getPetState() + " to Thinking *******" );
		pet2.thinking( );
		displayCyberPet( pet2 );
	
	    /*** Display change size ***/
		System.out.printf( FormatString1, "************** Set Initialized Size " + pet2.getPetSize() + " to small *************" );
		pet2.sizing( pet2.PET_SIZE_SMALL );
		displayCyberPet( pet2 );
		
		/*** Display change size ***/
		System.out.printf( FormatString1, "************* Set Initialized Size " + pet2.getPetSize() + " to big **************" );
		pet2.sizing( pet2.PET_SIZE_BIG );
		displayCyberPet( pet2 );
		
		/*** Display encounter ***/
		System.out.printf( FormatString1, "***** Default pet small encountering Initialized pet big *****" );
		cyberPetEncounter( pet1, pet2 );
		
		System.out.printf( FormatString1, "***** Initialized pet big encountering Default pet small *****" );
		cyberPetEncounter( pet2, pet1 );
		
		System.out.println( "\n   ***** Initialized pet equal encountering Default pet size changed to big *****\n" );
		pet1.sizing( pet1.PET_SIZE_BIG );
		cyberPetEncounter( pet2, pet1 );
	 }
	 
	 private void cyberPetEncounter( CyberPet pet1, CyberPet pet2 )
	 { 
	    /*** Formats output --- Local Variables ***/

        String FormatString = "%24s %-6s";
        String FormatString1 = "%n%n %34s %n%n";
		String FormatString2 = "%n %35s %-6s %n";
		
        /*** Prints stats for encounters ***/
		
        System.out.printf( FormatString, "Cyber Pet1 Name:", pet1.getPetName( ) );
        System.out.printf( FormatString, "Cyber Pet1 Size:", pet1.getPetSize() );
		System.out.printf(FormatString1, "Vs." );  
		System.out.printf( FormatString, "Cyber Pet2 Name:", pet2.getPetName( ) );
        System.out.printf( FormatString, "Cyber Pet2 Size:", pet2.getPetSize() );  
		System.out.println();  
		 
		System.out.printf( FormatString2, "Encounter Results:", pet1.encounter( pet2 ) );
	 }
	  
     private void displayCyberPet( CyberPet testPet )
     {
        /*** Formats output --- Local Variables ***/

        String FormatToString = "%n %45s %n%n";
        String FormatString1 = "%20s %-6s";
		String FormatString2 = "%10s %-6s";
       
        /*** Prints name, size, and state ***/
		
        System.out.printf( FormatString1, "Cyber Pet Name:", testPet.getPetName( ));
        System.out.printf( FormatString2, "Size:", testPet.getPetSize() );   
        System.out.printf( FormatString2, "State:", testPet.getPetState() );
		System.out.println();
		
		System.out.printf( FormatToString, "******* toString() ********" );
	    System.out.println(testPet.toString() );
        System.out.println();
    }
	
	/*** Application ***/
    public static void main( String argv[] )
    {
	    TestCyberPet test = new TestCyberPet();
		
		test.startTestCyberPet();
    }
}
