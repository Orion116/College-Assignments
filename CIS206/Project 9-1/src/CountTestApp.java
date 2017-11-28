/**
 *
 * @author Joshw
 */

public class CountTestApp 
{
    public static void main(String args[]) throws CloneNotSupportedException
    {
        Countable c = new Alligator();
        Sheep s1 = new Sheep();
        
        int maxCount = 3;
        
        System.out.println("Counting Alligator. . .\n");
        CountUtil.count(c, maxCount);
        System.out.println();
        
        maxCount = 2;
        System.out.println("Counting Sheep. . .\n");
        CountUtil.count(s1, maxCount);
        System.out.println();
        
        // clone the Sheep
        Sheep s2 = (Sheep) s1.clone();

        // change a value in the cloned Sheep
        s2.setNameOfSheep("Dolly");
        s2.resetCount();
        
        String sheepName1 = s1.getNameOfSheep();
        String sheepName2 = s2.getNameOfSheep();
        if (sheepName1.equalsIgnoreCase(sheepName2))
        {
            System.out.println("FAILURE: The clone method of the Sheep " +
                               "class is not cloning data.");
        }
        else if (!sheepName1.equalsIgnoreCase(sheepName2))
        {
            maxCount = 3;
            CountUtil.count(s2, maxCount);
        }
        System.out.println();
        
        maxCount = 1;
        s1.resetCount();
        CountUtil.count(s1, maxCount);
        System.out.println();
    }
}
