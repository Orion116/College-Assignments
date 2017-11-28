/**
 *
 * @author Joshw
 */

package countries.io;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CountriesTextFile
{
    private ArrayList<String> countries = null;
    private Path countriesPath = null;
    private File countriesFile = null;

    private final String FIELD_SEP = "[ *+,!@#$%^&*<>?]\t";

    public CountriesTextFile()
    {
        // initialize the class variables
        countriesPath = Paths.get("countries.txt");
        countriesFile = countriesPath.toFile();
        countries = this.getCountries();
    }

    public ArrayList<String> getCountries()
    {
        // if the countries file has already been read, don't read it again
        if (countries != null)
            return countries;        

        countries = new ArrayList<>(); 
        
        if (Files.exists(countriesPath))
        {
            try(BufferedReader in = new BufferedReader(
                                    new FileReader(countriesFile)))
            {
                String line = in.readLine();
                while (line != null)
                {                    
                    String[] columns = line.split(this.FIELD_SEP);
                    String country = columns[0];
                                        
                    countries.add(country);
                    
                    line = in.readLine();
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
            return countries;
        }
        return countries;            
    }

    public boolean saveCountries(ArrayList<String> countries) 
    {   
        // save the Customer objects in the array list to the file
        boolean flag = true;
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(countriesFile))))
        {
            out.flush();
            for (String c : countries)
            {
                out.println(c);                
            }
            out.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }	
}
