/**
 *
 * @author Joshw
 */
import java.util.Scanner;

public class Validator
{
    public static String getValidString(Scanner sc, 
                                        String prompt,
                                        String stringY, 
                                        String stringN)
    {
        String choice = stringN;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            choice = sc.next();
            if (choice.equalsIgnoreCase(stringY) || 
                choice.equalsIgnoreCase(stringN))
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error! Entry must be '" + stringY + 
                                   "' or '" + stringN + "'. Try again.\n");                       
            }
            sc.nextLine();
        }
        return choice;
    }
    public static String getValidString(Scanner sc, 
                                        String prompt,
                                        String stringY, 
                                        String stringN,
                                        String stringX)
    {
        String choice = stringN;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            choice = sc.next();
            if (choice.equalsIgnoreCase(stringY) || 
                choice.equalsIgnoreCase(stringN) ||
                choice.equalsIgnoreCase(stringX))
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error! Entry must be '" + stringY + 
                                   "' or '" + stringN + "'" + 
                                   "' or '" + stringX + "'. Try again.\n");                       
            }
            sc.nextLine();
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
