/*************************************************************************
 *
 * File: SumValidation.java
 *
 * Author: Joshua Wiley
 *
 * Description:  Validates rows, columns, and diagonals
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 *************************************************************************/

public class SumValidation
{
	/*** Class Constants ***/

	private static final int rowID = 1;
	private static final int columnID = 2;
	private static final int primaryDiagonalID = 3;
	private static final int secondaryDiagonalID = 4;

	/*** Class Methods ***/

	public static void SumValidation() throws ExceptionHandling
	{
		/*** Local variables ***/

		int rows = 0;
		int columns = 0;
		int sumOfRow = 0;
		int sumOfColumns = 0;
		int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
		int magicNumberSum = ( MagicSquareGUI.MAXIMUM_NUMBER_SQUARE *
							 ( MagicSquareGUI.MAXIMUM_NUMBER_SQUARE + 1 ) / 2 ) /
							   MagicSquareGUI.NUMBER_OF_ROWS;

        /*** Verifies the numbers given add up to a magic square ***/

        while (  rows < MagicSquareGUI.NUMBER_OF_ROWS )
		{
			sumOfRow = 0;
            sumOfColumns = 0;

			while (  columns < MagicSquareGUI.NUMBER_OF_COLUMNS )
		    {
                sumOfColumns += MagicSquareGUI.magicSquare[rows][columns].getInt();
                sumOfRow += MagicSquareGUI.magicSquare[columns][rows].getInt();
                columns++;
            }

			sumOfPrimaryDiagonal += MagicSquareGUI.magicSquare[rows][rows].getInt();
			sumOfSecondaryDiagonal +=
				MagicSquareGUI.magicSquare[rows][MagicSquareGUI.NUMBER_OF_ROWS - rows - 1].getInt();

			if ( sumOfRow != magicNumberSum )
			{
				highlightIncorrectCells( rowID, rows );
				MagicSquareGUI.txtADisplay.setText(
			  		"\n  SORRY YOU DID NOT ENTER A MAGIC SQUARE. \n  PLEASE TRY AGAIN. " );
				throw new ExceptionHandling( "Sum of Row is Not a Magic Square!" );
			}
			else if ( sumOfColumns != magicNumberSum )
			{
				highlightIncorrectCells( columnID, rows );
				MagicSquareGUI.txtADisplay.setText(
			   		"\n  SORRY YOU DID NOT ENTER A MAGIC SQUARE. \n  PLEASE TRY AGAIN. " );
				throw new ExceptionHandling( "Sum of Column is Not a Magic Square!" );
			}
			else
			{
				columns = 0;
				rows++;
			}
       }
       if ( sumOfPrimaryDiagonal != magicNumberSum )
       {
		   highlightIncorrectCells( primaryDiagonalID, 0 );
		   MagicSquareGUI.txtADisplay.setText(
			   "\n  SORRY YOU DID NOT ENTER A MAGIC SQUARE. \n   PLEASE TRY AGAIN.  " );
		   throw new ExceptionHandling( "Primary Diagonal Not a Magic Square!" );
	   }
       else if ( sumOfSecondaryDiagonal != magicNumberSum )
       {
		   highlightIncorrectCells( secondaryDiagonalID, 0 );
		   MagicSquareGUI.txtADisplay.setText(
			   "\n  SORRY YOU DID NOT ENTER A MAGIC SQUARE. \n   PLEASE TRY AGAIN.  " );
		   throw new ExceptionHandling( "Secondary Diagonal Not a Magic Square!" );
	   }
   }

   private static void highlightIncorrectCells( int id, int rows )
   {
	   for ( int i = 0; i < MagicSquareGUI.NUMBER_OF_COLUMNS; i++ )
	   {
		   if ( id == rowID )
		   {				//Row doesn't add up.
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[i][rows], false );
		   }
		   else if ( id == columnID )
		   {			   //Column doesn't add up
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[rows][i], false );
		   }
		   else if ( id == primaryDiagonalID )
		   {				//Primary diagonal doesn't add up.
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[i][i], false );
		   }
		   else if ( id == secondaryDiagonalID )
		   {				//Secondary diagonal doesn't add up
			   ErrorHighlighting.setTextField(
				   MagicSquareGUI.magicSquare[i][MagicSquareGUI.NUMBER_OF_COLUMNS - ( i + 1) ],
			       false );
		   }
	   }
   }
}