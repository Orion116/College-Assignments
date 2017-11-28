// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "date.h"
#include<iostream>
#include<string>
using namespace std;

// overloaded input 
istream& operator >> (istream& cin, date& d)
{
	cin >> d.month;
	cin.ignore();

	cin >> d.day;
	cin.ignore();

	cin >> d.year;
	cin.ignore();

	// error checking
	while (d.month <= 0 || d.month > 12 || d.day <= 0 || d.day > 31 )
	{
		cout << "\nRe-enter Date: ";

		cin >> d.month;
		cin.ignore();

		cin >> d.day;
		cin.ignore();

		cin >> d.year;
		cin.ignore();
		cout << "\n";
	}

	return cin;
}

// Addition 
date date::operator + (int d)
{
	date r;
	
	r.day = day + d;
	r.month = month;
	r.year = year;

	while (r.day > r.maxDays())
	{
		r.day -= r.maxDays();
		r.month += 1;

		if (r.month > 12)
		{
			r.year += 1;
			r.month -= 12;
		}
	}

	return r;
}

void date::birthday()
{
	// Jan. and Feb. are considered 13 and 14 of the previous year
	if (month == 1 || month == 2)
	{
		month += 1;
	}

	// Zeller's Algorithm
	int weekday = 
		(day + 13 * (month + 1) / 5 + year % 100 + (year % 100) / 4 + (year / 100) / 4 + 5 * (year / 100)) % 7;
	
	// What day is it?
	if (weekday == 0)
		cout << "\n Your Birthday was Saturday\n";
	else if (weekday == 1)
		cout << "\n Your Birthday was Sunday\n";
	else if (weekday == 2)
		cout << "\n Your Birthday was Monday\n";
	else if (weekday == 3)
		cout << "\n Your Birthday was Tuesday\n";
	else if (weekday == 4)
		cout << "\n Your Birthday was Wednesday\n";
	else if (weekday == 5)
		cout << "\n Your Birthday was Thursday\n";
	else if (weekday == 6)
		cout << "\n Your Birthday was Friday\n";

}

// finds the max days each month has
int date::maxDays()
{
	// makes sure the month has the right number of month
	if (month == 2 && day > 28)
	{
		// check if it is leap year
		int testYear = year % 4;
		if (testYear == 0)
		{
			return 29;
		}
		return 28;
	}
	else if ((month == 4 || month == 6 || 
		      month == 9 || month == 11) && day > 30)
		return 30;
	else if ((month == 1 || month == 3 || month == 5 || 
			  month == 7 || month == 8 || 
			  month == 10 || month == 12) && day > 31)
		return 31;
}

// custom cout display
ostream& operator << (ostream& cout, date O)
{
	cout << " \nYour New Date is: " << O.month << "/" << O.day << "/" << O.year << "\n";
	return cout;
}