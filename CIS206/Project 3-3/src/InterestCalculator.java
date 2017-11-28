/**
 * * @author Joshua Wiley
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.text.NumberFormat;

public class InterestCalculator
{
    public static void main(String[] args)
    {
        // display operational messages
        System.out.println("Please enter a loan amount "
                           + "and percentage in decimal format, "
                           + "for example (.03) = 3%");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        String loanAmount = "";
        String interestRate = "";
        String choice = "y";
        Scanner sc = new Scanner ( System.in );

        // get a series of test scores from the user
        while ( choice.equalsIgnoreCase ( "y" ) )
        {
            // get the input from the user
            System.out.print("Enter loan amount:   ");
            loanAmount = sc.next();
            System.out.print("Enter interest rate: ");
            interestRate = sc.next();
                                   
            /*** calculate total amount of interest ***/
            BigDecimal interestRateBD = new BigDecimal(interestRate);
            BigDecimal loanAmountBD = new BigDecimal(loanAmount);        
            BigDecimal interestAmount = loanAmountBD.multiply(interestRateBD);
            interestAmount = interestAmount.setScale (2, RoundingMode.HALF_UP);
            
            /*** format output for the user ***/
            NumberFormat currency = NumberFormat.getCurrencyInstance ();
            NumberFormat percent = NumberFormat.getPercentInstance (); 
            percent.setMaximumFractionDigits (3);           

            // display the everything that needs to be shown         
            String message = "\n" + "Loan amount:         " + 
                             currency.format (loanAmountBD) + 
                             "\n" + "Interest rate:       " + 
                             percent.format (interestRateBD) + 
                             "\n" + "Interest:            " + 
                             currency.format (interestAmount) + "\n";
            System.out.println(message);
            
            /*** on / off switch ***/
            System.out.print ( "Do You Wish To Continue? (y/n): " );
            choice = sc.next ();
            System.out.println ();
        }            
    }
}