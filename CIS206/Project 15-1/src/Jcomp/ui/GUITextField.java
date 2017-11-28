/*************************************************************************
 *
 * File: GUITextField.java
 *
 * Author: Joshua Wiley
 *
 * Description: Makes creating uniform JTextField easier
 *
 * Date: 4-18-15
 *
 * Comments:
 *
 *************************************************************************/

package Jcomp.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;

public class GUITextField extends JTextField
{
    public GUITextField( int columns, boolean align, String toolTip )
    {
        super( columns );

        if (align)   //Left align letters
            setHorizontalAlignment( JTextField.LEFT );
        else           //Right aligns numbers
            setHorizontalAlignment( JTextField.RIGHT );

        super.setToolTipText(toolTip);
        setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );
        setBorder( new MatteBorder( 1,1,1,1, Color.GRAY ) );
    }
    
    public GUITextField( JTextField txtField, int columns,
                         boolean align, String toolTip )
    {
        super( columns );

        if (align)   //Left align letters
            setHorizontalAlignment( JTextField.LEFT );
        else           //Right aligns numbers
            setHorizontalAlignment( JTextField.RIGHT );

        txtField.setToolTipText(toolTip);
        setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );
        setBorder( new MatteBorder( 1,1,1,1, Color.GRAY ) );
    }
    
    public boolean isDouble(JTextComponent c, String title)
    {
        boolean flag = false;
        try
        {
            double d = Double.parseDouble(c.getText());
            flag = true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be a valid number.");
            c.requestFocusInWindow();
            flag = false;
        }
        return flag;
    }
    
    private void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public double getTextField( JTextField errorInField, String valid )
    {
        double d = 0.0;
        if (isDouble(errorInField, valid))
        {
            errorInField.setBackground(Color.WHITE);
            errorInField.setForeground(Color.BLACK);
            d = Double.parseDouble(errorInField.getText());
        }
        else
        {
            errorInField.setBackground(Color.RED);
            errorInField.setForeground(Color.WHITE);
            errorInField.requestFocus();
            errorInField.selectAll();
        }
        return d;
    }
}
