// lab 5.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<iomanip>
#include<string>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Variables
	string movieName;
	double adultTicket, 
		   adultPrice = 10.00, 
		   childTicket, 
		   childPrice = 6.00, 
		   percentage = .20, 
		   grossTotal, netTotal, amountPaid;

	// User Input
	cout << left << setw(25) << "Movie Name: ";
	getline(cin, movieName);

	cout << left << setw(25) << "Adult Tickets Sold: ";
	cin >> adultTicket;

	cin.ignore(1);

	cout << left << setw(25) << "Child Tickets Sold: ";
	cin >> childTicket;

	system("cls");  //Clears screen

	//Calculations
	grossTotal = (adultTicket * adultPrice) + (childTicket * childPrice);
	netTotal = grossTotal * percentage;
	amountPaid = grossTotal - netTotal;

	// Formatted output
	cout << left << setw(25) << "Movie Name:                \"" << movieName << "\"" << endl;
	cout << left << setw(25) << "Adult Tickets Sold:		" << adultTicket << endl;
	cout << left << setw(25) << "Child Tickets Sold:		" << childTicket << endl;

	cout << left << setw(25) << "Gross Box Office Profit:      $";
	cout << right << setw(8) << setprecision(2) << fixed << grossTotal << endl;

	cout << left << setw(25) << "Net Box Office Profit:        $";
	cout << right << setw(8) << setprecision(2) << fixed << netTotal << endl;

	cout << left << setw(25) << "Amount Paid to Distributor:   $";
	cout << right << setw(8) << setprecision(2) << fixed << amountPaid << endl;

	return 0;
}

