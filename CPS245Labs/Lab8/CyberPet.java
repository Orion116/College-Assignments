/*********************************************************************
 * 
 * File: CyberPet.java
 *
 * Author: Joshua Wiley
 *
 * Description: This class represents a CyberPet that can
 *              perform different activities on command.  Validates
 *              input and encounters other pets. 
 *
 * Date: 3-29-15
 *
 * Comment: 
 *
 ********************************************************************/

public class CyberPet
{
    /*** Class Constants ***/
	
    public static String PET_NAME       = "Spot";
	public static String PET_SIZE_SMALL = "small";
	public static String PET_SIZE_BIG   = "big";
	public static String PET_SIZE       = PET_SIZE_SMALL;
	public static String FOOD_FLY       = "fly";
	public static String FOOD_BEETLE    = "beetle";
	public static String FOOD_HOT_DOG   = "hot dog";
	public static String FOOD_NOTHING   = "nothing";
	public static String PET_FOOD       = FOOD_NOTHING;
    public static boolean IS_EATING     = true;         
    public static boolean IS_SLEEPING   = false;
	public static boolean IS_THINKING   = false;
	
	/*** Class Variables ***/
	
	private String  petsName   = PET_NAME;   
	private String  petSize    = PET_SIZE;
	private String  petFood    = PET_FOOD; 
    private boolean isEating   = IS_EATING;         
    private boolean isSleeping = IS_SLEEPING;
	private boolean isThinking = IS_THINKING;

    /*** Constructor Methods ***/

    public CyberPet( )
    {
	    this.petsName   = PET_NAME;
		this.petSize    = PET_SIZE;
		this.petFood    = PET_FOOD; 
	    this.isEating   = IS_EATING;
		this.isSleeping = IS_SLEEPING;
		this.isThinking = IS_THINKING;
    }

    public CyberPet( String petsName )
    {
	    this.setPetName( petsName );
		this.petSize    = PET_SIZE; 
		this.petFood    = PET_FOOD;
	    this.isEating   = IS_EATING;
		this.isSleeping = IS_SLEEPING;
		this.isThinking = IS_THINKING;
    }

    public CyberPet( String petsName, String petSize, String petFood, boolean isEating, boolean isSleeping, boolean isThinking )
    {
	    this.setPetName(  petsName );
		this.sizing(      petSize  ); 
		this.setFoodType( petFood );
	    this.isEating   = isEating;
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
	
	public String getFoodType( )
	{
		return this.petFood;
	}
	
    public String getActivity( )
    {
	    /*** Local Variable ***/
		 
	    String returnPetState = "Error in State";
		
        if( isEating )
		{
			returnPetState = "eating"; 
		}
               
        else if( isSleeping )
		{
            returnPetState = "sleeping";
		}	
		
		else
		{
            returnPetState = "thinking";
        }
		
		return returnPetState;
    }
    
	/*** Setters ***/
	
	public void setPetName( String petsName )
	{	
		if ( validateName( petsName ) )	
		{
		    this.petsName = petsName.trim();
	    }
	}
	
	public void setActivity( String activity )
	{
	    if ( validateActivity( activity ) )
		{
		    activity = activity.trim();
			
			if ( activity.toLowerCase().equals( "eating" ) )
			{
				this.eating(); 
			}
               
        	else if ( activity.toLowerCase().equals( "sleeping" ) )
			{
        	    this.sleeping();
				this.setFoodType( FOOD_NOTHING );
			}	
			else if ( activity.toLowerCase().equals( "thinking" ) )
			{
            	this.thinking();
				this.setFoodType( FOOD_NOTHING );
        	}
		}
	}	
	
	public void setFoodType( String foodType )
	{ 
	    foodType = foodType.toLowerCase().trim();
		if ( getActivity().equals( "eating" ) && validateFoodType( foodType ) )
		{ 
				
        	if ( foodType.equals( FOOD_FLY ) )
			{
			     this.petFood = foodType.trim(); 
			}
               
        	else if ( foodType.equals( FOOD_BEETLE ) )
			{
            	 this.petFood = foodType.trim();
			}	
		
			else if ( foodType.equals( FOOD_HOT_DOG ) )
			{
            	this.petFood = foodType.trim();
        	}
		
			else 
			{
				this.petFood = FOOD_NOTHING;
			}				
		} 
			
		else
		{
			this.petFood = FOOD_NOTHING;
		}
			
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
		returnString += String.format( FORMAT_STRING1, "State:", this.getActivity() );
		
		return returnString;
	} 
	
    /*** Transformer or Mutator Methods ***/
    
	public void sizing( String Size )
	{
	    Size = Size.trim();
		
        if( Size.toLowerCase().equals( PET_SIZE_SMALL ) )
		{
			this.petSize = PET_SIZE_SMALL;
		}
               
        if( Size.toLowerCase().equals( PET_SIZE_BIG) )
		{
            this.petSize = PET_SIZE_BIG;
		}	
	}
	
    public void eating( )          
    {
        isEating   = true;      
        isSleeping = false;
		isThinking = false;
    }

    public void sleeping( )      
    {           
        isEating   = false;
	    isSleeping = true; 
		isThinking = false;
    }
	
	public void thinking( )      
    {           
        isEating   = false;
	    isSleeping = false; 
		isThinking = true;
    }
	
	/*** Validation Helper methods ***/
	 
	public boolean validateName( String petsName )
	{
	    /*** Local Variable ***/
		 
		boolean status = false;
		
		petsName = petsName.trim();
		
		if ( petsName.length() > 0 && petsName.length() <= 15 )
		    status = true;
		 	
	    return status; 
	}
	
	public boolean validateSize( String size )
	{
	    /*** Local Variable ***/
		 
		boolean status = false;
		
		size = size.trim();
		
		if( size.toLowerCase().equals( PET_SIZE_SMALL ) || size.toLowerCase().equals( PET_SIZE_BIG) )
		{
			 status = true;
		}
       
	    return status; 
	}
	
	public boolean validateActivity( String activity )
	{
	    /*** Local Variable ***/
		 
		boolean status = false;
		
		activity = activity.trim();
		
        if ( activity.toLowerCase().equals( "eating" ) )
		{
			status = true; 
		}
               
        else if ( activity.toLowerCase().equals( "sleeping" ) )
		{
            status = true;
		}	
		
		else if ( activity.toLowerCase().equals( "thinking" ) )
		{
            status = true;
        }
		
	    return status; 
	} 	

	public boolean validateFoodType( String foodType )
	{
	    /*** Local Variable ***/
		 
		boolean status = false;
		
		foodType = foodType.trim();
		
        if ( foodType.equals( FOOD_FLY ) )
		{
			status = true; 
		}
               
        else if ( foodType.equals( FOOD_BEETLE ) )
		{
            status = true;
		}	
		
		else if ( foodType.equals( FOOD_HOT_DOG ) )
		{
            status = true;
        }
		
		else if ( foodType.equals( FOOD_NOTHING ) )
		{
			status = true;
		}
		
	    return status; 
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
		    returnString = ", \"See yah!\"";
		}	
		else if( size1 == PET_SIZE_BIG && size2 == PET_SIZE_SMALL )	
		{
		    returnString = ", \"I'm going to eat you!\"";
		}	
		else if( size1 == size2 )
		{
		    returnString = ", \"Let's go to McDonalds!\"";
		}
		else
		{
		    returnString = ", \"Error\"";
		}
			
	    return returnString;
	}
}