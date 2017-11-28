import java.util.*;
import java.sql.*;

public class ProductDB implements ProductDAO
{
    private Connection connect()
    {
        Connection connection = null;
        try
        {
            String url = "jdbc:odbc:MurachDB";
            String user = "Admin";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e)
        {
            System.err.println("Error loading database driver: " + e);
        }
        return connection;
    }

    public ArrayList<Product> getProducts()
    {
        try
        {
            Connection connection = connect();
            ArrayList<Product> products = new ArrayList<Product>();

            String query = "SELECT ProductCode, Description, Price "
                         + "FROM Products ORDER BY ProductCode ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                Product p = new Product(code, description, price);
                products.add(p);
            }
            rs.close();
            ps.close();
            connection.close();
            return products;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();  // for debugging
            return null;
        }
    }
    public void listProducts()
    {
    try
        {
            Connection connection = connect();

            String query = "SELECT ProductCode, Description, Price "
                         + "FROM Products ORDER BY ProductCode ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("PRODUCT LIST");
            while(rs.next())
            {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                Product p = new Product(code, description, price);
                 StringBuilder sb = new StringBuilder();
                sb.append
                (
                    StringUtils.padWithSpaces(
                        p.getCode(), CODE_SIZE + 4) +
                    StringUtils.padWithSpaces(
                        p.getDescription(), DESCRIPTION_SIZE + 4) +
                    p.getFormattedPrice()
                );
                System.out.println(sb.toString());
            }
            System.out.println();
            rs.close();
            ps.close();
            connection.close();
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();  // for debugging
        }
    }

    public Product getProduct(String code)
    {
        try
        {
            Connection connection = connect();
            String selectProduct =
                "SELECT ProductCode, Description, Price " +
                "FROM Products " +
                "WHERE ProductCode = ?";
            PreparedStatement ps = connection.prepareStatement(selectProduct);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);
                rs.close();
                ps.close();
                connection.close();
                return p;
            }
            else
                return null;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();   // for debugging
            return null;
        }
    }

    public boolean addProduct(Product p)
    {
        try
        {
            Connection connection = connect();
            String insert =
                "INSERT INTO Products (ProductCode, Description, Price) " +
                "VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();   // for debugging
            return false;
        }
    }

    public boolean deleteProduct(Product p)
    {
        try
        {
            Connection connection = connect();
            String delete =
                "DELETE FROM Products " +
                "WHERE ProductCode = ?";
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setString(1, p.getCode());
            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();   // for debugging
            return false;
        }
    }

    public boolean updateProduct(Product p)
    {
        try
        {
            Connection connection = connect();
            String update =
                "UPDATE Products SET " +
                    "Description = ?, " +
                    "Price = ? " +
                "WHERE ProductCode = ?";
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, p.getDescription());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCode());
            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();   // for debugging
            return false;
        }
    }
}