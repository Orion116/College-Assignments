/**
 *
 * @author Joshw
 */
public abstract class Person
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    
    public Person()
    {
        this.firstName = "Frank";
        this.lastName = "Jones";
        this.emailAddress = "frank44@hotmail.com";        
    }
    
    public Person(String firstName, String lastName, String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;        
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        if (firstName.trim().length() > 0)
           this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        if (lastName.trim().length() > 0)
            this.lastName = lastName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress )
    {
        this.emailAddress = emailAddress;
    }
    
    @Override
    public String toString()
    {
        return "\nName:  " + this.getFirstName() + " " + this.getLastName() +
               "\nEmail: " + this.getEmailAddress();
    }
    
    abstract String getDisplayText();
}
