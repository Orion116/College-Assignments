
/**
 * *******************************************************************
 *
 * File: EmployeeTester.java
 *
 * Author: Joshua Wiley
 *
 * Date: 5-4-15
 *
 * Purpose: Tester object for Employee
 *
 * Comments: Without the use of format string, I could not force two
 * decimal places.
 *
 ********************************************************************
 */

import java.util.*;

public class EmployeeTester extends Employee
{
    /**
     * * Class Constants **
     */

    private final int MAX_EMPLOYEES = 5;
    private final int DISPLAY_WITHOUT_PAY = 1;
    private final int DISPLAY_WITH_PAY = 2;

    /**
     * * Class test Method **
     */
    private void startEmployeeTester()
    {
        /**
         * * Instantiate an Array of Objects **
         */

        Employee employee[] = new Employee[MAX_EMPLOYEES];

        employee[0] = new Employee();
        employee[1] = new ProductionWorker();
        employee[2] = new ShiftSupervisor();
        employee[3] = new TeamLeader();
        employee[4] = null;

        //Hires one Employee of each type
        this.hireEmployees(employee);
        //Display state of objects
        this.displayStateOFEmployee(employee, DISPLAY_WITHOUT_PAY);
        //Hire new employee of any of the four types by users choice
        employee[4] = this.getNewHire(employee);
        //Display state with pay
        this.displayStateOFEmployee(employee, DISPLAY_WITH_PAY);
    }

    /**
     * * Display Methods **
     */
    private void displayStateOFEmployee( Employee employee[],
                    int id )
    {
        /**
         * * Loops through all the employees **
         */

        for (int i = 0; i < MAX_EMPLOYEES; i++)
        {
            /**
             * * Checks for non-initialized employee **
             */

            if (employee[i] != null)
            {
                System.out.println("\n ----------- Employee "
                                + (i + 1) + " ----------\n");
                this.displayEmployeeInfo(employee[i], id);
            }

            //Else ignore the employee
        }
    }

    private void displayEmployeeInfo( Employee employee,
                    int id )
    {
        //Prints the state of the employee
        System.out.println(employee.toString());

        /**
         * * Checks if pay is to be printed **
         */
        if (id == DISPLAY_WITH_PAY)
        {
            System.out.println(" Weekly Pay Check: $"
                            + calculatePay(employee)
                            + "\n");
        }
    }

    /**
     * * Hire initialized employees **
     */
    private void hireEmployees( Employee employee[] )
    {
        /**
         * * Loops through the array **
         */

        for (int id = 0; id < MAX_EMPLOYEES; id++)
        {
            /**
             * * Checks for non-initialized employee **
             */

            if (employee[id] != null)
            {
                employee[id] = this.getEmployeeInformation(id);
            }

            //Else ignore the employee
        }
    }

    /**
     * * Get Info for Employee Types **
     */
    private Employee getEmployeeInformation( int id )
    {
        Employee employee = new Employee();

        if (id == 0)
        {
            System.out.println("\n\n----------Hiring New Employee----------");
            employee = this.getEmployeeData();
        }
        else if (id == 1)
        {
            System.out.println("\n\n----------Hiring Production Worker----------");
            employee = getProductionWorker();
        }
        else if (id == 2)
        {
            System.out.println("\n\n----------Hiring Shift Supervisor----------");
            employee = getShiftSupervisor();
        }
        else if (id == 3)
        {
            System.out.println("\n\n----------Hiring Team Leader----------");
            employee = getTeamLeader();
        }

        return employee;
    }

    /**
     * * Get Employee Type Information **
     */
    private Employee getEmployeeData()
    {
        //Creates a new employee
        Employee employee = new Employee();

        /**
         * * Receives User Input **
         */
        employee.setEmployeeSSN(userStringValue("Enter SSN:"));
        employee.setEmployeeName(userStringValue("Enter Employee Name:"));

        return employee;
    }

    /**
     * * Get ProductionWorker Type Information **
     */
    private ProductionWorker getProductionWorker()
    {
        /**
         * * Creates a Temporary Employee **
         */

        Employee tempEmployee = new Employee();
        tempEmployee = this.getEmployeeData();

        /**
         * * Local Variables **
         */
        double payRate = 0.0;
        double hours = 0.0;
        int shift = 1;

        payRate = userDoubleValue("Enter Pay Rate:");  //Gets user input
        hours = userDoubleValue("Enter Hours Worked:");  //Gets user input
        shift = (int) userDoubleValue("Enter Shift (1: day or 2: night):");

        ProductionWorker worker = new ProductionWorker(tempEmployee.getEmployeeSSN(),
                        tempEmployee.getEmployeeName(),
                        payRate, hours, shift);

        return worker;
    }

    /**
     * * Get ShiftSupervisor Type Information **
     */
    private ShiftSupervisor getShiftSupervisor()
    {
        /**
         * * Creates a Temporary Employee **
         */

        Employee tempEmployee = new Employee();
        tempEmployee = this.getEmployeeData();

        /**
         * * Local Variables **
         */
        double annualSalary;
        double annualBonus;

        annualSalary = userDoubleValue("Enter Annual Salary:");  //Gets user input
        annualBonus = userDoubleValue("Enter Annual Bonus:");  //Gets user input

        ShiftSupervisor worker = new ShiftSupervisor(tempEmployee.getEmployeeSSN(),
                        tempEmployee.getEmployeeName(),
                        annualSalary, annualBonus);
        return worker;
    }

    /**
     * * Get TeamLeader Type Information **
     */
    private TeamLeader getTeamLeader()
    {
        /**
         * * Creates a Temporary Employee **
         */

        ProductionWorker tempEmployee = new ProductionWorker();
        tempEmployee = this.getProductionWorker();

        /**
         * * Local Variables **
         */
        double trainingHours;

        trainingHours = userDoubleValue("Enter Training Hours:");  //Gets user input

        TeamLeader worker = new TeamLeader(tempEmployee.getEmployeeSSN(),
                        tempEmployee.getEmployeeName(),
                        tempEmployee.getHourlyRate(),
                        tempEmployee.getHours(),
                        tempEmployee.getShift(),
                        trainingHours);
        return worker;
    }

    /**
     * * Creates Employee of User Selected Type **
     */
    private Employee getNewHire( Employee employee[] )
    {
        /**
         * * Creates a New Employee **
         */

        Employee newEmployee = new Employee();

        /**
         * * Local Variables **
         */
        double menuOption = 0;
        //Displays menu options
        this.displayEmployeeTypeMenu();
        //Gets user input
        menuOption = this.userDoubleValue("Enter Menu Option:");

        /**
         * * Validates Menu Options **
         */
        if (validRange(menuOption, 1, 4))
        {
            menuOption -= 1;
        }
        else
        {
            menuOption = 0;
        }

        /**
         * * Instantiates Employee type **
         */
        if (menuOption == 0)
        {
            newEmployee = new Employee();
        }
        else if (menuOption == 1)
        {
            newEmployee = new ProductionWorker();
        }
        else if (menuOption == 2)
        {
            newEmployee = new ShiftSupervisor();
        }
        else if (menuOption == 3)
        {
            newEmployee = new TeamLeader();
        }

        /**
         * * Gets New Hire Information **
         */
        newEmployee = this.getEmployeeInformation((int) menuOption);

        /**
         * * Checks for Existing Employee **
         */
        if (existingEmployee(employee, newEmployee))
        {
            System.out.println("\n   *********************************************");
            System.out.println("   * Employee SSN: " + newEmployee.getEmployeeSSN()
                            + " is Already Hired! *");
            System.out.println("   *********************************************");
            newEmployee = null;
        }

        return newEmployee;
    }

    /**
     * * Helper Method **
     */
    private String userStringValue( String id )
    {
        /**
         * * Local Variables **
         */

        Scanner input = new Scanner(System.in);
        String userInput = "invalid";
        String FormatString = "%n %24s ";

        /**
         * * Receives User Input & Prints the question **
         */
        System.out.printf(FormatString, id);
        userInput = input.nextLine();

        return userInput;
    }

    private double userDoubleValue( String id )
    {
        /**
         * * Local Variables **
         */

        double inputValue = 0.0;
        String inputString = "";
        String FormatString = "%n %24s ";

        /**
         * * Gets input as a string to allow enter to next prompt **
         */
        inputString = userStringValue(id);  //Gets user input

        /**
         * * Try/Catch for parsing errors **
         */
        try
        {
            inputValue = Double.parseDouble(inputString);
        }
        catch (NumberFormatException exc)
        {
            //returns default
        }

        return inputValue;
    }

    private double calculatePay( Employee employee )
    {
        /**
         * * Local Variables **
         */

        double pay = 0.0;

        /**
         * * Calls an employee type class calculateWeeklyPay **
         */
        pay = employee.calculateWeeklyPay();

        return pay;
    }

    private void displayEmployeeTypeMenu()
    {
        /**
         * * Local Constants **
         */

        final String FORMAT_STRING = "%n    %-50s ";

        /**
         * * Prints Menu **
         */
        System.out.printf(FORMAT_STRING, "   Choose an Employee Type to Hire:");
        System.out.printf(FORMAT_STRING, "   --------------------------------");
        System.out.printf(FORMAT_STRING, "1. Employee");
        System.out.printf(FORMAT_STRING, "2. Production Worker");
        System.out.printf(FORMAT_STRING, "3. Shift Supervisor");
        System.out.printf(FORMAT_STRING, "4. Team Leader");
        System.out.println();
    }

    private boolean existingEmployee( Employee employee[],
                    Employee newEmployee )
    {
        /**
         * * Local Variables **
         */

        boolean compareSSN = false;
        int i = 0;

        /**
         * * Checks employees SSN for duplicate or max employees is reached **
         */
        while (i < MAX_EMPLOYEES && !compareSSN)
        {
            if (employee[i] != null)
            {
                if (employee[i].equals(newEmployee))
                {
                    compareSSN = true;
                }

                //else keep looking
            }
            i++;
        }
        return compareSSN;
    }

    /**
     * * Application **
     */
    public static void main( String[] args )
    {
        EmployeeTester test = new EmployeeTester();
        test.startEmployeeTester();
    }
}
