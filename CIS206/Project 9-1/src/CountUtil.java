/**
 *
 * @author Joshw
 */

public class CountUtil
{
    public static void count(Countable c, int maxCount)
    {
        for (int i = 0; i < maxCount; ++i)
        {
            c.incrementCount();
            System.out.println(c.getCountString());
        }
    }
}
