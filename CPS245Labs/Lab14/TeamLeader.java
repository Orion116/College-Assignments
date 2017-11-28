/*********************************************************************
*
*  File: TeamLeader.java
*
*  Author: Joshua Wiley
*
*  Date: 5-11-15
*
*  Purpose: Models a Team Leader
*
*  Comments:
*
********************************************************************/

public class TeamLeader extends ProductionWorker
{
	/*** Class Constants ***/

	private final double WEEKLY_BONUS_RATE = 0.05;

	private final double MINIMUM_TRAINING_HOURS	= 0.0;
	private final double MAXIMUM_TRAINING_HOURS	= 40.0;

	/*** Class Variables ***/

	private double trainingHours = MINIMUM_TRAINING_HOURS;

	/*** Constructors ***/

	public TeamLeader( String socSecNum, String name )
	{
		super( socSecNum, name );  //Calls the super class

		this.trainingHours = MINIMUM_TRAINING_HOURS;
	}

	public TeamLeader( String socSecNum,
					   String name,
					   double hourlyRate,
					   double hours,
					   int shift,
					   double trainingHours )
	{
		super( socSecNum, name, hourlyRate, hours, shift );  //Sents info the super class

		this.setTrainingHours( trainingHours );
	}

	/*** Setters ***/

	public void setTrainingHours( double trainingHours )
	{
		if ( validRange( trainingHours, MINIMUM_TRAINING_HOURS, MAXIMUM_TRAINING_HOURS ) )
		    this.trainingHours = trainingHours;
	}

	/*** Accessors ***/

	public double getTrainingHours()
	{
		return this.trainingHours;
	}

	@Override
	public String toString()
	{
		return super.toString() +
		"\n Training Hours: " + this.getTrainingHours();
	}

	/*** Helper Methods ***/

	@Override  //Override method of the super class
	public double calculateWeeklyPay()
	{
		double pay = 0.0;

		pay += super.calculateWeeklyPay();
		pay *= ( 1 + WEEKLY_BONUS_RATE );

		pay = twoDecimalPlaces( pay ); //rounds to 2 decimal places
		return pay;
	}

	/*** Application ***/

	public static void main( String args[] )
	{
		/*** Day workers ***/

		TeamLeader defaultTeamLeader = new TeamLeader( "9371234903",
													   "Joe Doe" );
		TeamLeader dayTeamLeader = new TeamLeader( "9300909903",
												   "Jane Doe",
												   8.00, 50, 1, 5 );
		/*** Night Workers ***/

		TeamLeader nightTeamLeader1 = new TeamLeader( "9300909903",
												      "Jane Smith",
												      0, 40, 2, 3 );
		TeamLeader nightTeamLeader2 = new TeamLeader( "101020385",
												      "John Smith",
												      8.00, 50, 2, 20.0 );

		System.out.println( "\n    <----------- Default Worker ----------->   " );
		System.out.println( defaultTeamLeader.toString() );
		System.out.println( " Weekly Pay With Team Leader Bonus: $" +
		                    defaultTeamLeader.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Day Worker --------------->   " );
		System.out.println( dayTeamLeader.toString() );
		System.out.println( " Weekly Pay With Team Leader Bonus: $" +
							dayTeamLeader.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Night Worker ------------->   " );
		System.out.println( nightTeamLeader1.toString() );
		System.out.println( " Weekly Pay With Team Leader Bonus: $" +
							nightTeamLeader1.calculateWeeklyPay() );

		System.out.println( "\n    <----------- Night Worker2 ------------>   " );
		System.out.println( nightTeamLeader2.toString() );
		System.out.println( " Weekly Pay With Team Leader Bonus: $" +
							nightTeamLeader2.calculateWeeklyPay() + "\n");
	}
}