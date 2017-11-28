import java.sql.*;

public class CustomerInvoiceApp
{
    private static Connection connection = null;
    
    public static void main(String args[])
    {
        // get the connection and start the Derby engine
        connection = MurachDB.getConnection();
        if (connection != null)
            System.out.println("Welcome to the Customer Invoices Report\n");
        
        // select data from database
        printCustomer();

        // disconnect from the database
        if (MurachDB.disconnect())
            System.out.println("Derby has been shut down.\n");
    }

    public static void printCustomer() 
    {
        String selectInvoice = "SELECT Email, CustomerNumber, InvoiceDate, Price"
                        + " FROM Invoices ORDER BY Email ASC";
        
        try
        (
            // Create a scrollable, read-only result set
            PreparedStatement statement = connection.prepareStatement(
                            selectInvoice, ResultSet.TYPE_SCROLL_INSENSITIVE);

            ResultSet rs = statement.executeQuery()          
        )
        {  
            
            Invoices c = null;
            
            System.out.println("Invoices list:\n");
            while(rs.next())
            {
                String email = rs.getString("Email");
                String customerID = rs.getString("CustomerNumber");
                String invData = rs.getString("InvoiceDate");
                double price = rs.getDouble("Price");

                c = new Invoices(email, customerID, invData, price);

                printCustomer(c);
            }
            System.out.println();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    // use this method to print a Invoices object on a single line
    private static void printCustomer(Invoices c)
    {
        String productString =
            StringUtils.padWithSpaces(c.getEmailAddress(), 30) +
            StringUtils.padWithSpaces(c.getCustomerID(), 10) +
            StringUtils.padWithSpaces(c.getInvDate(), 10) +
            StringUtils.padWithSpaces(c.getFormattedPrice(), 15);

        System.out.println(productString);
    }
}