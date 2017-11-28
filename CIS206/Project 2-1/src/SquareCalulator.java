/*******************************************************
 * 
 *      Programmer: Joshua Wiley
 * 
 *      Date: 9-2-15
 * 
 *      Comments: none
 * 
*******************************************************/
import java.util.Scanner;

public class SquareCalulator
{
        public static void main( String[] args )
        {
                 // create a Scanner object named sc
                Scanner sc = new Scanner( System.in );
                
                /*** Variables ***/
                String choice = "y";
                
                double length = 0.0;
                double width = 0.0;
                double perimeter = 0.0;
                double area = 0.0;
                
                // welcome the user to the program
                System.out.println( "Welcome to the Area and Perimeter Calculator\n" );

                // perform invoice calculations until choice isn't equal to "y" or "Y"                
                while ( choice.equalsIgnoreCase( "y" ) )
                {
                        // get the lenght & perimeter from the user
                        System.out.print( "Enter Length:   " );
                        length = sc.nextDouble();
                        System.out.print( "Enter Width:    " );
                        width = sc.nextDouble();
                        
                        /*** Calculates area and perimeter ***/
                        area = width * length;
                        perimeter = 2 * width + 2 * length;
                        
                        /*** Displays area and perimeter ***/
                        String message =  "Area:           " + area + "\n" +
                                                               "Perimeter:      " + perimeter + "\n";
                        System.out.println( message );
                        
                        // see if the user wants to continue
                        System.out.print( "Continue? (y/n): " );
                        choice = sc.next();
                        System.out.println();
                }
        }
}