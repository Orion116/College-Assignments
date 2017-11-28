/**
 *
 * @author Joshw
 * 
 */
import java.util.Scanner;

public class Validator
{    
    public static String getValidString(Scanner sc, 
                                        String prompt,
                                        String choiceOne, 
                                        String choiceTwo)
    {
        String choice = choiceTwo;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase(choiceOne) || 
                choice.equalsIgnoreCase(choiceTwo))
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error! Entry must be '" + choiceOne + 
                                   "' or '" + choiceTwo + "'. Try again.\n");                       
            }
        }
        return choice;
    }
    
    public static String getValidString(Scanner sc, 
                                        String prompt,
                                        String choiceOne, 
                                        String choiceTwo, 
                                        String choiceThree)
    {
        String choice = choiceTwo;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase(choiceOne) || 
                choice.equalsIgnoreCase(choiceTwo) || 
                choice.equalsIgnoreCase(choiceThree))
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error! Entry must be '" + choiceOne + 
                                   "' or '" + choiceTwo + "' " +
                                   "' or '" + choiceThree + "'. Try again.\n");                       
            }
        }
        return choice;
    }
    
    public static String getValidString(Scanner sc, 
                                        String prompt,
                                        String choiceOne, 
                                        String choiceTwo,
                                        String choiceThree,
                                        String choiceFour,
                                        String choiceFive)
    {
        String choice = choiceOne;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase(choiceOne) || 
                choice.equalsIgnoreCase(choiceTwo) ||
                choice.equalsIgnoreCase(choiceThree) ||
                choice.equalsIgnoreCase(choiceFour) ||
                choice.equalsIgnoreCase(choiceFive))
            {                
                isValid = true;
            }
            else
            {
                System.out.println("Error! Entry must be '" + choiceOne + 
                                   "' or '" + choiceTwo + "'" + 
                                   "' or '" + choiceThree +"'" + 
                                   "' or '" + choiceFour +"'" + 
                                   "' or '" + choiceFive + "'. Try again.\n");                       
            }
        }
        return choice;
    }
    
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
    
    public static String getNextLine(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();  // read user entry
        return s;
    }
    
    /*** Special Case getSpecialString ***/
    
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                             *
     *  getSpecialString is a validator to that allows for a high  *
     *  degree of customization of error messages and range checks *
     *                                                             *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    public static String getSpecialString(Scanner sc, String prompt,
                                          String errorLabel, int textLength,
                                          int specialCase)
    {
        String s = "INVALID";  
        boolean isValid = false;
        s = getNextLine(sc, prompt);  // read user entry
 
        while (isValid == false)
        {   
            if (specialCase <= s.trim().length())
            {
                ++specialCase;
                isValid = true;
            }
            else
            {
                System.out.println(errorLabel + specialCase + " character\n");
                s = getNextLine(sc, prompt);
            }
        }       
        return s;
    }
    
    public static String getSpecialString(Scanner sc, String prompt,
                                   String errorLabel, String example,
                                   int textLength, int specialCase)
    {
        String s = "INVALID";  
        boolean isValid = false;
        s = getNextLine(sc, prompt);  // read user entry
 
        while (isValid == false)
        {
            if (specialCase <= s.trim().length())
            {
                ++specialCase;
                isValid = true;
            }
            else
            {
                System.out.println(errorLabel + " of " + specialCase + 
                                   " character. " + example );
                s = getNextLine(sc, prompt);
            }
        }       
        return s;
    }

    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("\tError! Invalid integer value. "
                                   + "Try again.\n");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, 
                             String prompt,
                             int min,
                             int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i < min || i > max)
                System.out.println("\tError! Number must be in range (" + 
                                   min + ", " + max + ")\n");
            else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {  
                System.out.println("Error! Invalid decimal value. Try again.\n");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc,
                                   String prompt,
                                   double min, 
                                   double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(sc, prompt);
            if (d <= min || d >= max)
                System.out.println("Error! Number must be in range (" + 
                                   min + ", " + max + ")\n");
            else
                isValid = true;
        }
        return d;
    }
}
