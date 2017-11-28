/***********************************************************************
* 
*	File: HelloWorldApplet.java
*
*	Project:  HelloWorld--Applet
*   
*	Description:  Create an applet that displays the words HelloWorld
*
*	Author:  Joshua Wiley
*
*	Date:  2-7-15
*
*	Comments:  I tried to run the applet in Google Chrome and IE both gave 
*              secerity warnings and blocked the file from running 
* 
**********************************************************************/

import java.applet.*;
import java.awt.*;

public class HelloWorldApplet extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("HelloWorld", 10, 10);
	}
	
}
