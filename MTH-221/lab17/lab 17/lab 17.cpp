// lab 17.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

// part 1

#include "stdafx.h"
#include "vector.h"
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;

// functions
vector add(vector, vector);
vector subtraction(vector, vector);
vector cross(vector, vector);
float dot(vector, vector);
void printVectors(vector);

int _tmain(int argc, _TCHAR* argv[])
{
	// open dat file for solutions
	ifstream datFile;
	datFile.open("T:/Vectors.dat");
	
	// variables
	float coordX, coordY, coordZ, d;
	vector A, B, Z, Sum, Sub, Cross;

	// read in the values the vectors
	datFile >> A.xC >> A.yC >> A.zC >> B.xC >> B.yC >> B.zC;

	// calculations
	Sum = add(A, B);
	Sub = subtraction(A, B);
	d = dot(A, B);
	Cross = cross(A, B);
	
	// prints
	printVectors(Sum);
	printVectors(Sub);
	cout << "\n " << d << " Dot Product\n";
	printVectors(Cross);

	return 0;
}

