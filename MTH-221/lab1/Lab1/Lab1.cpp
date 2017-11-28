// Lab1.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

//#include "stdafx.h"
#include<iostream>
using namespace std;

int main()//_tmain(int argc, _TCHAR* argv[])
{
	// Variable
	double hours, rate, pay;

	// get the number of hours worked
	cout << "How many hours did you work? ";
	cin >> hours;

	// get the hourly pay rate
	cout << "How much do you get paid per hour? ";
	cin >> rate;

	// calculate pay
	pay = hours * rate;

	// display
	cout << "You have earned $ " << pay << endl;

	return 0;
}

