/**
 *
 * @author Joshw
 */

public class PairOfDice
{
    Die die1 = new Die();
    Die die2 = new Die();

    public PairOfDice()
    {
        die1 = new Die();
        die2 = new Die();
    }
    
    public PairOfDice(int sides)
    {
        die1 = new Die(sides);
        die2 = new Die(sides);
    }
    
    public void roll()
    {
        die1.roll();
        die2.roll();
    }
    
    public int getDieValue1()
    {
        return die1.getDieValue();
    }
    
    public int getDieValue2()
    {
        return die2.getDieValue();
    }
    
    public int getSumOfDice()
    {
        int sumOfDice = 0;
        
        sumOfDice = getDieValue1() + getDieValue2();
        
        return sumOfDice;
    }
}
