/*********************************************************************
*
*  File: ProductionWorker.java
*
*  Author: Joshua Wiley
*
*  Date: 4-26-15
*
*  Purpose: A production worker Subclass for Employee workers in a company
*
*  Comments:
*
*********************************************************************/

public class ProductionWorker extends Employee
{
	/*** Class Constants ***/

	private final int SHIFT             = 1;
	private final double HOURLY_RATE    = 8.00;
	private final double HOURS		    = 40.0;
	private final int NIGHT_SHIFT_BONUS = 1;
	private final double MAX_RATE		= 300.00;
	private final double MAX_HOURS		= 80.0;

	private int shift           = SHIFT;
	private double hourlyRate   = HOURLY_RATE;
	private double hours        = HOURS;

	public ProductionWorker()
	{
		super();  //Calls the super class

		this.shift      = SHIFT;
		this.hourlyRate = HOURLY_RATE;
		this.hours      = HOURS;
	}

	public ProductionWorker( int shift,
							 double hourlyRate,
							 double hours )
	{
		super();  //Calls the super class

		setShift( shift );
		setHourlyRate( hourlyRate );
		setHours( hours );
	}

	public ProductionWorker( String socSecNum,
							 String name,
							 int shift,
							 double hourlyRate,
							 double hours )
	{
		super( socSecNum, name );  //Sents info the super class

		setShift( shift );
		setHourlyRate( hourlyRate );
		setHours( hours );
	}

	/*** Setters ***/

	public void setShift( int shift )
	{
		if ( validShift( shift ) )
		    this.shift = shift;
	}

	public void setHourlyRate( double hourlyRate )
	{
		if ( validRate( hourlyRate ) )
			this.hourlyRate = hourlyRate;
	}

	public void setHours( double hours )
	{
		if ( validHours( hours ) )
		    this.hours = hours;
	}

	/*** accessors ***/

	public int getShift()
	{
		return this.shift;
	}

	public double getHourlyRate()
	{
		return this.hourlyRate;
	}

	public double getHours()
	{
		return this.hours;
	}

	@Override

	public String toString()
	{
	    /*** Local Constants ***/

		final String FORMAT_STRING0 = "%s %s";
	    final String FORMAT_STRING1 = "%24s %10s %n";
		final String FORMAT_STRING2 = "%24s %10.2f %n";
	    final String FORMAT_STRING3 = "%24s $%,9.2f %n";

		/*** Local Variables ***/

		String returnString = "";

		returnString += String.format( FORMAT_STRING0, "", super.toString() );
		returnString += String.format( FORMAT_STRING1, "Shift:", dayOrNight( this.getShift() ) );
		returnString += String.format( FORMAT_STRING2, "Hours Worked:", this.getHours() );
		returnString += String.format( FORMAT_STRING3, "Pay Rate:", this.getHourlyRate() );

		return returnString;
	}

	@Override  //Override method of the super class
	public double calculateWeeklyPay()
	{
		double pay = 0.0;  // Company has some employees who volunteer, thus they get no pay

		if ( this.getShift() == 2 && this.getHourlyRate() > 0 )
		{
			pay += this.NIGHT_SHIFT_BONUS * this.getHours();
		}
		if ( this.getHours() > 40 )
		{
			pay += this.getHourlyRate() * 40 +
					   ( this.getHours() - 40 ) *
					   this.getHourlyRate() * 1.5; //normal pay plus overtime
		}
		else
		{
			pay = this.getHours() * this.getHourlyRate();
		}

		return pay;
	}

	/*** Helper Methods ***/

			//Helper method to say what shift was worked
	private String dayOrNight( int shift )
	{
		String returnString = "";

		if ( shift == 1 )
			returnString = "Day Shift";
		else if ( shift == 2 )
			returnString = "Night Shift";

		return returnString;
	}

	private boolean validShift( int shift )
	{
		/*** Local Variable ***/

		boolean status = false;

		if ( shift == 1 || shift == 2 )
			status = true;

		return status;
	}

	private boolean validRate( Double hourlyRate )
	{
		/*** Local Variable ***/

		boolean status = false;

		if ( hourlyRate >= 0 && hourlyRate <= MAX_RATE )
			status = true;

		return status;
	}

	private boolean validHours( Double hours )
	{
		/*** Local Variable ***/

		boolean status = false;

		if ( hours >= 0 && hours <= MAX_HOURS )
			status = true;

		return status;
	}

	/*** Application ***/

	public static void main( String args[] )
	{
		/*** Day workers ***/

		ProductionWorker defaultWorker = new ProductionWorker();
		ProductionWorker dayWorker = new ProductionWorker( "9300909903",
														   "Jane Doe",
														    1, 8.00, 50 );
		/*** Night Workers ***/

		ProductionWorker nightWorker = new ProductionWorker( 2, 0, 40 );
		ProductionWorker nightWorker2 = new ProductionWorker( "101020385",
														      "John Smith",
														       2, 8.00, 50 );

		System.out.println( "\n    <----------- Default Worker ----------->   " );
		System.out.println( defaultWorker.toString() );

		System.out.println( "\n    <----------- Day Worker --------------->   " );
		System.out.println( dayWorker.toString() );

		System.out.println( "\n    <----------- Night Worker ------------->   " );
		System.out.println( nightWorker.toString() );

		System.out.println( "\n    <----------- Night Worker2 ------------>   " );
		System.out.println( nightWorker2.toString() );
	}
}