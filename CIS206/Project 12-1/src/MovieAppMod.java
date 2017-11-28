import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Joshw
 */

public class MovieAppMod
{
    public void MovieAppMod()
    {
        ArrayList<Movie> movies = createMovieArrayList();
        Scanner sc = new Scanner(System.in);
        
        // Declare variables
        String prompt = "";
        String categoryMenu = "";
        String category = "";
        String choice = "y";
        int menuCount = 0;
        
        // Print messages
        prompt =  "Welcome to the Movie List Application\n";
        prompt += "There are" + (movies.size()-1) + " movies in the list\n";
        prompt += "Enter the Number of the Category you are Intereested in.";


        System.out.println (prompt);
        printMenu(menuCount);

        while (choice.equalsIgnoreCase("y"))
        {
            // Display Categories
            menuCount = 1;
            // Validate string
            prompt = "Choose a Category: ";
            categoryMenu = Validator.getValidString(sc, prompt,
                                                    "1","2","3","4","5"); 
            
            if (categoryMenu.equalsIgnoreCase("1"))
                category = "animated";
            else if (categoryMenu.equalsIgnoreCase("2"))
                category = "drama";
            else if (categoryMenu.equalsIgnoreCase("3"))
                category = "comedy";
            else if (categoryMenu.equalsIgnoreCase("4"))
                category = "horror";
            else if (categoryMenu.equalsIgnoreCase("5"))
                category = "scifi";
            
            System.out.println("\nThe Movie Category You Chose: " + 
                               category + "\n");
           
            Collection<Movie> matchedMovies = new TreeSet<>();
            
            for(Movie movie : movies) 
            {
                if (category.equalsIgnoreCase(movie.getCategory()))
                { 
                    matchedMovies.add(movie);
                }
            }
            for (Movie movie : matchedMovies)
            {
                System.out.println(movie.getTitle());
            }
            System.out.println();
            prompt = "Continue? (y/n): ";
            choice = Validator.getValidString(sc, prompt, "y", "n", "?"); 
            
            if (choice.equals("?"))
            {
                printMenu(0);
                System.out.println();
                prompt = "Continue? (y/n): ";
                choice = Validator.getValidString(sc, prompt, "y", "n", "?"); 
            }
            if (choice.equalsIgnoreCase("y"))
                printMenu(menuCount); 
        }
    }
    
    private void printMenu(int i)
    {
        if (i == 0)
        {
            System.out.println("\nWhat do the options mean?");
            System.out.println("---------------------------");
            System.out.println("To continue use:        'y'");
            System.out.println("To end program use:     'n'");
            System.out.println("Enter to show this menu '?'");
            System.out.println("\nMovie Categories");
            System.out.println("------------------");    
            System.out.println("Animated: '1'");
            System.out.println("Drama:    '2'");
            System.out.println("Comedy:   '3'");
            System.out.println("Horror:   '4'");
            System.out.println("Scifi:    '5'\n");
        }
        if (i == 1)
        {
            System.out.println("\nMovie Categories");
            System.out.println("------------------");            
            System.out.println("Animated: '1'");
            System.out.println("Drama:    '2'");
            System.out.println("Comedy:   '3'");
            System.out.println("Horror:   '4'");
            System.out.println("Scifi:    '5'\n");
        }      
    }
    
    public ArrayList<Movie> createMovieArrayList()
    {
        Movie m;
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for (int i = 0; i <= 100; i++ )
        {
            m = MovieIO.getMovie(i);

            movieArrayList.add(m);
        }
        return movieArrayList;
    }
    
    public static void main(String args[])
    {
        MovieAppMod m = new MovieAppMod();
        m.MovieAppMod();
    }
}
