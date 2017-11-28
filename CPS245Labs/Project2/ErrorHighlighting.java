/*************************************************************************
 *
 * File: ErrorHighlighting.java
 *
 * Author: Joshua Wiley
 *
 * Description:  Highlights invalid textfields and unhighlights good ones
 *
 * Date: 5-20-15
 *
 * Comments:
 *
 *************************************************************************/

import javax.swing.*;
import java.awt.*;

public class ErrorHighlighting
{
    /**
     * * Text field validation colors **
     */

    public static void setTextField( JTextField errorInField, boolean valid )
    {
        if (valid)
        {
            errorInField.setBackground(Color.WHITE);
            errorInField.setForeground(Color.BLUE);
        }
        else
        {
            errorInField.setBackground(Color.RED);
            errorInField.setForeground(Color.WHITE);
            errorInField.requestFocus();
            errorInField.selectAll();
        }
    }
}
