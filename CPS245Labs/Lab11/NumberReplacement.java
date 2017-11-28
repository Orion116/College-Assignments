/******************************************************************************
*
*  File: NumberReplacement.java
*
*  Author: Joshua Wiley
*
*  Description: Searches and replaces number digits with their alphabetical name
*
*  Date: 4-18-15
*
*  Comments:
*
*******************************************************************************/

public class NumberReplacement
{

	public static String replaceWithString( String originalString,
	                                        String searchString,
	                                        String replaceString )
	{
    	/*** Local Variables ***/

		String returnString = originalString;

    	/*** Search and Replace code ***/

		if ( validateString( originalString ) )
	    {
			returnString = originalString.replaceAll( searchString, replaceString );
	    }

		return returnString;
	}

    /*** Helper Methods ***/

    public static boolean validateString( String newString )
    {
    	/*** Local Variables ***/

        boolean status = false;

        if ( newString.trim().length() > 0 )
            status = true;

        return status;
    }
}