/*************************************************************************
 *
 * File: ExceptionHandling.java
 *
 * Author: Joshua Wiley
 *
 * Description:  Custom exception handling
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 *************************************************************************/

class ExceptionHandling extends Exception
{
	public ExceptionHandling()
	{
		super( "ERROR IN FIELD" );
	}
	public ExceptionHandling( int min, int max )
	{
        super( "Out of Range ( " + min + ", " + max + " )" );
	}

	public ExceptionHandling( String message )
	{
		super( message );
	}
}