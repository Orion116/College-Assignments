/**
 *
 * @author Joshw
 */
import java.util.Scanner;

public class PersonTestApp
{
    public void PersonTester()
    {
       Customer c = new Customer();
       Employee e = new Employee();
       
       Scanner sc = new Scanner(System.in);
        
        // Declare variables
        String prompt = "";
        String personType = "";
        String choice = "y";
        
        // Print messages
        prompt = "Welcome to the Person Tester Application\n";
        System.out.println (prompt);
        printMenu();
        
        // Loop until stopped
        
        while (choice.equalsIgnoreCase("y"))
        {
            // Validate string
            prompt = "Create a Customer or an Employee? (c/e): ";
            personType = Validator.getValidString(sc, prompt, "c", "e", "?"); 
            System.out.println();

            if (personType.equalsIgnoreCase("c"))
            {
                setCustomernDetails(sc,c);                
                Print(c);
                prompt = "Continue? (y/n): ";
                choice = Validator.getValidString(sc, prompt, "y","n"); 
                System.out.println();

            }        
            else if (personType.equalsIgnoreCase("e"))
            {
                setEmployeeDetails(sc,e);                
                Print(e);         
                prompt = "Continue? (y/n): ";
                choice = Validator.getValidString(sc, prompt, "y", "n"); 
                System.out.println();    
            }
            else if (personType.equals("?"))
            {
                printMenu();
            }
        }
    }

    private void setCustomernDetails(Scanner input, Customer customer)
    {
        String userInput = "";
        String prompt = "";
        String errorLabel = "";
        String example = "";
        
        // Sets the first name
        prompt = "Enter First Name:     ";
        errorLabel = "\nYou must enter a first name longer than ";
        userInput = Validator.getSpecialString(input, prompt, errorLabel,999,1);
        customer.setFirstName(userInput);
        
        // Sets the last name
        prompt = "Enter Last Name:      ";
        errorLabel = "\nYou must enter a last name longer than ";
        userInput = Validator.getSpecialString(input, prompt, errorLabel,999,1);
        customer.setLastName(userInput);
        
        // Sets the email address
        prompt = "Enter Email Addresss: ";
        errorLabel = "\nYou must enter a email address longer than ";
        example = "i.e. johndoe@gmail.com\n";
        userInput = Validator.getSpecialString(input,prompt,errorLabel,
                                               example,255,12);
        customer.setEmailAddress(userInput);
        
        // Sets customer ID
        prompt = "Enter Customer ID:    ";
        errorLabel = "\nYou must enter a ID longer than ";
        example = "i.e.  M10293\n";        
        userInput = Validator.getSpecialString(input,prompt,errorLabel,
                                               example,12,5);
        customer.setCustomerID(userInput);
    }
    
    private void setEmployeeDetails( Scanner input, Employee employee )
    {
        String userInput = "";
        String prompt = "";
        String errorLabel = "";
        String example = "";
        
        // Sets the first name
        prompt = "Enter First Name:       ";
        errorLabel = "\nYou must enter a first name longer than ";
        userInput = Validator.getSpecialString(input, prompt, errorLabel,999,1);
        employee.setFirstName(userInput);
        
        // Sets the last name
        prompt = "Enter Last Name:        ";
        errorLabel = "\nYou must enter a last name longer than ";
        userInput = Validator.getSpecialString(input, prompt, errorLabel,999,1);
        employee.setLastName(userInput);
        
        // Sets the email address
        prompt = "Enter Email Addresss:   ";
        errorLabel = "\nYou must enter a email address longer than ";
        example = "i.e. johndoe@gmail.com\n";
        userInput = Validator.getSpecialString(input,prompt,errorLabel,
                                               example,255,12);
        employee.setEmailAddress(userInput);
        
        // Sets customer ID
        prompt = "Social Security Number: ";
        errorLabel = "\nYou must enter a SSN longer than ";
        example = "i.e. 111-11-1111";
        userInput = Validator.getSpecialString(input,prompt,errorLabel,
                                               example,11,11);
        employee.setSSNumber(userInput);
    }
     
    private void printMenu()
    {
        System.out.println("\nWhat do the options mean?");
        System.out.println("-------------------------");
        System.out.println("To continue use 'y'");
        System.out.println("To end program use 'n'");
        System.out.println("'c' Adds a Customer");
        System.out.println("'e' Adds a Employee");
        System.out.println("'?' Enter to show this menu\n");
    }
    
//    private void helpDesk()
//    {
//        printMenu();
//        
//        System.out.println();
//        System.out.println("Tips:\n");
//        System.out.println("");
//    }
    
    private static void Print(Person pType)
    {
        System.out.println(pType.getDisplayText());
    }
    
    public static void main(String[] args)
    {
        PersonTestApp person = new PersonTestApp();
        person.PersonTester();
    }
}
