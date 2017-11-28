/**
 *
 * @author Joshw
 */

public class Die
{
    private int sides;
    private int value;
    
    public Die()
    {
        this.value = 1;
        this.sides = 6;
    }
    
    public Die(int sides)
    {
        this.value = 1;
        this.sides = sides;
    }
    
    public void roll()
    {
        value = (int) (Math.random() * sides);
        ++value;
    }
    
    public int getDieValue()
    {
        return this.value;
    }
}
