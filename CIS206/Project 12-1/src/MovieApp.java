import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joshw
 */

public class MovieApp
{
    public static void MovieApp()
    {
        ArrayList<Movie> movies = createMovieArrayList();        
        Scanner sc = new Scanner(System.in);
        
        // Declare variables
        String prompt = "";
        String category = "";
        String choice = "y";
        
        // Print messages
        prompt =  "Welcome to the Movie List Application\n";
        prompt += "There are " + (movies.size()-1) + " movies in the list\n";
        prompt += "Enter the Number of the Category you are Intereested in.\n";
        System.out.println (prompt);
        while (choice.equalsIgnoreCase("y"))
        {
            // Validate string
            prompt = "Choose a Category: ";
            category = Validator.getString(sc, prompt); 
            System.out.println();
            
            for(Movie movie : movies) 
            {
                if (category.equalsIgnoreCase(movie.getCategory()))
                {  
                    System.out.println(movie.getTitle());
                }
            }
            
            System.out.println();
            prompt = "Continue? (y/n): ";
            choice = Validator.getValidString(sc, prompt, "y", "n"); 
            System.out.println(); 
        }
    }
        
    private static ArrayList<Movie> createMovieArrayList()
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
    
//    public static void main(String args[])
//    {
//        MovieApp m = new MovieApp();
//        m.MovieApp();
//    }
}
