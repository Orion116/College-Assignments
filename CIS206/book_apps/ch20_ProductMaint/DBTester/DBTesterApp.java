import java.util.*;
import java.sql.*;

public class DBTesterApp
{
    private static Connection connection = null;

    public static void main(String args[])
    {
        // set the connection
        connection = connect();

        printProducts();
        printFirstProduct();
        printLastProduct();
        printProductByCode("java");

        Product p = new Product("test", "Test Product", 49.50);
        insertProduct(p);
        deleteProduct(p);

        try
        {
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static Connection connect()
    {
        try
        {
            // use the DriverManager to create a Connection object
            String dbUrl = "jdbc:odbc:MurachDB";
            String username = "Admin";
            String password = "";
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            return connection;

        }
        catch(SQLException e)
        {
            e.printStackTrace();

            return null;
        }
    }

    public static void printProducts()
    {
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");
            Product p = null;

            System.out.println("Product list:");
            while(rs.next())
            {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                p = new Product(code, description, price);

                printProduct(p);
            }
            System.out.println();

            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    public static void printFirstProduct()
    {
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");
            if(rs.next())
            {
                // code that uses column names
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);

                System.out.println("First product:");
                printProduct(p);
                System.out.println();
            }
            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    public static void printLastProduct()
    {
        try
        {
            // Create a scrollable, read-only result set
            Statement statement = connection.createStatement(
              ResultSet.TYPE_SCROLL_INSENSITIVE,
              ResultSet.CONCUR_READ_ONLY);

            // Select all products
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");

            // move to last record
            rs.last();

            // code that uses indexes
            String code = rs.getString("ProductCode");
            String description = rs.getString("Description");
            double price = rs.getDouble("Price");
            Product p = new Product(code, description, price);

            System.out.println("Last product:");
            printProduct(p);
            System.out.println();

            rs.close();
            statement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    public static void printProductByCode(String productCode)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM Products WHERE ProductCode = ?");
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);

                System.out.println("Product by code: " + productCode);
                printProduct(p);
                System.out.println();
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    public static void insertProduct(Product p)
    {
        try
        {
            System.out.println("Insert test: ");

            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM Products WHERE ProductCode = ?");
            ps.setString(1, p.getCode());
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println("This product code already exists: " + p.getCode());
            }
            else
            {
                String insertProduct =
                    "INSERT INTO Products (ProductCode, Description, Price) " +
                    "VALUES (?, ?, ?)";
                PreparedStatement ps2 = connection.prepareStatement(insertProduct);
                ps2.setString(1, p.getCode());
                ps2.setString(2, p.getDescription());
                ps2.setDouble(3, p.getPrice());
                ps2.executeUpdate();
                ps2.close();

                printProduct(p);
            }
            System.out.println();

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    private static void deleteProduct(Product p)
    {
        try
        {
            System.out.println("Delete test: ");

            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM Products WHERE ProductCode = ?");
            ps.setString(1, p.getCode());
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                String deleteProduct =
                    "DELETE FROM Products " +
                    "WHERE ProductCode = ?";
                PreparedStatement ps2 = connection.prepareStatement(deleteProduct);
                ps2.setString(1, p.getCode());
                ps2.executeUpdate();
                ps2.close();
                printProduct(p);
            }
            else
            {
                System.out.println("No record matches this product code: " + p.getCode());
            }
            System.out.println();

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    // prints a Product object on a single line
    private static void printProduct(Product p)
    {
        String productString =
            StringUtils.padWithSpaces(p.getCode(), 8) +
            StringUtils.padWithSpaces(p.getDescription(), 44) +
            p.getFormattedPrice();

        System.out.println(productString);
    }
}