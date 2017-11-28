
/***********************************************************************
* 
*	File: TwoNumbersTester.java
*
*	Project:  TwoNumbers
*   
*	Description:  This program is to test the class methods of the program
*		      TwoNumbers.
*
*	Author:  Joshua Wiley
*
*	Date:  2-15-15
*
*	Comments:  Specs were a little hard to follow. It wasn't clear what the
*		   Test program did until part three.  
* 
**********************************************************************/

public class TwoNumbersTester
{
	/*** Class method ***/
	
	public void startNumberTester()
	{
		/*** Local Spacing varibles ***/
		
		String space = "                ";
		
     	TwoNumbers twonumber1 = new TwoNumbers( 10, 15);
		TwoNumbers twonumber2 = new TwoNumbers( 100, 200);
		
		/*** Add ***/
		
		System.out.println( "\n" );
		System.out.println( space + "Start Two Number Test \n");
		System.out.println( space + "Adds two numbers");
		
		System.out.println();
		System.out.println( space + twonumber1.getNum1() + " + " 
				    	    + twonumber1.getNum2() + " = " 
				            + twonumber1.getSum() );
		System.out.println();
		
		System.out.println( space + twonumber2.getNum1() + " + " 
				            + twonumber2.getNum2() + " = " 
		       		        + twonumber2.getSum() );
		System.out.println("\n");
		
		/*** Testing alternate numbers first instance ***/
		
		System.out.println( space + "Adds alternate numbers");
		
		twonumber1.setNums( 50, 60 ); //Sets alternate numbers
		
		System.out.println();
		System.out.println( space + twonumber1.getNum1() + " + " 
				            + twonumber1.getNum2() + " = " 
				            + twonumber1.getSum() );
		System.out.println("\n");
		
		/*** Difference ***/
		
		System.out.println( space + "Subtracts two numbers");
		
		System.out.println();
		System.out.println( space + twonumber1.getNum1() + " - " 
				            + twonumber1.getNum2() + " = " 
				            + twonumber1.getDifference() );
		System.out.println();

		System.out.println( space + twonumber2.getNum1() + " - " 
				            + twonumber2.getNum2() + " = " 
				            + twonumber2.getDifference() );
		System.out.println("\n");
		
		/*** Product ***/
		
		System.out.println( space + "Multiplies two numbers");
		
		System.out.println();		
		System.out.println( space + twonumber1.getNum1() + " * " 
				            + twonumber1.getNum2() + " = " 
				            + twonumber1.getProduct() );
		System.out.println();
		
		System.out.println( space + twonumber2.getNum1() + " * " 
			                + twonumber2.getNum2() + " = " 
				            + twonumber2.getProduct() );
		System.out.println("\n");
		
		/*** Quotient ***/
		
		System.out.println( space + "Divides two numbers");
		
		System.out.println();
		System.out.println( space + twonumber1.getNum1() + " / " 
				            + twonumber1.getNum2() + " = " 
				            + twonumber1.getQuotient() );
		System.out.println();

		System.out.println( space + twonumber2.getNum1() + " / " 
				            + twonumber2.getNum2() + " = " 
				            + twonumber2.getQuotient() );
		System.out.println("\n");
		
		/*** Average ***/
		
		System.out.println( space + "Average of two numbers");
		
		System.out.println();
		System.out.println( space + "( " + twonumber1.getNum1() + " + " 
				            + twonumber1.getNum2() + " ) / 2" + " = "  
				            + twonumber1.getAverage() );
		System.out.println();

		System.out.println( space + "( " + twonumber2.getNum1() + " + " 
				            + twonumber2.getNum2() + " ) / 2" + " = " 
				            + twonumber2.getAverage() );
		System.out.println("\n");
	}
	
	/*** Application ***/
	
	public static void main(  String[] args )
	{
		TwoNumbersTester test = new TwoNumbersTester();
		test.startNumberTester();
	} 
}