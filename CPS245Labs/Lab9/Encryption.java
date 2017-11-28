/*************************************************************************
*
*  File: Encryption.java
*
*  Author: Joshua Wiley
*
*  Description: Performs an encryption and decryption algorithm
*
*  Date: 4-6-15
*
*  Comments: had fun learning to wrap letters and numbers /sarcasm
*
*************************************************************************/

public class Encryption
{
	/*** Class Constants ***/

    public final static int   SHIFT         = 0;
	public final static char  NEW_CHARACTER = 'a';

	/*** Class Variables ***/

    private int  shift        = SHIFT;
	private char newCharacter = NEW_CHARACTER;

	/*** Constructors ***/

    public Encryption()
    {
		this.shift        = SHIFT;
        this.newCharacter = NEW_CHARACTER;
    }

    public Encryption( char newCharacter )
    {
		this.shift = SHIFT;
        this.setCharacter( newCharacter );
    }

    public Encryption( int shift, char newCharacter )
    {
		this.setShift( shift );
        this.setCharacter( newCharacter );
    }

	/*** Getters ***/

    public int getShift()
    {
        return this.shift;
    }

    public char getCharacter()
    {
         return this.newCharacter;
    }

    /*** Setters ***/

    public void setShift( int newShift )
    {
       if ( validateShift( newShift ) )
           this.shift = newShift;
    }

    public void setCharacter( char newCharacter )
    {
        if ( validateCharacter( newCharacter ) )
            this.newCharacter = newCharacter;
    }

	/*** Encryption Algorithm ***/

	public char encrypt( char cryptCharacter, int shift )
	{
		char returnChar = cryptCharacter;

		if ( upperCase( cryptCharacter ) && validateShift( shift ) )
	    {
			if ( shift < 0 )
		    	shift = 26 + shift;

			returnChar = ( char )( 'A' + ( returnChar -'A'+ shift ) % 26 );
	    }

		else if ( ( lowerCase( cryptCharacter ) && validateShift( shift ) ) )
		{
			if ( shift < 0 )
			    shift = 26 + shift;

			returnChar = ( char )( 'a' + ( returnChar -'a'+ shift ) % 26 );
	    }
		else if ( number( cryptCharacter ) && validateShift( shift ) )
		{
			if ( shift < 0 )
			    shift = 10 + shift;

			returnChar = ( char )( '0' + ( returnChar -'0'+ shift ) % 10 );
	    }
		return returnChar;
	}

	/*** Decryption Algorithm ***/

	public char decrypt( char decryptCharacter, int shift )
	{
		char returnChar = decryptCharacter;

		if ( upperCase( decryptCharacter ) && validateShift( shift ) )
	    {
			returnChar = ( char )( 'A' + ( returnChar - 'A' + ( 26 - ( shift % 26 ) ) ) % 26 );
	    }

		else if (( lowerCase( decryptCharacter ) && validateShift( shift ) ))
		{
			returnChar = ( char )( 'a' + ( returnChar - 'a' + ( 26 - ( shift % 26 ) ) ) % 26 );
	    }
		else if ( number( decryptCharacter ) && validateShift( shift ) )
		{
			returnChar = ( char )( '0' + ( returnChar - '0' + ( 10 - ( shift % 10 ) ) ) % 10 );
	    }
		return returnChar;
	}

    /*** Helper Methods ***/

    public boolean validateCharacter( char newCharacter )
    {
        boolean status = false;

        if ( ( upperCase( newCharacter ) )|| ( lowerCase( newCharacter ) ) || ( number( newCharacter ) ) )
            status = true;

        return status;
    }

    public boolean validateShift( int shift )
    {
        boolean status = false;

        if ( ( shift >= -26 )  && ( shift <= 26 ) )
            status = true;

        return status;
    }
    private boolean upperCase( char newCharacter )
    {
		boolean status = false;

        if ( ( newCharacter >= 'A' ) && ( newCharacter <= 'Z' ) )
			status = true;

		return status;
    }

    private boolean lowerCase( char newCharacter )
    {
		boolean status = false;

        if ( ( newCharacter >= 'a' ) && ( newCharacter <= 'z' ) )
			status = true;

		return status;
    }

    private boolean number( char newCharacter )
    {
		boolean status = false;

        if ( ( newCharacter >= '0' ) && ( newCharacter <= '9' ) )
            status = true;

        return status;
    }
}