
/**
 * ***********************************************************************
 *
 * File: MagicSquareCO.java
 *
 * Author: Joshua Wiley
 *
 * Description: Validates Magic Square data
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 ************************************************************************
 */

import javax.swing.*;
import java.awt.*;

public class MagicSquareCO
{
    public static void validation() throws ExceptionHandling
    {
        /**
         * * Local variables **
         */

        int count[] = new int[MagicSquareGUI.MAXIMUM_NUMBER_SQUARE + 1];

        int rows = 0;
        int columns = 0;

        MagicSquareGUI.txtADisplay.setText(" ");

        for (int i = 0; i < count.length; i++)
        {
            count[i] = 0;
        }

        while (rows < MagicSquareGUI.NUMBER_OF_ROWS)
        {
            while (columns < MagicSquareGUI.NUMBER_OF_COLUMNS)
            {
                MagicSquareGUI.magicSquare[columns][rows].setText(
                                MagicSquareGUI.magicSquare[columns][rows].getText().trim());
                //Keeps track of the number of times a number is entered
                count[MagicSquareGUI.magicSquare[columns][rows].getInt()]++;

                duplicateNumber(count[MagicSquareGUI.magicSquare[columns][rows].getInt()],
                                MagicSquareGUI.magicSquare[columns][rows]);

                ErrorHighlighting.setTextField(
                                MagicSquareGUI.magicSquare[columns][rows], true);
                columns++;
            }
            //Changes to the next row
            columns = 0;
            rows++;
        }
        SumValidation.SumValidation();
        MagicSquareGUI.txtADisplay.setText("\n Congratulations! You have a Magic Square. ");
    }

    private static void duplicateNumber( int count, IntField newField ) throws ExceptionHandling
    {
        //Makes sure the count not > 1
        if (count > 1)
        {
            ErrorHighlighting.setTextField(newField, false);
            throw new ExceptionHandling("Duplicate Integer.\nPlease Try Another Integer.");
        }
    }
}
