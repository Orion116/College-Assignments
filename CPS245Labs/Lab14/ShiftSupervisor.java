/*********************************************************************
*
*  File: ShiftSupervisor.java
*
*  Author: Joshua Wiley
*
*  Date: 5-11-15
*
*  Purpose: Models Shift Supervisor worker
*
*  Comments:
*
*********************************************************************/

public class ShiftSupervisor extends Employee
{
	/*** Class Constants ***/
									//Government agencies can use decimal places
	private final double WORK_WEEKS_IN_A_YEAR = 52.0;

	private final double MINIMUM_ANNUAL_SALARY = 32000.00;
	private final double DEFAULT_ANNUAL_SALARY = MINIMUM_ANNUAL_SALARY;
								//Depending Factory size a supervisor can make this
	private final double MAXIMUM_ANNUAL_SALARY = 100000.00;
								//Can be zero if didn't reach production goals
	private final double ANNUAL_PRODUCTION_BONUS = 0.0;
	private final double MINIMUM_ANNUAL_BONUS = ANNUAL_PRODUCTION_BONUS;
	private final double MAXIMUM_ANNUAL_BONUS = 8000.00;

	/*** Class Variables ***/

	private double annualSalary 		 = DEFAULT_ANNUAL_SALARY;
	private double annualProductionBonus = MINIMUM_ANNUAL_BONUS;

	/*** Constructors ***/

	public ShiftSupervisor( String socSecNum,
							String name )
	{
		super( socSecNum, name );  //Sents info the super class
		this.annualSalary 		   = DEFAULT_ANNUAL_SALARY;
		this.annualProductionBonus = MINIMUM_ANNUAL_BONUS;
	}

	public ShiftSupervisor( String socSecNum,
							String name,
							double annualSalary,
							double annualProductionBonus )
	{
		super( socSecNum, name );  //Sents info the super class

		this.setAnnualSalary( annualSalary );
		this.setAnnualProductionBonus( annualProductionBonus );
	}

	/*** Setters ***/

	public void setAnnualSalary( double annualSalary )
	{
		if ( validRange( annualSalary,
						 MINIMUM_ANNUAL_SALARY,
		                 MAXIMUM_ANNUAL_SALARY ) )

			this.annualSalary = annualSalary;
		//else leave default
	}

	public void setAnnualProductionBonus( double annualProductionBonus )
	{
		if ( validRange( annualProductionBonus,
						 MINIMUM_ANNUAL_BONUS,
						 MAXIMUM_ANNUAL_BONUS  ) )
		    this.annualProductionBonus = annualProductionBonus;
		//else leave default
	}

	/*** Accessors ***/

	public double getAnnualSalary()
	{
		return this.annualSalary;
	}

	public double getAnnualProductionBonus()
	{
		return this.annualProductionBonus;
	}

	@Override
	public String toString()
	{
		return super.toString() +
		"\n Annual Salary: $" + this.getAnnualSalary() +
		" Annual Production Bonus: $" + this.getAnnualProductionBonus();
	}

	/*** Helper Methods ***/

	@Override  //Override method of the super class
	public double calculateWeeklyPay()
	{
		double pay = 0.0;

		pay += ( this.getAnnualSalary() + this.getAnnualProductionBonus() ) / WORK_WEEKS_IN_A_YEAR;

		/**********************************************************
		*
		* Assume annual production bonus is minimum i.e. 0 if not
		* to be paid and otherwise is a value that will be paid evenly
		* over the year.
		*
		***********************************************************/

		pay = twoDecimalPlaces( pay ); //rounds to 2 decimal places

		return pay;
	}

	/*** Application ***/

	public static void main( String args[] )
	{
		/*** Day workers ***/

		ShiftSupervisor defaultSupervisor = new ShiftSupervisor( "9300909903",
														         "Jane Doe" );
		ShiftSupervisor Supervisor1 = new ShiftSupervisor( "9300909903",
														   "Jane Doe",
														   50000.00, 800 );
		ShiftSupervisor Supervisor2 = new ShiftSupervisor( "101020385",
														   "John Smith",
														   20000.00, 0.0 );

		System.out.println( "\n    <----------- Default Worker ----------->" );
		System.out.println( defaultSupervisor.toString() );
		System.out.println( " Weekly Pay: $" + defaultSupervisor.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Supervisor w/t Bonus --------------->" );
		System.out.println( Supervisor1.toString() );
		System.out.println( " Weekly Pay: $" + Supervisor1.calculateWeeklyPay() );

		System.out.println(
			"\n    <----------- Supervisor annual salary = $20000 and w/o Bonus ------------->" );
		System.out.println( Supervisor2.toString() );
		System.out.println( " Weekly Pay: $" + Supervisor2.calculateWeeklyPay() + "\n" );
	}
}
