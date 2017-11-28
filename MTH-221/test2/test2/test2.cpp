// test2.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "complex.h"
#include <iostream>
#include <fstream>

int _tmain(int argc, _TCHAR* argv[])
{
	// open dat file for solutions
	ifstream datFile;
	datFile.open("t:\input2.dat");
	
	// variables
	complex R, i, volt;

	// read in the values the complex
	datFile >> R >> i;

	// calculations
	volt = R + i;
	volt = R * i;
	
	// prints
	cout << volt;
cout<<R+i;//DR
	return 0;
}
