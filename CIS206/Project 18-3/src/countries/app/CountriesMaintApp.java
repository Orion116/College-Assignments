/**
 *
 * @author Joshw
 */
package countries.app;

import countries.io.*;
import java.util.*;

public class CountriesMaintApp
{
    private Scanner sc = null;
      
    public void CountriesMaintApp()
    {
        // display a welcome message
        System.out.println("Welcome to the Countries Maintenance application\n");

        sc = new Scanner(System.in);

        // perform 1 or more actions
        int action = 0;
  
        while (action != 3)
        {
            // get the input from the user
            if (action == 1)
                displayAllCountries();
            else if (action == 2)
                addCountry();
            else if (action == 3)
                System.out.println("Bye.\n");
            
            printMenu();
            action = Validator.getInt(sc, "Enter a command: ",1,2,3,0);
            System.out.println();
        }
    }
    
    private void printMenu()
    {
        System.out.println("\nWhat do the options mean?");
        System.out.println("---------------------------");
        System.out.println("1 - list");
        System.out.println("2 - add country");
        System.out.println("3 - exit\n");
    }
   
    public void displayAllCountries()
    {
        CountriesTextFile c = new CountriesTextFile();
        
        ArrayList<String> countries = c.getCountries();
        
        for (String displayCountries : countries)
        {  
            System.out.println(displayCountries);
        }
    }

    public void addCountry()
    {
        CountriesTextFile c = new CountriesTextFile();
        
        ArrayList<String> countries = c.getCountries();
        String country = Validator.getLine(sc, "Enter Country name: ");
        boolean flag = true;
                
        countries.add(country);
    
        flag = c.saveCountries(countries);
        if (flag)
        {
            System.out.println("\n" + country + " was added successfully");
        }
        else
        {
            System.out.println("\n" + country + " was not added successfully");
        }
    }
    
    public static void main(String[] args)
    {
        CountriesMaintApp cm = new CountriesMaintApp();
        cm.CountriesMaintApp();
    }
}
