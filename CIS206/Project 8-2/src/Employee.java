/**
 *
 * @author Joshw
 */

public class Employee extends Person
{
    private String SSNumber;
    
    public Employee()
    {
        super("Anne", "Prince", "anne@murach.com");
        this.SSNumber = "111-11-1111"; 
    }

    public String getSSNumber()
    {
        return SSNumber;
    }

    public void setSSNumber( String SSNumber )
    {
        this.SSNumber = SSNumber;
    }
    
    @Override
    public String getDisplayText()
    {
        return super.toString() + "\nSocial security number: " 
                                + this.getSSNumber() + "\n";
    }
}
