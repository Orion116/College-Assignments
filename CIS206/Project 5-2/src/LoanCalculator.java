/**
 *
 * @author Joshw
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator
{
    public static void main(String[] args)
    {
        String prompt = "Welcome to the Future Value Calculator\n";
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        
        System.out.println (prompt);

       while (choice.equalsIgnoreCase("y"))
       {
            // get the input from the user
            System.out.println("DATA ENTRY");
            double loanAmount = getDoubleWithinRange(sc,
                "Enter monthly investment:\t", 0.0, 1000000.0);
            double yearlyInterestRate = getDoubleWithinRange(sc,
                "Enter yearly interest rate:\t", 0.0, 20.0);
            int years = getIntWithinRange(sc,
                "Enter number of years:\t\t", 0, 100);

            // calculate the monthly payment
            double monthlyInterestRate = yearlyInterestRate/12/100;
            int months = years * 12;
            double monthlyPayment = calculateMonthlyPayment(
                        loanAmount, monthlyInterestRate, months);
            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // format the result as a single string
            String results = "Monthly investment:\t" + 
                             currency.format(loanAmount) + "\n" +
                             "Yearly interest rate:\t" +
                             percent.format(yearlyInterestRate/100) + "\n"+
                             "Number of years:\t" +
                             years + "\n" +
                             "Monthly Payment:\t" +
                             currency.format(monthlyPayment) + "\n";

            // print the results
            System.out.println();
            System.out.println("FORMATTED RESULTS");
            System.out.println(results);

            // see if the user wants to continue
            prompt = "Continue? (y/n): ";
            choice = getValidString(sc, prompt, "y", "n");
            sc.nextLine();  
            System.out.println();
        }
    }
   
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
            
            /* I was trying to add a error message 
             * 
             * if the user just hits the enter button 
             * 
             */
//            else if (sc.nextLine().equals(""))
//            {
//                System.out.println("Error! This entry is required. Try again.");   
//            }
            else
            {
                System.out.println("Error! Entry must be '" + stringY + 
                                   "' or '" + stringN + "'. Try again.");                       
            }

        }
        return choice;
    }

    public static double getDouble(Scanner sc,
                                   String prompt)
    {
        double returnDouble = 0.0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                returnDouble = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return returnDouble;
    }

    public static double getDoubleWithinRange(Scanner sc, 
                                              String prompt,
                                              double min, 
                                              double max)
    {
        double returnDouble = 0.0;
        boolean isValid = false;
        while (isValid == false)
        {
            returnDouble = getDouble(sc, prompt);
            if (returnDouble <= min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (returnDouble >= max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return returnDouble;
    }

    public static int getInt(Scanner sc, 
                             String prompt)
    {
        int returnInt = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                returnInt = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return returnInt;
    }

    public static int getIntWithinRange(Scanner sc, 
                                        String prompt,
                                        int min, 
                                        int max)
    {
        int returnInt = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            returnInt = getInt(sc, prompt);
            if (returnInt <= min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (returnInt >= max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return returnInt;
    }

    public static double calculateMonthlyPayment(double loanAmount,
                                                 double monthlyInterestRate, 
                                                 int months)
    {
        double monthlyPayment = 0;
        for (int i = 1; i <= months; i++)
        {
            monthlyPayment = loanAmount * monthlyInterestRate /
                            (1 - 1/Math.pow(1 + monthlyInterestRate, months));
        }
        return monthlyPayment;
    }
}