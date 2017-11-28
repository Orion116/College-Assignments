// Lab8.cpp : Defines the entry point for the console application.
// STARTING POINT FOR lab7
// Joshua Wiley
// mth221 13

/* 
	This program divides a user-supplied number by another
	user-supplied number.  It checks for division by sero.
 */
#include "stdafx.h"
#include<iostream>
using namespace std;


int _tmain(int argc, _TCHAR* argv[])
{
	double num1, num2, quotient;

	cout<<"Enter a number: ";
	cin>>num1;
	cout<<"Enter another number: ";
	cin>>num2;

	if (num2 == 0)
		cout<<"Division by zero is not possible.\n" 
			<<"Please run the program again "
			<<"and enter a number besides zero.\n";
	else
	{
		quotient = num1 / num2;
		cout<<"The quotient of  "<<num1 << " divided by "<<num2<<" is "
			<<quotient<<endl;
	}
	
	return 0;
}

