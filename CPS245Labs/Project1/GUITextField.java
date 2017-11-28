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

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUITextField extends JTextField
{
    public GUITextField( int columns, boolean align, String toolTip )
    {
        super(columns);

        if (align)   //Left align letters
        {
            setHorizontalAlignment(JTextField.LEFT);
        }
        else           //Right aligns numbers
        {
            setHorizontalAlignment(JTextField.RIGHT);
        }

        setToolTipText(toolTip);
        setFont(new Font("Times New Roman", Font.BOLD, 20));
        setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
    }
}
