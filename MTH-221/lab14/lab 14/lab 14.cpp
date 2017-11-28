// lab 14.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
#include<cmath>
using namespace std;

// function declareations 
int factorial(int);
float Sin(float);

int _tmain(int argc, _TCHAR* argv[])
{
	// file stream
	ofstream sinTable;
	sinTable.open("t:/lab14.dat");

	// constants
	const float pi = 3.14592;

	// variables
	float rad;
	float sinAnswer;

	sinTable << "Angle	Sine\n"
			 << "--------------\n";

	// loops through 90 degrees
	for(int i = 0; i <= 90; i += 2)
	{
		rad = i * (pi / 180);  // degrees to radians
		sinAnswer = Sin(rad);
		sinTable << i << "\t" << setprecision(4) << fixed << right << sinAnswer << endl;
	}
	return 0;
}

/*** Finds the factorial ***/
int factorial(int n)
{
	int fact = 1;

	for(int i = 1; i <= n; i++)
	{
		fact *= i;
	}
	return fact;
}

/*** Sine function ***/
float Sin(float rad)
{
	// variables
	bool flag = true;
	float deg = 0, error; 

	// loops until flag is false
	for(int j = 1; flag == true; j++)
	{
		// finds the sine for the specified rads and turns it to degs
		deg += (pow(-1.0, j - 1) * pow(rad, 2 * j - 1)) / factorial(2 * j - 1);
		error = pow(rad, 2 * j + 1) / factorial(2 * j + 1);

		if (error < .00001)
		{
			flag = false;
		}
	}
	return deg;
}

