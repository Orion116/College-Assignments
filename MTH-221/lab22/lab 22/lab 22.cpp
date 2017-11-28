// lab 22.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "date.h"
#include<iostream>

int _tmain(int argc, _TCHAR* argv[])
{
	// variables
	int numberDays, menu = 0;
	
	// vector declearations
	date oldDate, newDate;
	
	// user input
	cout << " Enter '0' for finding a date in the future. \n Enter '1' for finding what day you were born on: ";
	cin >> menu;

	// choice
	if (menu == 0)
	{
		cout << " Enter Date: ";
		cin >> oldDate;

		cout << " Enter Number of Days to Add to the date: ";
		cin >> numberDays;
		newDate = oldDate + numberDays;
	
		cout << newDate;
	}
	else if (menu == 1)
	{
		cout << " Enter Date: ";//DR
		cin >> oldDate;//DR
		oldDate.birthday();
	}

	return 0;
}
