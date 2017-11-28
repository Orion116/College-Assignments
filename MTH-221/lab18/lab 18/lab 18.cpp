// lab 18.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

// part 2

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
	float coordX, coordY, coordZ, d;
	vector A, B, Z, Sum, Sub, Cross, P;

	// read in the values the vectors
	datFile >> coordX >> coordY >> coordZ;
	A.setData(coordX, coordY, coordZ);

	datFile >> coordX >> coordY >> coordZ;
	B.setData(coordX, coordY, coordZ);

	// calculations
	Sum = A.add(B);
	Sub = A.subtraction(B);
	d = A.dot(B);
	Cross = A.cross(B);
	
	// prints
	Sum.vectorsOutput();
	Sub.vectorsOutput();
	cout << "\n " << d << " Dot Product\n";
	Cross.vectorsOutput();

	return 0;
}


