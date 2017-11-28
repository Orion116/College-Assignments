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

public class SumValidation
{
	public static boolean SumValidation( int[][] sumValues )
	{
		int magicNumberSum = ( MagicSquareGUI.MAXIMUM_NUMBER_SQUARE *
							 ( MagicSquareGUI.MAXIMUM_NUMBER_SQUARE + 1 ) / 2 ) /
							  MagicSquareGUI.NUMBER_OF_ROWS;
		int rows = 0;
		int columns = 0;
		int sumOfRow = 0;
		int sumOfColumns = 0;
		int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
        boolean error = false;

        JOptionPaneErrorPopUp errorPopUp = null;

        while (  rows < MagicSquareGUI.NUMBER_OF_ROWS && !error )
		{
			sumOfRow=0;
            sumOfColumns=0;

			while (  columns < MagicSquareGUI.NUMBER_OF_COLUMNS && !error )
		    {
                sumOfRow += sumValues[rows][columns];
                sumOfColumns += sumValues[columns][rows];
                columns++;
            }
              	//COMMENT GOES HERE
			sumOfPrimaryDiagonal += sumValues[rows][rows];
			sumOfSecondaryDiagonal += sumValues[rows][MagicSquareGUI.NUMBER_OF_ROWS - rows - 1];

			if ( sumOfRow != magicNumberSum )
			{
				errorPopUp = new JOptionPaneErrorPopUp( "Sum of Row is Not a Magic Square!" );
			    error = true;
			    highlightIncorrectCells( 1, rows );
			}
			else if ( sumOfColumns != magicNumberSum )
			{
				errorPopUp = new JOptionPaneErrorPopUp( "Sum of Column is Not a Magic Square!" );
				error = true;
				highlightIncorrectCells( 2, rows );
			}
			else
			{
				columns = 0;
				rows++;
			}
       }
       if ( !error && sumOfPrimaryDiagonal != magicNumberSum )
       {
		   errorPopUp = new JOptionPaneErrorPopUp( "Primary Diagonal Not a Magic Square!" );
           error = true;
           highlightIncorrectCells( 3, 0 );
	   }
       else if ( !error && sumOfSecondaryDiagonal != magicNumberSum )
       {
		   errorPopUp = new JOptionPaneErrorPopUp( "Secondary Diagonal Not a Magic Square!" );
           error = true;
           highlightIncorrectCells( 4, 0 );
	   }

       return error;
   }

   private static void highlightIncorrectCells( int id, int rows )
   {
	   for ( int i = 0; i < MagicSquareGUI.NUMBER_OF_COLUMNS; i++ )
	   {
		   if ( id == 1 )
		   {				//Row doesn't add up.
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[i][rows], false );
		   }
		   else if ( id == 2 )
		   {			   //Column doesn't add up
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[rows][i], false );
		   }
		   else if ( id == 3 )
		   {				//Primary diagonal doesn't add up.
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[i][i], false );
		   }
		   else if ( id == 4 )
		   {				//Secondary diagonal doesn't add up
			   ErrorHighlighting.setTextField( MagicSquareGUI.magicSquare[i][MagicSquareGUI.NUMBER_OF_COLUMNS - ( i + 1) ],
			        false );
		   }
	   }
   }
}