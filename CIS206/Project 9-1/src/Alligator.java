/**
 *
 * @author Joshw
 */

public class Alligator implements Countable
{
    private int count;
    
    @Override
    public void incrementCount()
    {
        ++count;
    }

    @Override
    public void resetCount()
    {
        this.count = 0;
    }

    @Override
    public int getCount()
    {
        return this.count;
    }

    @Override
    public String getCountString()
    {
        String s = this.getCount() + " Alligator";
        
        return s;
    }
    
}
