// lab 11.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include <iostream>
#include<iomanip>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Variables
	int mph, hours, timeI = 1;

	// User input
	cout << "What is the speed of the vehicle in mph? ";
	cin >> mph;

	// variable check loop
	while (mph <= 0)
	{
		cout << "\nInvalid Speed!  Please Enter a Valid Number.\n\n";
		cout << "What is the speed of the vehicle in mph? ";
		cin >> mph;
	}

	// User input
	cout << "How many hours has it traveled? ";
	cin >> hours;

	// variable check loop
	while (hours < 1)
	{
		cout << "Invalid Hours Traveled!  Please Enter a Valid Number.\n";
		cout << "How many hours has it traveled? ";
		cin >> hours;
	}

	// Header message
	cout << "\nHours Distance Traveled\n"
		 << "--------------------------\n";

	// Loop for printing hour and distants traveled
	for (int i = 0; i < hours; i++)
	{
		int milesPerOneHour = mph * timeI;
		cout << right << timeI << "\t" << setw(5) << right << milesPerOneHour <<endl;
		timeI++;
	}
	return 0;
}

