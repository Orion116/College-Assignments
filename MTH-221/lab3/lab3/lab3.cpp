// lab3.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include <iostream>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Declare variable
	double userInput1, userInput2, userInput3, userInput4, userInput5, sum, average;

	// Get user input
	cout << "Input a number: ";
	cin >> userInput1;
	 
	cout << "Input a number: ";
	cin >> userInput2;
	 
	cout << "Input a number: ";
	cin >> userInput3;

	cout << "Input a number: ";
	cin >> userInput4;

	cout << "Input a number: ";
	cin >> userInput5;

	// Find the sum of all the user input
	sum = userInput1 + userInput2 + userInput3 + userInput4 + userInput5;

	// Find the average
	average = sum / 5;

	// Print out the average
	cout << "Average " << average << endl;

	return 0;
}

