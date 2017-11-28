/***********************************************************************
*
*	File: EmployeePayRoll.java
*
*	Assignment:  EmployeePayRoll
*
*	Description:  EmployeePayRoll comp object
*
*	Author:  Joshua Wiley
*
*	Date:  3-1-15
*
*	Comments:  Calculates over time pay at 1.5 * payRate
*
**********************************************************************/

public class EmployeePayRoll
{
	/*** Class Constants ***/

	public static final String EMPLOYEE_LAST_NAME = " ";
	public static final double HOURS_WORKED = 0.00;
	public static final double PAY_RATE = 0.00;

    /*** Class Variables ***/

	private String employeeLastName;
	private double hoursWorked;
	private double payRate;

	/*** Constructors ***/

	public EmployeePayRoll()
	{
		this.employeeLastName = EMPLOYEE_LAST_NAME;
		this.hoursWorked = HOURS_WORKED;
		this.payRate = PAY_RATE;
	}

	public EmployeePayRoll( String employeeLastName, double hoursWorked )
	{
		this.employeeLastName = employeeLastName;
		this.hoursWorked = hoursWorked;
		this.payRate = PAY_RATE;
	}

	public EmployeePayRoll( String employeeLastName, double hoursWorked, double payRate )
	{
	    this.employeeLastName = employeeLastName;
		this.hoursWorked = hoursWorked;
		this.payRate = payRate;
	}


	/*** Class Methods -- Accessors ***/

	public String getEmployeeName()
	{
		return this.employeeLastName;
	}

	public double getHoursWorked()
	{
		return this.hoursWorked;
	}

	public double getPayRate()
	{
	   	return  this.payRate;
	}

    /*** Setters ***/

	public void setEmployeeName( String employeeName)
	{
	    this.employeeLastName = employeeName;
	}

	public void setHoursWorked( double hoursWorked)
	{
		 this.hoursWorked = hoursWorked;
	}

	public void setPayRate( double payRate )
	{
	   this.payRate = payRate;
	}

	@Override

	public String toString()
	{
	    /*** Local Constants ***/
	    final String FORMAT_STRING1 = "%24s %10s %n";
		final String FORMAT_STRING2 = "%24s %10.2f %n";
	    final String FORMAT_STRING3 = "%24s $%,9.2f %n";

		/*** Local Variables ***/
	    String returnString = "";

		returnString += String.format( FORMAT_STRING1, "Employee Name:", this.getEmployeeName() );
		returnString += String.format( FORMAT_STRING2, "Hours Worked:", this.getHoursWorked() );
		returnString += String.format( FORMAT_STRING3, "Pay Rate:", this.getPayRate() );

		return returnString;
	}

	/*** Mutators/transformers ***/

	public double calculateGrossPay()
	{
	    /*** Local Variables ***/

	    double grossPay = 0;

		/*** Calculates gross pay and over time if needed ***/

		if ( this.getHoursWorked() > 40 )
		{
			grossPay = this.getPayRate() * 40 + ( this.getHoursWorked() - 40 ) * this.getPayRate() * 1.5; //normal pay plus overtime
		}
		else
		{
			grossPay = this.getHoursWorked() * this.getPayRate();
		}

		return grossPay;
	}


	/*** Application ***/

	public static void main( String[] args )
	{
	    /*** Local Constants ***/
	    final String FORMAT_STRING = "%24s $%,9.2f %n";

	    /*** Local Variable ***/
		String testString = "Smith" ; //

		/*** Instantiate objects ***/
        EmployeePayRoll payRoll1 = new EmployeePayRoll();
		EmployeePayRoll payRoll2 = new EmployeePayRoll( testString, 50.00 );
		EmployeePayRoll payRoll3 = new EmployeePayRoll( testString, 60.00, 15.00);

		/*** Prints Test objects ***/

        System.out.println( "\n---------------- Testing Objects ----------------\n" );
		System.out.println( "  Default: \n\n" + payRoll1.toString() );
		System.out.printf( FORMAT_STRING, "Gross pay:", payRoll1.calculateGrossPay() );

		System.out.println( "\n  Name and hours:\n\n" + payRoll2.toString() );
		System.out.printf( FORMAT_STRING, "Gross pay:", payRoll2.calculateGrossPay() );

		System.out.println( "\n" + payRoll3.toString() );
        System.out.printf( FORMAT_STRING, "Gross pay:", payRoll3.calculateGrossPay() );
	}
}