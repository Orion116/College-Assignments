package triangle.cal;

/**
 *
 * @author Joshw
 */

public class LongestSide
{
    public static double calculateLongestSide(double a, double b)
    {
        double c = 0.0;
        
        c = Math.hypot(a, b);
        
        return c;
    }    
}
