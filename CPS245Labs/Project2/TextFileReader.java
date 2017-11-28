
/**
 * ***********************************************************************
 *
 * File: TextFileReader.java
 *
 * Author: Joshua Wiley
 *
 * Description: Reads records from a text file
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 ************************************************************************
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextFileReader
{
    public static String[] readTextFile( String fileName, int readNextLineCounter )
                    throws ExceptionHandling
    {
        /**
         * * Local variables **
         */

        int recordCount = 0;
        boolean validFile = false;

        JOptionPaneErrorPopUp errorPopUp = null;
        
        if (recordCount < readNextLineCounter)
        {
            streamInput = null;
        }

        return streamInput;
    }

    private static String fileError( String message ) throws ExceptionHandling
    {
        JOptionPaneErrorPopUp errorPopUp = null;

        ErrorHighlighting.setTextField(MagicSquareGUI.txtFileName, false);
        errorPopUp = new JOptionPaneErrorPopUp(message);
        String fileName = GUIFileChooser.GUIFileChooser();

        if (fileName.equals(""))
        {
            throw new ExceptionHandling("No File Selected");
        }
        else
        {
            ErrorHighlighting.setTextField(MagicSquareGUI.txtFileName, true);
            MagicSquareGUI.txtFileName.setText(fileName);
        }
        return fileName;
    }

    private static void validateString( String newString ) throws ExceptionHandling
    {
        //Makes sure the string is not empty
        if (newString.trim().length() < 1)
        {
            throw new ExceptionHandling("No filename entered");
        }
        else if (newString.indexOf(".txt") == -1)
        {
            throw new ExceptionHandling("Invalid filename entered. Must end with .txt");
        }
    }
}
