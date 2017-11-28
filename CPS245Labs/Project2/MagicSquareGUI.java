
/**
 * ***********************************************************************
 *
 * File: MagicSquareGUI.java
 *
 * Author: Joshua Wiley
 *
 * Description: Creates a Magic Square
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 ************************************************************************
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MagicSquareGUI
                implements ActionListener
{
    /**
     * * Class Constants **
     */

    private static final int N_MAGIC_NUMBER = 3;
    protected static final int MINIMUM_NUMBER_SQUARE = 1;
    protected static final int MAXIMUM_NUMBER_SQUARE = N_MAGIC_NUMBER * N_MAGIC_NUMBER;
    protected static final int NUMBER_OF_COLUMNS = N_MAGIC_NUMBER;
    protected static final int NUMBER_OF_ROWS = N_MAGIC_NUMBER;

    /**
     * * Class Variables **
     */
    private int readNextLineCounter = 0;
    private String oldFileName = "";

    //Creates text fields
    public static GUITextField txtFileName;

    //Creates buttons
    private JButton btnCheckMagicBox;
    private JButton btnClear;
    private JButton btnExit;
    private JButton btnGetNextRecord;
    //Creates a text area
    protected static JTextArea txtADisplay = null;

    protected static IntField magicSquare[][] = new IntField[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    /**
     * * Class Methods **
     */
    //displays the GUI
    public MagicSquareGUI()
    {
        startMagicSquareGUI();
    }

    public void startMagicSquareGUI()
    {
        JFrame jfrWindow = null;
        Container c = null;

        /**
         * * Create the object **
         */
        jfrWindow = new JFrame();
        c = jfrWindow.getContentPane();

        /**
         * * Create the GUI components **
         */
        buildGUI(c);
        setWindowAttributes(jfrWindow);
    }

    private void buildGUI( Container c )
    {
        /**
         * * Local variables **
         */

        JPanel pnlInput = null;
        JPanel pnlButton = null;
        JPanel pnlDisplay = null;

        /**
         * * Sets what the panels to their respective methods will do **
         */
        pnlInput = inputPanel();
        pnlButton = buttonPanel();
        pnlDisplay = displayPanel();

        /**
         * * Adds the panels to the GUI **
         */
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));

        c.add(pnlInput);
        c.add(pnlButton);
        c.add(pnlDisplay);
    }

    //Sets how the magic looks

    public void setWindowAttributes( JFrame jfrWindow )
    {
        jfrWindow.setSize(800, 700);
        jfrWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrWindow.setResizable(true);
        jfrWindow.setLocation(200, 40);
        jfrWindow.setTitle("Magic Square");
        jfrWindow.pack();
        jfrWindow.setVisible(true);
    }

    private JPanel inputPanel()
    {
        /**
         * * Local Constants **
         */

        final int MAXIMUM_STRING_LENGTH = 3;
        final int MAXIMUM_FILE_NAME = 20;

        /**
         * * Local variables **
         */
        int rows = 0;
        int columns = 0;

        JPanel pnlInput = null;
        JLabel lblFileInput = null;

        /**
         * * Sets a New panel appearance **
         */
        //Use titled border
        pnlInput = new GUIPanel(2, "Enter Integers ("
                        + MINIMUM_NUMBER_SQUARE + "-" + MAXIMUM_NUMBER_SQUARE
                        + ") Into the Magic Square");

        pnlInput.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        /**
         * * Creates GUI components **
         */
        for (rows = 0; rows < NUMBER_OF_ROWS; rows++)
        {
            for (columns = 0; columns < NUMBER_OF_COLUMNS; columns++)
            {
                magicSquare[rows][columns] = new IntField(MAXIMUM_STRING_LENGTH,
                                3, "Enter Integer", 30,
                                MINIMUM_NUMBER_SQUARE,
                                MAXIMUM_NUMBER_SQUARE);
                /**
                 * * Adds the GUI components to the panel **
                 */
                //Constraints for magicSquare[rows][columns]
                c.insets = new Insets(5, 10, 0, 0);
                c.ipadx = 40;
                c.ipady = 40;
                c.gridx = rows;
                c.gridy = columns;
                pnlInput.add(magicSquare[rows][columns], c);
            }
        }
        lblFileInput = new GUILabel("Or Enter a File Name:");
        txtFileName = new GUITextField(MAXIMUM_FILE_NAME, 1,
                        "Complete file name i.e. Input.txt", 18);

        c.insets = new Insets(0, 10, 0, 0);
        c.ipadx = 0;
        c.ipady = 10;
        c.gridy = rows + 2;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlInput.add(lblFileInput, c);

        c.insets = new Insets(0, 10, 20, 0);
        c.gridy = rows + 4;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlInput.add(txtFileName, c);

        return pnlInput;
    }

    private JPanel buttonPanel()
    {
        /**
         * * Local variables **
         */

        JPanel pnlButton = null;
        pnlButton = new GUIPanel(1, "");  //Use untitled border
        pnlButton.setLayout(new FlowLayout());

        /**
         * * sets the name of the button and enables the action listener **
         */
        btnCheckMagicBox = new GUIButton("Check Magic Square",
                        "Click to See If You Have A Magic Square", 200);
        btnCheckMagicBox.addActionListener(this);

        btnGetNextRecord = new GUIButton("Get Next Record", "Click to Read From A File", 170);
        btnGetNextRecord.addActionListener(this);

        btnClear = new GUIButton("Clear", "Clears All Fields", 100);
        btnClear.addActionListener(this);

        btnExit = new GUIButton("Exit", "Ends Program", 100);
        btnExit.addActionListener(this);

        /**
         * * Adds the GUI components to the panel **
         */
        pnlButton.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlButton.add(btnCheckMagicBox);
        pnlButton.add(btnGetNextRecord);
        pnlButton.add(btnClear);
        pnlButton.add(btnExit);

        return pnlButton;
    }

    private JPanel displayPanel()
    {
        /**
         * * Local variables **
         */

        JPanel pnlOutput = null;
        pnlOutput = new GUIPanel(2, "Magic Square Information"); //Use titled border
        //Sets the display size
        txtADisplay = new GUITextArea(5, 35);

        /**
         * * Adds the GUI components to the panel **
         */
        pnlOutput.add(txtADisplay);

        return pnlOutput;
    }

    /*-------------------------------------------------------------------
     * Handle button events -- i.e. user clicks button
     *-------------------------------------------------------------------*/
    public void actionPerformed( ActionEvent e )
    {
        /**
         * * Performs an action when a button is pressed **
         */

        if (e.getSource() == btnCheckMagicBox)
        {
            processCheckMagicBox();
        }
        else if (e.getSource() == btnGetNextRecord)
        {
            clearDisplay();
            nextRecordFile();
        }
        else if (e.getSource() == btnClear)
        {
            ErrorHighlighting.setTextField(txtFileName, true);
            txtFileName.setText(" ");
            clearDisplay();
        }
        else if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }

    //Clears all the fields

    private void clearDisplay()
    {
        for (int rows = 0; rows < NUMBER_OF_ROWS; rows++)
        {
            for (int columns = 0; columns < NUMBER_OF_COLUMNS; columns++)
            {
                ErrorHighlighting.setTextField(magicSquare[rows][columns], true);
                magicSquare[rows][columns].setText(" ");
            }
        }
        txtADisplay.setText(" ");
    }

    private void processCheckMagicBox()
    {
        JOptionPaneErrorPopUp errorPopUp = null;

        /**
         * * Try/Catch to catch errors input boxes **
         */
        try
        {
            MagicSquareCO.validation();
        }
        catch (ExceptionHandling e)
        {
            errorPopUp = new JOptionPaneErrorPopUp(e.getMessage());
        }
    }

    private void nextRecordFile()
    {
        /**
         * * Local variables **
         */

        File file = null;
        JOptionPaneErrorPopUp errorPopUp = null;
        String readFromTextFile[] = null;

        /**
         * * Try/Catch to catch errors when during file reading **
         */
        try
        {
            String fileName = txtFileName.getText();

            if (!fileName.equals(this.oldFileName))
            {
                readNextLineCounter = 0;
                this.oldFileName = fileName;
            }
            readNextLineCounter++;
            readFromTextFile = TextFileReader.readTextFile(fileName, readNextLineCounter);
            if (readFromTextFile != null)
            {
                setUpMagicSquare(readFromTextFile);
            }
            else
            {
                errorPopUp = new JOptionPaneErrorPopUp("End of file reached.");
                readNextLineCounter = 0;
            }
        }
        catch (ExceptionHandling e)
        {
            errorPopUp = new JOptionPaneErrorPopUp(e.getMessage());
        }
    }

    private void setUpMagicSquare( String readFromTextFile[] )
    {
        /**
         * * Local variables **
         */

        int rows = 0;
        int columns = 0;
        int textFileIndex = 0;

        /**
         * * Performs he echo check into the GUI **
         */
        while (rows < NUMBER_OF_ROWS && textFileIndex < readFromTextFile.length)
        {
            while (columns < NUMBER_OF_COLUMNS && textFileIndex < readFromTextFile.length)
            {
                magicSquare[columns][rows].setText(readFromTextFile[textFileIndex]);
                //Increments values
                columns++;
                textFileIndex++;
            }
            //Increments rows and resets columns
            rows++;
            columns = 0;
        }
    }

    /**
     * * Application **
     */
    public static void main( String args[] )
    {
        MagicSquareGUI test = new MagicSquareGUI();
    }
}
