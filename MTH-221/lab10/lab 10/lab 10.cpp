// lab 10.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

float price(char, float);
bool checkHours(int);

int _tmain(int argc, _TCHAR* argv[])
{
	// variables
	char choice;
	float minutes;
	float  monthlyBill;

	// description
	cout << "\nCellular Packages\n"
		 << "\nPackage A:  $39.99 for 450 minutes and $0.45 for extra minutes a month. \n"
		 << "\nPackage B:  $59.99 for 900 minutes and $0.40 for extra minutes a month. \n"
		 << "\nPackage C:  $69.99 for unlimited minutes. \n";
	
	// gets the package
	cout << "\nEnter Your Package ID: ";
	cin >> choice;

	// converts to upper case
	choice = toupper(choice);

	// gets minutes
	cout << "\nEnter Your Monthly Minutes Used: ";
	cin >> minutes;

	// checks for valid number of hours
	while (!checkHours(minutes))
	{
		cout << "Invalid Number of Minutes!  Please Enter a Valid One\n";
		cout << "\nEnter Your Monthly Minutes Used: ";
		cin >> minutes;
	}

	monthlyBill = price(choice, minutes);
	cout << left << setw(20) << "Minutes Used: " << setw(6) << right << minutes << endl;
	cout << left << setw(20) << "Amount Due: " 
							 << "$" << setw(8) << setprecision(2) << fixed << right << monthlyBill << endl;
	
	return 0;
}

float price(char choice, float minutes)
{
	float priceA = 39.99, priceB = 59.99, priceC = 69.99, monthlyBill;
	
	switch(choice)
	{
	case 'A':
		{
			float monthlyBillB;

			// checks that it is least than the monthly minutes
			if (minutes > 450)
				monthlyBill = priceA + ((minutes - 450) * .45);
			else
				monthlyBill = priceA;

			// checks that it is least than the monthly minutes
			if (minutes >= 900)
				monthlyBillB = priceB + ((minutes - 900) * .40);
			else
				monthlyBillB = priceB;

			// calculations for finding savings by subtracting 
			// the total of either package by the current package
			float savingsB = monthlyBill - monthlyBillB;
			float savingsC = monthlyBill - priceC;

			if (savingsB < 0 && savingsC < 0)
			{
				cout << "No Savings" << endl;
			}
			else if (savingsB > savingsC && savingsC > 0)
				cout << "\nYou would save $" << (savingsB) << " if you switch to Package B\n\n";
			else
				cout << "\nYou would save $" << (monthlyBill - priceC) << " if you switch to Package C\n\n";
			break;
		}
	case 'B':
		{
			float monthlyBillA;

			// checks that it is least than the monthly minutes
			if (minutes > 450)
				monthlyBillA = priceA + ((minutes - 450) * .45);
			else
				monthlyBillA = priceA;

			// checks that it is least than the monthly minutes
			if (minutes >= 900)
				monthlyBill = priceB + ((minutes - 900) * .40);
			else
				monthlyBill = priceB;

			// calculations for finding savings by subtracting 
			// the total of either package by the current package
			float savingsA = monthlyBill - monthlyBillA;// - monthlyBillA;
			float savingsC = monthlyBill - priceC;

			if ((savingsA < 0 && savingsC < 0))
			{
				cout << "\nNo Savings" << endl;
			}
			else if (savingsA > savingsC)
				cout << "\nYou would save $" << (savingsA) << " if you switch to Package A\n\n";
			else
				cout << "\nYou would save $" << (monthlyBill - priceC) << " if you switch to Package C\n\n";
			break;
		}
	case 'C':
		{
			monthlyBill = priceC;
			break;
		}
	default:
		{}
	}
	return monthlyBill;
}

bool checkHours(int minutes)
{
	// variables
	int hours = minutes / 60;
	int month = 0;

	// menu for months
	cout << "\nEnter the Number of the Month\n"
		 << "1.  January   2.  February\n"
		 << "3.  March     4.  April\n"
		 << "5.  May       6.  June\n"
		 << "7.  July      8.  August\n"
		 << "9.  September 10. October\n"
		 << "11. November  12. December\n";
	cout << "\nEnter Month: ";
	cin >> month;

	// clears screen
	system("cls");

	// makes sure the month has the right number of month
	if (month == 2 && hours > 672)
		return false;
	else if ((month == 4 || month == 6 || 
		      month == 9 || month == 11) && hours > 720)
		return false;
	else if ((month == 1 || month == 3 || month == 5 || 
			  month == 7 || month == 8 || 
			  month == 10 || month == 12) && hours > 744)
		return false;
	else
		return true;
}
