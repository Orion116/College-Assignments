// test1.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

bool validReadings(float, float);
float calculateBill(float, float);
void displayCustomer(int id[], int, float b[]);
int _tmain(int argc, _TCHAR* argv[])
{
	// constant
	const int MAX = 3;

	// variables
	int id[MAX];
	float firstReading[MAX], secondReading[MAX], bill[MAX];
		  
	cout << "\nEnter " << MAX << " Customer ID and Kilowatts Hours\n";

	// the for loop loops through the user input and 
	// assigns the entered values to the right array
	for (int i = 0; i < MAX; i++)
	{
		cout << "\nEnter Customer ID: ";
		cin >> id[i];

		cout << "\nEnter Your Beginning of Month KwH Used: ";
		cin >> firstReading[i];
		
		cout << "\nEnter Your End of Month KwH Used: ";
		cin >> secondReading[i];
		
		// checks for valid checks that the first reading 
		// is not bigger then the second one then calculates
		// the monthly bill
		if (validReadings(firstReading[i], secondReading[i]))
			bill[i] = calculateBill(firstReading[i], secondReading[i]);

		system("cls");
	}
	
	// for loop to display the total bill for three customers
	for (int i = 0; i < MAX; i++)
	{
		displayCustomer(id, i, bill);
	}
	return 0;
}

/*** validation to check that the first reading is != to the second ***/
bool validReadings(float firstReading, float secondReading)
{
	while (firstReading >= secondReading)
	{
		cout << "ERROR!!! Beginning of month usage has" 
			 << " to be less then the end of month usage. \n";
		// gets firstReading
		cout << "\nEnter Your Beginning of Month KwH Used: ";
		cin >> firstReading;
		// gets secondReading
		cout << "\nEnter Your End of Month KwH Used: ";
		cin >> secondReading;
	}
	// if the above is true it skips to this 
	// if otherwise it asks for valid numbers
	if (firstReading < secondReading)
		return true;
}

/*** display function ***/
void displayCustomer(int id[], int customer, float bill[])
{
	cout << "\nCustomer ID: " << id[customer] << endl;
	cout << left << setw(30) << "Your Monthly Bill is: " << "$" << setw(8) 
							 << setprecision(2) << fixed << right << bill[customer] << endl;
}

/*** calculates the monthly bill for a customer ID ***/
float calculateBill(float BR, float FR)
{
	// constants
	const float RATE1 = 0.08, RATE2 = 0.11, RATE3 = 0.15;
	// variables
	float rate = 0, kwh, bill;

	// calculate the usage for the month
	kwh = FR - BR;

	// sets the rate depending on the monthly usage
	if (kwh < 500)
		rate = RATE1;
	else if (kwh <= 500 || kwh < 1500)
		rate = RATE2;
	else if (kwh >= 1500)
		rate = RATE3;

	// calculate the monthly bill
	bill = rate * kwh;
	return bill;
}