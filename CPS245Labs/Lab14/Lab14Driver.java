/*********************************************************************
*
*  File: Lab14Driver.java
*
*  Author:  Joshua Wiley
*
*  Date:    5-11-15
*
*  Purpose: Tester object for Employee
*
*  Comments:
*
*********************************************************************/

import java.util.*;

public class Lab14Driver extends Employee
{
	/*** Class Constants ***/

	private final int MAX_EMPLOYEES       = 8;
	private final int DISPLAY_WITHOUT_PAY = 1;
	private final int DISPLAY_WITH_PAY    = 2;
	private final int VOL_EMPLOYEE_ID     = 0;
	private final int PRODUCTION_WORK_ID  = 1;
	private final int SHIFT_SUPERVISOR_ID = 2;
	private final int TEAM_LEADER_ID      = 3;

    /*** Class test Method ***/

	private void startEmployeeTester()
	{
		/*** Instantiate an Array of Objects ***/

	    Employee employee[] = new Employee[MAX_EMPLOYEES];
	    employee = initializeEmployees( employee );
	    executeMenu( employee );
	}

	/*** Initializes Array to null ***/

	private Employee[] initializeEmployees( Employee employee[] )
	{
		for ( int i = 0; i < employee.length; i++ )
			employee[ i ] = null;

		return employee;
	}

	/*** Display Methods ***/

	private void displayStateOFEmployee( Employee employee[] )
	{
		/*** Loops through all the employees ***/

		System.out.println( "\n\n----------Currently Hired Employees----------" );

	    for ( int i = 0; i < employee.length; i++ )
	  	{
			/*** Checks for non-initialized employee ***/

	  		if ( employee[i] != null )
	  		{
	  			System.out.println( "\n ----------- Employee " +
	  				   ( i + 1 ) + " ----------\n" );
	  			this.displayEmployeeInfo( employee[i] );
	  		}

	  		//Else ignore the employee
		}
	}

	private void displayEmployeeInfo( Employee employee )
	{
					//Prints the state of the employee
		System.out.println( employee.toString() );

		System.out.println( " Weekly Pay Check: $" +
		 					calculatePay( employee ) +
		 			        "\n");
	}

	/*** Hire initialized employees ***/

	private void hireEmployees( Employee employee[] )
	{
		/*** Loops through the array ***/

		for ( int id = 0; id < MAX_EMPLOYEES; id++ )
		{
			/*** Checks for non-initialized employee ***/

			if ( employee[id] != null )
				employee[id] = this.getEmployeeInformation( id );

			//Else ignore the employee
		}
	}

	/*** Get Info for Employee Types ***/

	private Employee getEmployeeInformation( int id )
	{
		Employee employee = new Employee();

		if ( id == VOL_EMPLOYEE_ID )
		{
   			System.out.println( "\n\n----------Hiring Employee (Non-paid Volunteer)----------" );
			employee = this.getEmployeeData();
		}
		else if ( id == PRODUCTION_WORK_ID )
		{
	        System.out.println( "\n\n----------Hiring Production Worker----------" );
			employee = getProductionWorker();
		}
		else if ( id == SHIFT_SUPERVISOR_ID )
		{
    		System.out.println( "\n\n----------Hiring Shift Supervisor----------" );
			employee = getShiftSupervisor();
		}
		else if ( id == TEAM_LEADER_ID )
		{
			System.out.println( "\n\n----------Hiring Team Leader----------" );
			employee = getTeamLeader();
		}

		return employee;
	}

	/*** Get Employee Type Information ***/

	private Employee getEmployeeData()
	{
			//Creates a new employee
		Employee employee = new Employee();

        /*** Receives User Input ***/

		employee.setEmployeeSSN( userStringValue( "Enter SSN:" ) );
	    employee.setEmployeeName( userStringValue( "Enter Employee Name:" ) );

	    return employee;
	}

	/*** Get ProductionWorker Type Information ***/

	private ProductionWorker getProductionWorker()
	{
		/*** Creates a Temporary Employee ***/

		Employee tempEmployee = new Employee();
		tempEmployee = this.getEmployeeData();

		/*** Local Variables ***/

		double payRate = 0.0;
		double hours   = 0.0;
		int    shift   = SHIFT_DAY;

		payRate = userDoubleValue( "Enter Pay Rate:" );  //Gets user input
		hours = userDoubleValue( "Enter Hours Worked:" );  //Gets user input
		shift = (int)userDoubleValue( "Enter Shift (1: day or 2: night):" );

	    ProductionWorker worker = new ProductionWorker( tempEmployee.getEmployeeSSN(),
									   					tempEmployee.getEmployeeName(),
									   					payRate, hours, shift );
		return worker;
	}

	/*** Get ShiftSupervisor Type Information ***/

	private ShiftSupervisor getShiftSupervisor()
	{
		/*** Creates a Temporary Employee ***/

		Employee tempEmployee = new Employee();
		tempEmployee = this.getEmployeeData();

		/*** Local Variables ***/

		double annualSalary;
		double annualBonus;

		annualSalary = userDoubleValue( "Enter Annual Salary:" );  //Gets user input
		annualBonus = userDoubleValue( "Enter Annual Bonus:" );  //Gets user input

	    ShiftSupervisor worker = new ShiftSupervisor( tempEmployee.getEmployeeSSN(),
	    						   					  tempEmployee.getEmployeeName(),
	    						   					  annualSalary, annualBonus );
		return worker;
	}

	/*** Get TeamLeader Type Information ***/

	private TeamLeader getTeamLeader()
	{
		/*** Creates a Temporary Employee ***/

		ProductionWorker tempEmployee = new ProductionWorker( "9300909903",
														      "Jane Doe" );
		tempEmployee = this.getProductionWorker();

		/*** Local Variables ***/

		double trainingHours;

		trainingHours = userDoubleValue( "Enter Training Hours:" );  //Gets user input

	    TeamLeader worker = new TeamLeader( tempEmployee.getEmployeeSSN(),
	    						            tempEmployee.getEmployeeName(),
	    						   			tempEmployee.getHourlyRate(),
	    						   			tempEmployee.getHours(),
	    						   			tempEmployee.getShift(),
	    						   			trainingHours );
		return worker;
	}

	/*** Creates Employee of User Selected Type ***/

	private Employee getNewHire( Employee employee[], int menuOption )
	{
		/*** Creates a New Employee ***/

		Employee newEmployee = new Employee();

		/*** Instantiates Employee type ***/

		if ( menuOption == VOL_EMPLOYEE_ID )
			newEmployee = new Employee();

		else if ( menuOption == PRODUCTION_WORK_ID )
			newEmployee = new ProductionWorker( "9300909903", "Jane Doe");

		else if ( menuOption == SHIFT_SUPERVISOR_ID )
			newEmployee = new ShiftSupervisor( "9300909903", "Jane Doe");

		else if ( menuOption == TEAM_LEADER_ID )
			newEmployee = new TeamLeader( "9300909903", "Jane Doe" );

		/*** Gets New Hire Information ***/

		newEmployee = this.getEmployeeInformation( menuOption );

		/*** Checks for Existing Employee ***/

		if ( existingEmployee( employee, newEmployee ) )
		{
			newEmployee = null;
		}

		return newEmployee;
	}

	private void executeMenu( Employee employee[] )
	{
		/*** Local Constants ***/

		final int DISPLAY_OPTION = 4;
		final int EXIT_OPTION    = 5;

		/*** Local Variables ***/

		int i = 0;
		int menuOption = VOL_EMPLOYEE_ID;

		do
		{			//Displays menu options
			this.displayEmployeeTypeMenu();
							//Gets user input
			menuOption = (int)this.userDoubleValue( "Enter Menu Option:" );

			/*** Validates Menu Options ***/

			if ( validRange( menuOption, 1, 6 ) )
			{
				menuOption -= 1;

				if ( menuOption == DISPLAY_OPTION )
				{
										//Display state with pay
					this.displayStateOFEmployee( employee );
				}
				else if ( menuOption != EXIT_OPTION)
				{
					i = 0;

					while( i < employee.length && employee[i] != null )
						i++;

					if ( i < employee.length )
					{
						employee[ i ] = this.getNewHire( employee, menuOption );
					}
					else
					{
						this.printMaximumEmployee();
					}
				}
			}
			else
				menuOption = -1;

		}while( menuOption != EXIT_OPTION );
	}

	/*** Helper Method ***/

	private String userStringValue( String id )
	{
		/*** Local Variables ***/

		Scanner input = new Scanner( System.in );
		String userInput = "invalid";
		String FormatString = "%n %24s ";

	    /*** Receives User Input & Prints the question ***/

		System.out.printf( FormatString, id );
		userInput = input.nextLine();

	    return userInput;
	}

	private double userDoubleValue( String id )
	{
		/*** Local Variables ***/

		double inputValue = 0.0;
		String inputString = "";
		String FormatString = "%n %24s ";

		/*** Gets input as a string to allow enter to next prompt ***/

		inputString = userStringValue( id );  //Gets user input

		/*** Try/Catch for parsing errors ***/

		try
		{
			inputValue = Double.parseDouble( inputString );
		}
		catch( NumberFormatException exc )
		{
			//returns default
		}

		return inputValue;
	}

	private double calculatePay( Employee employee )
	{
		/*** Local Variables ***/

		double pay = 0.0;

		/*** Calls an employee type class calculateWeeklyPay ***/

		pay = employee.calculateWeeklyPay();

		return pay;
	}

	private void displayEmployeeTypeMenu()
	{
		/*** Local Constants ***/

		final String FORMAT_STRING  = "%n    %-50s ";

		/*** Prints Menu ***/

		System.out.printf( FORMAT_STRING, "   Hire Employee or Display All Employees:" );
		System.out.printf( FORMAT_STRING, "   ---------------------------------------" );
		System.out.printf( FORMAT_STRING, "1. Employee (Non-paid Volunteer)" );
		System.out.printf( FORMAT_STRING, "2. Production Worker" );
		System.out.printf( FORMAT_STRING, "3. Shift Supervisor" );
		System.out.printf( FORMAT_STRING, "4. Team Leader" );
		System.out.printf( FORMAT_STRING, "5. Display All Employee's Information" );
		System.out.printf( FORMAT_STRING, "6. Exit" );
		System.out.println();
	}

	private boolean existingEmployee( Employee employee[],
									  Employee newEmployee )
	{
		/*** Local Variables ***/

		boolean compareSSN = false;
		int i = 0;

		/*** Checks employees SSN for duplicate or max employees is reached ***/

		while (  i < MAX_EMPLOYEES && !compareSSN )
		{
			if ( employee[i] != null )
			{
				if ( employee[i].equals( newEmployee ) )
					compareSSN = true;

				//else keep looking
			}
			i++;
		}

		if ( compareSSN )
		{
			System.out.println( "\n   *********************************************" );
			System.out.println( "   * Employee SSN: " + newEmployee.getEmployeeSSN() +
	            				" is Already Hired! *" );
			System.out.println( "   *********************************************" );
		}

		return compareSSN;
	}

	private void printMaximumEmployee()
	{
		System.out.println( "\n   *********************************************" );
		System.out.println( "   *       Maximum of " + MAX_EMPLOYEES + " Employees Hired!       *" );
		System.out.println( "   ********************************************* \n" );
	}

	/*** Application ***/

	public static void main(  String[] args )
	{
	    Lab14Driver test = new Lab14Driver();
	    test.startEmployeeTester();
	}
}