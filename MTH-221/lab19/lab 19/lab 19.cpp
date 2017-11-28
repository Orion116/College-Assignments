// lab 19.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

// part 3

#include "stdafx.h"
#include "vector.h"
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// open dat file for solutions
	ifstream datFile;
	datFile.open("T:/Vectors.dat");
	
	// variables
	float d;
	vector A, B, Sum, Sub, Cross;

	// read in the values the vectors
	datFile >> A >> B;

	// calculations
	Sum = A + B;
	Sub = A - B;
	d = A * B;
	Cross = A / B;
	
	// prints
	cout << Sum << " Sum\n";
	cout << Sub << " Subtraction\n";
	cout << "\n " << d << " Dot Product\n";
	cout << Cross << " Cross Production\n";

	return 0;
}