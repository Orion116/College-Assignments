/*********************************************************************
 * 
 * File: CyberPet.java
 *
 * Author: Joshua Wiley
 *
 * Description: This class represents a CyberPet that can
 *              eat and sleep on command. This version incorporates
 *              a public getState() method to report the pet's state.
 *
 * Date: 4-9-15
 *
 * Comment: I assumed no user input was required as none was in specifications.
 *
 ********************************************************************/

public class CyberPet
{
    /*** Class Constants ***/
	
    public static String PET_NAME = "Spot";
	public static String PET_SIZE_SMALL = "small";
	public static String PET_SIZE_BIG = "big";
	public static String PET_SIZE = PET_SIZE_SMALL;
    public static boolean IS_EATING   = true;         
    public static boolean IS_SLEEPING = false;
	public static boolean IS_THINKING = false;
	
	/*** Class Variables ***/
	
	private String  petsName = PET_NAME;   
	private String  petSize = PET_SIZE;   
    private boolean isEating = IS_EATING;         
    private boolean isSleeping = IS_SLEEPING;
	private boolean isThinking = IS_THINKING;

    /*** Constructor Methods ***/

    public CyberPet( )
    {
	    this.petsName = PET_NAME;
		this.petSize = PET_SIZE; 
	    this.isEating = IS_EATING;
		this.isSleeping = IS_SLEEPING;
		this.isThinking = IS_THINKING;
    }

    public CyberPet( String petsName )
    {
	    this.petsName = petsName;
		this.petSize = PET_SIZE; 
	    this.isEating = IS_EATING;
		this.isSleeping = IS_SLEEPING;
		this.isThinking = IS_THINKING;
    }

    public CyberPet( String petsName, String petSize, boolean isEating, boolean isSleeping, boolean isThinking )
    {
	    this.petsName = petsName;
		this.petSize = petSize; 
	    this.isEating = isEating;
		this.isSleeping = isSleeping;
		this.isThinking = isThinking;
    }
	
    /*** Observor or Accessor Methods ***/

    public String getPetName( )
	{
		return this.petsName;
	}
	
    public String getPetSize( )
	{
		return this.petSize;
	}
	
    public String getPetState( )
    {
	    /*** Local Variable ***/
		 
	    String returnPetState = "Error in State";
		
        if( isEating )
		{
			returnPetState = "Eating"; 
		}
               
        else if( isSleeping )
		{
            returnPetState = "Sleeping";
		}	
		
		else
		{
            returnPetState = "Thinking";
        }
		
		return returnPetState;
    }
    
	/*** Setters ***/
	
	public void setPetName( String petsName)
	{		
	     this.petsName = petsName;
	}
	
	@Override 
	
	public String toString()
	{
	    /*** Local Constants ***/
	    final String FORMAT_STRING  = "%20s %-6s"; 
		final String FORMAT_STRING1 = "%10s %-6s";
		
		/*** Local Variables ***/
	    String returnString = "";
		
		returnString += String.format( FORMAT_STRING, "Cyber Pet Name:", this.getPetName() ); 
		returnString += String.format( FORMAT_STRING1, "Size:", this.getPetSize() );
		returnString += String.format( FORMAT_STRING1, "State:", this.getPetState() );
		
		return returnString;
	} 
	
    /*** Transformer or Mutator Methods ***/
    
	public void sizing( String Size )
	{
	  
        if( Size == PET_SIZE_SMALL )
		{
			this.petSize = PET_SIZE_SMALL;
		}
               
        if( Size == PET_SIZE_BIG )
		{
            this.petSize = PET_SIZE_BIG;
		}	
	}
	
    public void eating( )          
    {
        isEating   = true;      
        isSleeping = false;
		isThinking = false;
        return;
    }

    public void sleeping( )      
    {           
        isEating   = false;
	    isSleeping = true; 
		isThinking = false;
        return;
    }
	
	public void thinking( )      
    {           
        isEating   = false;
	    isSleeping = false; 
		isThinking = true;
        return;
    }
	
	/*** Public Helper Method ***/
	
	public String encounter( CyberPet pet2 )
	{
	    /*** Local Variables ***/
		String size1;
		String size2;
		String returnString = "";
		
		size1 = this.getPetSize();
		size2 = pet2.getPetSize();
		
		/*** Decision if-else statements ***/
		
		if( size1 == PET_SIZE_SMALL && size2 == PET_SIZE_BIG )
		{
		    returnString = "See yah!";
		}	
		else if( size1 == PET_SIZE_BIG && size2 == PET_SIZE_SMALL )	
		{
		    returnString = "I'm going to eat you!";
		}	
		else if( size1 == size2 )
		{
		    returnString = "Let's go to McDonalds!";
		}
		else
		{
		    returnString = "Error";
		}
			
	    return returnString;
	}
}
