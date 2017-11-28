/*********************************************************************
*
*  File: Employee.java
*
*  Purpose: Define the Employee Superclass for workers in a company
*
*  Comments:
*     For CPS 245 Spring 2007 Lab 13
*     Using inheritance & polymorphism
*
*********************************************************************/

public abstract class Employee
{
	/***************************************/
	//        Instance Variables
	/***************************************/

	private String 	            SSN;
	private String 	            employeeName;
	public static final int     SSN_SIZE = 9;
	private static final String DEFAULT_SSN           = "999999999";
	private static final String DEFAULT_EMPLOYEE_NAME = "NO NAME GIVEN";

	/***************************************/
	//           Constructors
	/***************************************/

	public Employee()
	{
		this.SSN = DEFAULT_SSN;
		this.employeeName = DEFAULT_EMPLOYEE_NAME;
	}

	public Employee( String socSecNum )
	{
		this.setEmployeeSSN( socSecNum );
		this.setEmployeeName( "" );
	}

	public Employee( String socSecNum, String name )
	{
		this.setEmployeeSSN(socSecNum);
		this.setEmployeeName(name);
	}

	/***************************************/
	//    Transformers or Mutators
	/***************************************/

	public void setEmployeeSSN( String socSecNum )
	{
		if ( isValidSSN( socSecNum ) )
			SSN = socSecNum;

		else
			SSN = DEFAULT_SSN;
    }


	public void setEmployeeName( String name )
	{
		/*** check validity of name and set accordingly  ***/

		if (name.length()>0)
			employeeName = name;

		else
			employeeName = DEFAULT_EMPLOYEE_NAME;
	}

	/***************************************/
	//        Accessors
	/***************************************/

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
		final String FORMAT_STRING0 = "%n%24s %s %n";
		final String FORMAT_STRING1 = "%24s %10s %n";
		final String FORMAT_STRING2 = "%24s $%,9.2f %n";

		String returnString = "";

		returnString += String.format( FORMAT_STRING0, "Employee --> SSN:", this.getEmployeeSSN() );
		returnString += String.format( FORMAT_STRING1, "Name:", this.getEmployeeName() );
		returnString += String.format( FORMAT_STRING2, "Weekly Check:", this.calculateWeeklyPay() );

		return returnString;
	}

	public abstract double calculateWeeklyPay();

	public boolean equals( Employee e )
	{
		// if SSNs are equal, then Employees are equal

		if ( SSN.equals( e.getEmployeeSSN() ) )
			return true;

		else
			return false;
	}

	/***************************************/
	//        Helper Methods
	// Can be called by class or client code
	/***************************************/

 	public static boolean isValidSSN( String socSecNum )
	{
		//*** check validity of SSN ***

		boolean validSSN = true;
		int counter = 0;

		if (socSecNum.length() == SSN_SIZE)     // correct size
		{				// loop to check that all are digits
			while ( validSSN && counter<socSecNum.length() )
			{
				if ( !Character.isDigit(socSecNum.charAt( counter ) ) )
					validSSN = false;			// didn't find a digit
				counter++;
			}
		}

		else				//not valid - incorrect size
			validSSN = false;

        return validSSN;
	}

	public static void main( String args[] )
	{
		/*** Testing Object ***/

		//Employee test = new Employee();
		//System.out.println( test.toString() );
	}
}