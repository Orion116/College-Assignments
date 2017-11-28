// lab 21.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "triple.h"
#include<iostream>
#include<fstream>
#include<iomanip>

int _tmain(int argc, _TCHAR* argv[])
{
	// open dat file for solutions
	ifstream datFile;
	datFile.open("T:/triple.dat");
	
	// variables
	float Divide;
	triple A, B, Add;

	// read data into triple
	datFile >> A >> B;

	// calculations
	Add = A + B;
	cout << Add;

	// output
	Divide = A / B;
	cout << "\n Product = " << Divide << "\n\n";

	return 0;
}

