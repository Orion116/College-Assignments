/**
 *
 * @author Joshw
 * 
 * Comments:  Added a way for the user to chose the number of sides of the dice
 */
import java.util.Scanner;

public class DiceRollerApp
{
    public static void main(String[] args)
    {
        // Instance PairOfDice
        PairOfDice dice = new PairOfDice();
        Scanner sc = new Scanner(System.in);
        
        // Declare variables
        String prompt = "";
        String choice = "y";
        
        // Print messages
        prompt = "Welcome to the Paradise Roller application\n";
        prompt += "--------------------------------------------\n" 
                + "The program will ask if you want to use a \n"
                + "custom number of sides per a dice. It then\n"
                + "it gives the choice to roll a six sided dice.\n";
        System.out.println (prompt);
        printMenu();
        
        // Validate string
        prompt = "Roll the dice? (y/x): ";
        choice = Validator.getValidString(sc, prompt, "y", "x"); 
        System.out.println();
        
        // Loop until stopped
        while (choice.equalsIgnoreCase("y"))
        {
            choice = getWhileLoops(sc,dice,choice);  // Simplier main
        }
    }
    
    private static String getWhileLoops(Scanner sc, 
                                        PairOfDice dice, 
                                        String choice)
    {
        int count = 1;
        int sides = 6;
        String prompt = "";
        String sidesChoice = "";
        
        prompt = "Do you want to use a "
               + "custom sided dice. Default is 6 sides? (y/n/x): ";
        sidesChoice = Validator.getValidString(sc, prompt,"y","n","x");
        System.out.println();

        if (sidesChoice.equalsIgnoreCase("y"))
        {
            while (sidesChoice.equalsIgnoreCase("y"))      
            {  
                sides = Validator.getInt(sc,"Enter the Number of sides: ",
                                         6, 24); 
                dice = new PairOfDice(sides);
                simplifyLoops(dice, count);
                ++count;
                prompt = "Do you wish to contiue "
                       + "using custom sided dice? (y/n): ";
                sidesChoice = Validator.getValidString(sc, prompt, "y","n"); 
                System.out.println();
            }
        }        
        else if (sidesChoice.equalsIgnoreCase("n"))
        {
            while (choice.equalsIgnoreCase("y"))      
            {           
                // get the input from the user
                simplifyLoops(dice, count);
                ++count;
                prompt = "Roll again? (y/n): ";
                choice = Validator.getValidString(sc, prompt, "y", "n"); 
                System.out.println();
            }
        }
        else if (sidesChoice.equalsIgnoreCase("x"))
        {
            choice = "n";
        }
        return choice;
    }
    
    private static void simplifyLoops(PairOfDice dice, int count)
    {
        System.out.println("\nRoll " + count + ":\r");
        dice.roll();
        System.out.println("\nDie 1: " + dice.getDieValue1());
        System.out.println("Die 2: " + dice.getDieValue2());
        String message = getSpecialMessage(dice);
        System.out.println(message);
    }
    
    private static void printMenu()
    {
        System.out.println("\nWhat do the options mean?");
        System.out.println("-------------------------");
        System.out.println("To continue use 'y'");
        System.out.println("To exit sub program use 'n'");
        System.out.println("To exit program use 'x'\n");
    }
    
    private static String getSpecialMessage(PairOfDice dice)
    {
        String message = "";
        
        if (dice.getSumOfDice() == 7)
        {
            message = "Craps!\n";
        }
        else if (dice.getSumOfDice() == 12)
        {
            message = "Box Cars!\n";
        }
        else if (dice.getSumOfDice() == 2)
        {
            message = "Snake eyes!\n";
        }
        
        return message;
    }
}