
/**
 * ***********************************************************************
 *
 * File: TextFileReader.java
 *
 * Author: Joshua Wiley
 *
 * Description: Models a coffee shops ordering system that prints an invoice
 * to the GUI component or the system console
 *
 * Date: 4-24-15
 *
 * Comments: I made the GUI non-resizable. See tool tips for help. Shipping
 * invoices uses all caps.
 *
 ************************************************************************
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextFileReader
{
    public static String[] readTextFile( String fileName, int readNextLineCounter )
    {
        JOptionPaneErrorPopUp errorPopUp = null;
        BufferedReader inStream = null;
        String streamInput[] = null;
        File file = new File(fileName);

        int recordCount = 0;
        boolean validFile = false;

        while (!validFile)
        {
            try
            {
                inStream = new BufferedReader(new FileReader(fileName)); // Open the stream
                String record = null;
                record = inStream.readLine();

                while (record != null && recordCount < readNextLineCounter)
                {
                    record = record.replace("+", " ");
                    record = record.trim();
                    streamInput = record.split("[ *+,!@#$%^&*<>?]+");
                    record = inStream.readLine();
                    validFile = true;

                    recordCount++;
                }
                inStream.close();
            }
            catch (FileNotFoundException e)
            {
                errorPopUp = new JOptionPaneErrorPopUp("IOERROR: File NOT Found: " + fileName + "\n");
                fileName = GUIFileChooser.GUIFileChooser();
                MagicSquareGUI.txtFileName.setText(fileName);
                //e.printStackTrace();
            }
            catch (IOException e)
            {
                errorPopUp = new JOptionPaneErrorPopUp("IOERROR: " + e.getMessage() + "\n");
                validFile = true;
                //e.printStackTrace();
            }
        }

        if (recordCount < readNextLineCounter)
        {
            streamInput = null;
        }
        return streamInput;
    } // readTextFile
}
