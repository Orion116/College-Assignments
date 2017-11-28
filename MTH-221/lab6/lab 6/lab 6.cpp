// lab 6.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

/* 
*  This program finds the monthly payment,
*  amount paid back with interest, and the 
*  amount of interest paided back
*/

#include "stdafx.h"
#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// Variables
	int N, numberOfYears;
	float loanAmount, payment, paidBack, interestPaid, monthlyInterest, annualInterest;

	// User Input
	cout << left << setw(30)  << "Enter Loan Amount: ";
	cin >> loanAmount;

	cout << left << setw(30)  << "Enter Annual Interest Rate: ";
	cin >> annualInterest;
	
	cout << left << setw(30)  << "Enter Number Of Years: ";
	cin >> numberOfYears;

	// Clears screen for output
	system("cls");

	// Calculations
	monthlyInterest = annualInterest / 1200; 
	N = numberOfYears * 12; 
	
			// Finds the monthly payment
	payment = ((monthlyInterest * pow((1 + monthlyInterest), N)) 
			/ (pow((1 + monthlyInterest), N) - 1)) * loanAmount;
	paidBack = payment * N;
	interestPaid = paidBack - loanAmount;

	// Displays the formatted output
	cout << left << setw(30) << "Loan Amount: " << "$" << setw(10) 
							 << setprecision(2) << fixed << right << loanAmount << endl;
	cout << left << setw(32) << "Annual Interest Rate: " << setw(8) 
							 << setprecision(3) << fixed << right << annualInterest << "%" << endl;
	cout << left << setw(33) << "Number of Payments: " << setw(8) << right << N << endl;

	cout << left << setw(30) << "Monthly Payment: " 
							 << "$" << setw(10) << setprecision(2) << fixed << right << payment << endl;
	cout << left << setw(30) << "Amount Paid Back: " 
							 << "$" << setw(10) << setprecision(2) << fixed << right << paidBack << endl;
	cout << left << setw(30) << "Interest Paid: " << "$" 
							 << setw(10) << setprecision(2) << fixed << right << interestPaid << endl;

	return 0;
}

