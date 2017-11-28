// quiz 4.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "measure.h"
#include<iostream>

int _tmain(int argc, _TCHAR* argv[])
{
	// vector declearations
	measure a, b, tolalFTinInches;
	// float totalFT, totalInches;

	// user inputs fractions
	cout << " Enter the first measurement: ";
	cin >> a;
	cout << " Enter the second measurement: ";
	cin >> b;

	tolalFTinInches = a + b;
	
	cout << tolalFTinInches;

	return 0;
}

