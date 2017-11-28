
/**
 * *********************************************************************
 *
 * File: Employee.java
 *
 * Author: Joshua Wiley
 *
 * Purpose: Models Employee
 *
 * Date: 5-4-15
 *
 * Comments: Added two helper methods so all sub-classes can use them.
 *
 **********************************************************************
 */
public class Employee
{
    /**
     * * Class Constants **
     */

    public static final int SSN_SIZE = 9;
    private static final String DEFAULT_SSN = "999999999";
    private static final String DEFAULT_EMPLOYEE_NAME = "NO NAME GIVEN";

    /**
     * * Instance Variables **
     */
    private String SSN;
    private String employeeName;

    /**
     * ************************************
     */
    //           Constructors
    /**
     * ************************************
     */
    public Employee()
    {
        this.SSN = DEFAULT_SSN;
        this.employeeName = DEFAULT_EMPLOYEE_NAME;
    }

    public Employee( String socSecNum )
    {
        this.setEmployeeSSN(socSecNum);
        this.setEmployeeName("");
    }

    public Employee( String socSecNum, String name )
    {
        this.setEmployeeSSN(socSecNum);
        this.setEmployeeName(name);
    }

    /**
     * ************************************
     */
    //    Transformers or Mutators
    /**
     * ************************************
     */
    public void setEmployeeSSN( String socSecNum )
    {
        if (isValidSSN(socSecNum))
        {
            SSN = socSecNum;
        }

        else
        {
            SSN = DEFAULT_SSN;
        }
    }

    public void setEmployeeName( String name )
    {
        /**
         * * check validity of name and set accordingly **
         */

        if (name.length() > 0)
        {
            employeeName = name;
        }

        else
        {
            employeeName = DEFAULT_EMPLOYEE_NAME;
        }
    }

    /**
     * ************************************
     */
    //        Accessors
    /**
     * ************************************
     */
    public String getEmployeeSSN()
    {
        return SSN;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    @Override
    public String toString()
    {
        return " Employee --> SSN: " + this.getEmployeeSSN()
                        + "  Name: " + this.getEmployeeName();
    }

    public double calculateWeeklyPay()
    {
        //this returns 0 because it MUST be overridden in subclasses of Employee
        // Company has some employees who volunteer, thus they get no pay

        return 0;
    }

    public boolean equals( Employee e )
    {
        boolean equalsStatus = false;
        // if SSNs are equal, then Employees are equal

        if (SSN.equals(e.getEmployeeSSN()))
        {
            equalsStatus = true;
        }

        //else return false
        return equalsStatus;
    }

    /**
     * ************************************
     */
    //        Helper Methods
    /**
     * ************************************
     */
    public static boolean isValidSSN( String socSecNum )
    {
        /**
         * * check validity of SSN **
         */

        boolean validSSN = true;
        int counter = 0;

        if (socSecNum.length() == SSN_SIZE)     // correct size
        {				// loop to check that all are digits
            while (validSSN && counter < socSecNum.length())
            {
                if (!Character.isDigit(socSecNum.charAt(counter)))
                {
                    validSSN = false;			// didn't find a digit
                }
                counter++;
            }
        }
        else				//not valid - incorrect size
        {
            validSSN = false;
        }

        return validSSN;
    }

    public static boolean validRange( double value,
                    double minValue,
                    double maxValue )
    {
        /**
         * * Local Variable **
         */

        boolean status = false;

        /**
         * * Checks if value is in range **
         */
        if (value >= minValue && value <= maxValue)
        {
            status = true;
        }

        return status;
    }

    public static double twoDecimalPlaces( double decimalNumber )
    {
        /**
         * * Local Variable **
         */

        double returnDouble;
        //rounds to 2 decimal places
        returnDouble = (double) Math.round(decimalNumber * 100) / 100.0;

        return returnDouble;
    }

    public static void main( String args[] )
    {
        /**
         * * Testing Object **
         */

        Employee test = new Employee();
        Employee test1 = new Employee("102002003");
        Employee test2 = new Employee("102002003", "Jane Doe");

        System.out.println("\n" + test.toString());
        System.out.println(" Weekly Pay Check: $"
                        + test.calculateWeeklyPay() + "\n");
        System.out.println(test1.toString());
        System.out.println(" Weekly Pay Check: $"
                        + test1.calculateWeeklyPay() + "\n");
        System.out.println(test2.toString());
        System.out.println(" Weekly Pay Check: $"
                        + test2.calculateWeeklyPay() + "\n");
    }
}
