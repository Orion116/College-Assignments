// lab9.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Constants 
	const float discount20P = .20,
				discount30P = .30,
				discount40P = .40,
				discount50P = .50;

	// Variables
	int quantity;
	float price = 99, discount, total;

	// User Input
	cout<<"Enter Number of units: ";
	cin >> quantity;

	// Validation Structure 
	if (quantity <= 0)
		cout << "Invalid Number of Items.  Please Try again. \n";
	else
	{
		// Discount tree
		if (quantity <= 9)
			discount = 0;
		else if (quantity >= 10 && quantity <= 19)
			discount = discount20P;
		else if (quantity >= 20 && quantity <= 49)
			discount = discount30P;
		else if (quantity >= 50 && quantity <= 99)
			discount = discount40P;
		else if (quantity >= 100)
			discount = discount50P;
		else
			total = price * quantity;

		// Calculation
		total = price * quantity * (1-discount);

		// Displays the formatted output
		cout << left << setw(20) << "\nDiscount: " << setw(10)
			 << right << (discount * 100) << "%" << endl;
		cout << left << setw(20) << "Total: " << "$" << setw(9) 
			 << setprecision(2) << fixed << right << total << endl;
	}
	return 0;
}

