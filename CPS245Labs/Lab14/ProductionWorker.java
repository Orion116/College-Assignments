/*********************************************************************
*
*  File: ProductionWorker.java
*
*  Author: Joshua Wiley
*
*  Date: 5-11-15
*
*  Purpose: Models a production worker
*
*  Comments:
*
*********************************************************************/

public class ProductionWorker extends Employee
{
	/*** Class Constants ***/

	private final double NIGHT_SHIFT_BONUS = 1.00;

	private final double MINIMUM_WAGE        = 7.25;
	private final double DEFAULT_HOURLY_RATE = MINIMUM_WAGE;
	public final double MINIMUM_HOURLY_RATE = MINIMUM_WAGE;
	public final double MAXIMUM_HOURLY_RATE = 30.00;

	public final double MINIMUM_HOURS	   = 8.0;
	public final double MAXIMUM_HOURS	   = 96.0;

	/*** Class Variables ***/

	private double hourlyRate   = DEFAULT_HOURLY_RATE;
	private double hours        = NORMAL_WEEK_HOURS;
	private int shift           = SHIFT_DAY;

	/*** Constructors ***/

	public ProductionWorker( String socSecNum,
							 String name )
	{
		super( socSecNum, name );  //Sents info the super class

		this.hourlyRate = DEFAULT_HOURLY_RATE;
		this.hours      = NORMAL_WEEK_HOURS;
		this.shift      = SHIFT_DAY;
	}

	public ProductionWorker( String socSecNum,
							 String name,
							 double hourlyRate,
							 double hours,
							 int shift)
	{
		super( socSecNum, name );  //Sents info the super class

		this.setHourlyRate( hourlyRate );
		this.setHours( hours );
		this.setShift( shift );
	}

	/*** Setters ***/

	public void setHourlyRate( double hourlyRate )
	{
		if ( validRange( hourlyRate, MINIMUM_HOURLY_RATE,
								     MAXIMUM_HOURLY_RATE ) )
			this.hourlyRate = hourlyRate;
	}

	public void setHours( double hours )
	{
		if ( validRange( hours, MINIMUM_HOURS,
								MAXIMUM_HOURS ) )
		    this.hours = hours;
	}

	public void setShift( int shift )
	{
		if ( validShift( shift ) )
		    this.shift = shift;
	}

	/*** Accessors ***/

	public double getHourlyRate()
	{
		return this.hourlyRate;
	}

	public double getHours()
	{
		return this.hours;
	}

	public int getShift()
	{
		return this.shift;
	}

	@Override
	public String toString()
	{
		return super.toString() +
		"\n Hours Worked: " + this.getHours() +
		" Pay Rate: $" + this.getHourlyRate() +
		" Shift: " + this.dayOrNight( this.getShift() );
	}

	/*** Helper Methods ***/

	@Override  //Override method of the super class
	public double calculateWeeklyPay()
	{
		double pay = 0.0;  // Company has some employees who volunteer, thus they get no pay

		if ( this.getShift() == SHIFT_NIGHT && this.getHourlyRate() > 0 )
		{
			pay += this.NIGHT_SHIFT_BONUS * this.getHours();
		}
		if ( this.getHours() > NORMAL_WEEK_HOURS )
		{
			pay += this.getHourlyRate() * NORMAL_WEEK_HOURS +
					   ( this.getHours() - NORMAL_WEEK_HOURS ) *
					   this.getHourlyRate() * 1.5; //normal pay plus overtime
		}
		else
		{
			pay += this.getHours() * this.getHourlyRate();
		}

		pay = twoDecimalPlaces( pay ); //rounds to 2 decimal places

		return pay;
	}

			//Helper method to say what shift was worked
	private String dayOrNight( int shift )
	{
		String returnString = "";

		if ( shift == SHIFT_DAY )
			returnString = "Day";
		else if ( shift == SHIFT_NIGHT )
			returnString = "Night";

		return returnString;
	}

	private boolean validShift( int shift )
	{
		/*** Local Variable ***/

		boolean status = false;

		if ( shift == SHIFT_DAY || shift == SHIFT_NIGHT )
			status = true;

		return status;
	}

	/*** Application ***/

	public static void main( String args[] )
	{
		/*** Day workers ***/

		ProductionWorker defaultWorker = new ProductionWorker( "9300909903",
														       "Jane Doe" );
		ProductionWorker dayWorker = new ProductionWorker( "9300909903",
														   "Jane Doe",
														   8.00, 50, 1 );
		/*** Night Workers ***/

		ProductionWorker nightWorker = new ProductionWorker( "9300909903",
														     "Jane Doe",
														     40, 0, 2 );
		ProductionWorker nightWorker2 = new ProductionWorker( "101020385",
														      "John Smith",
														      8.05, 50, 2 );

		System.out.println( "\n    <----------- Default Worker ----------->   " );
		System.out.println( defaultWorker.toString() );
		System.out.println( " Weekly Pay: $" + defaultWorker.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Day Worker --------------->   " );
		System.out.println( dayWorker.toString() );
		System.out.println( " Weekly Pay: $" + dayWorker.calculateWeeklyPay() );


		System.out.println( "\n    <----------- Night Worker ------------->   " );
		System.out.println( nightWorker.toString() );
		System.out.println( " Weekly Pay: $" + nightWorker.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Night Worker2 ------------>   " );
		System.out.println( nightWorker2.toString() );
		System.out.println( " Weekly Pay: $" + nightWorker2.calculateWeeklyPay() );
	}
}