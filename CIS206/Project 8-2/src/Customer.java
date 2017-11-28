/**
 *
 * @author Joshw
 */

public class Customer extends Person
{
    private String customerID;
    
    public Customer()
    {
        super();
        this.customerID = "M10293"; 
    }

    public String getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID( String customerID )
    {
        this.customerID = customerID;
    }
    
    @Override
    public String getDisplayText()
    {
        return super.toString() + "\nCustomer number: " + 
               this.getCustomerID() + "\n";
    }
}
