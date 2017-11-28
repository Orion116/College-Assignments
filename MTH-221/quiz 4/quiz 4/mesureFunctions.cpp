// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "measure.h"
#include<iostream>
using namespace std;

// overloaded input 
istream& operator >> (istream& cin, measure& f)
{
	cin >> f.feet;
	cin.ignore();
	cin >> f.inches;
	cin.ignore();

	return cin;
}

// Addition 
measure measure::operator + (measure V)
{
	measure Result;
	V.feet = V.feet * 12;
	feet = feet * 12;
	Result.ans = (feet + inches) + (V.feet + V.inches);

	Result.feet = Result.ans / 12;
	Result.inches = Result.ans % 12;

	return Result;
}

// custom cout display
ostream& operator << (ostream& cout, measure O)
{
	cout << " The sum of the two measurements: " << O.feet << " ft. " << O.inches << " in.\n";
	return cout;
}