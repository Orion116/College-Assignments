
import java.text.*;

/**
 *
 * @author Joshw
 */

public class Invoices
{
    private String emailAddress;
    private String customerID;
    private String invDate;
    private double price;
    
    public Invoices()
    {
        this.emailAddress = "frank44@hotmail.com";   
        this.customerID = "M0000";
        this.invDate = "00/00/00";   
        this.price = 0.0;       
    }
    
    public Invoices(String emailAddress, String customerID, String invDate, double price)
    {
        this.customerID = customerID;
        this.price = price;
        this.invDate = invDate; 
        this.emailAddress = emailAddress;        
    }
    
    public String getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID( String customerID )
    {
        if (customerID.trim().length() > 0)
           this.customerID = customerID;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
            this.price = price;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress )
    {
        this.emailAddress = emailAddress;
    }
    
    public String getFormattedPrice()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    @Override
    public String toString()
    {
        return "\nEmail: " + this.getEmailAddress() + 
               "\tName:  " + this.getCustomerID() + 
               "\tDate: " + this.getInvDate() + 
               "\t" + this.getFormattedPrice();
    }

    public String getInvDate()
    {
        return invDate;
    }

    public void setInvDate( String invDate )
    {
        this.invDate = invDate;
    }
}
