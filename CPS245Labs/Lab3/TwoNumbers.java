
/***********************************************************************
* 
*	File: TwoNumbers.java
*
*	Project:  TwoNumbers
*   
*	Description:  This is part one of Lab3.  Its job is to provide methods
*				  and varibles.
*
*	Author:  Joshua Wiley
*
*	Date:  2-15-15
*
*	Comments:  Specs were a little hard to follow. It wasn't clear what the
*			   Test program did until part three.  Added two class methods 
*			   to send the current numbers to my test programs. Also corrected
*			   the poor programming practices.
* 
**********************************************************************/

public class TwoNumbers
{
	
	/*** Class Variables ***/
	
	private double number1;
	private double number2;
	
	public TwoNumbers( double number1, double number2)
	{
		this.number1 = number1;
		this.number2 = number2;
	}
	
	/*** Constructors ***/
	
	public void setNums( double number1, double number2 )
	{
		this.number1 = number1;
		this.number2 = number2;
	}
	
	/*** Class Methods -- Accessors ***/
	
	//Special method to send the numbers to other class
	public double getNum1()
	{
		return this.number1;
	}
	
	public double getNum2()
	{
		return this.number2;
	}
	
	/*** Operations methods ***/
	
	public double getSum()
	{
		return this.number1 + this.number2;
	}
	
	public double getDifference()
	{
		return this.number1 - this.number2;
	}
	
	public double getProduct()
	{
		return this.number1 * this.number2;
	}
	
	public double getQuotient()
	{
		return this.number1 / this.number2;
	}
	
	public double getAverage()
	{
		return (this.number1 + this.number2) / 2;
	}
	
	/*** Application ***/
	
	public static void main(  String[] args )
	{
		TwoNumbersTester test = new TwoNumbersTester();
		test.startNumberTester();
	} 
}