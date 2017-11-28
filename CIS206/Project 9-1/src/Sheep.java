/**
 *
 * @author Joshw
 */

public class Sheep implements Countable, Cloneable
{
    private int count;
    private String nameOfSheep = "Blackie";
    
    public String getNameOfSheep()
    {
        return nameOfSheep;
    }

    public void setNameOfSheep( String nameOfSheep )
    {
        this.nameOfSheep = nameOfSheep;
    }
    
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
        String s = this.getCount() + " " + this.getNameOfSheep();
        
        return s;
    } 
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
