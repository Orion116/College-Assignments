/**
 *
 *  Programmer: Joshua Wiley
 * 
 */

import java.util.Scanner;

public class PowersTable
{
    public static void main(String[] args)
    {
        // display operational messages
        System.out.println("Please enter test scores" + 
                           " that range from 0 to 100.");
        System.out.println("To end the program enter \"n\".");
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        String choice = "y";  // Y so serious
        int userInput = 0;

        while (choice.equalsIgnoreCase("y"))
        {
            String formattedText = "";           
            //int userInput = 0;
                // get the input from the user

            System.out.print("Enter an integer: ");            
            userInput = sc.nextInt();
            System.out.println();
            //formattedText
            formattedText = "Number\t" + "Squared\t" + "Cubed\n";            
            formattedText += "======\t" + "=======\t" + "=====";
            System.out.println(formattedText);  

            for (int i = 1; i <= userInput; i++)
            {
                int countForSquareRoot = i;
                int countForCubedRoot = i;
                int squared = countForSquareRoot * countForSquareRoot;
                int cubed = countForCubedRoot 
                          * countForCubedRoot
                          * countForCubedRoot;

                String numberPrintOut = i + "\t" + squared + "\t" + cubed;

                System.out.println(numberPrintOut);
            }
            System.out.println();

            //Coninue button
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }   
}