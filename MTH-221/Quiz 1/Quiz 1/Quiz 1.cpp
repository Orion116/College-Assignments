// Quiz 1.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13 

#include "stdafx.h"
#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// variable
	float stateTax = .06;
	float item1, item2, item3, item4, item5, amountOfTax, subtotal, total;

	cout << "Enter the Price of Five items" << endl << endl;

	// input
	cout << "Enter Item 1: ";
	cin >> item1;

	cout << "Enter Item 2: ";
	cin >> item2;

	cout << "Enter Item 3: ";
	cin >> item3;

	cout << "Enter Item 4: ";
	cin >> item4;

	cout << "Enter Item 5: ";
	cin >> item5;

	system("cls");

	// calculations
	subtotal = item1 + item2 + item3 + item4 + item5;
	amountOfTax = subtotal * stateTax;
	total = subtotal + amountOfTax;

	// output
	cout << left << setw(20) << "Subtotal: " 
							 << "$" << setw(10) << setprecision(2) << fixed << right << subtotal << endl;
	cout << left << setw(20) << "Tax: " 
							 << "$" << setw(10) << setprecision(2) << fixed << right << amountOfTax << endl << endl;
	cout << left << setw(20) << "Total: " << "$" 
							 << setw(10) << setprecision(2) << fixed << right << total << endl << endl;
	return 0;
}

