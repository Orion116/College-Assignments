// lab4.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include <iostream>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Variables
	float tankSize, milesDriven, MPG;

	// Get user input
	cout << "Enter the size of your gas tank: ";
	cin >> tankSize;

	cout << "Enter miles driven: ";
	cin >> milesDriven;
	cout << endl;

	// Calculate Miles Per Gallon
	MPG = milesDriven/tankSize;

	// Display the total
	cout << "Your MPG is: " << MPG << endl;

	return 0;
}

