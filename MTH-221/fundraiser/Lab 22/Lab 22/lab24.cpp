// Lab 24.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "student.h"
#include <fstream>
#include <iostream>
#include <iomanip>

int _tmain(int argc, _TCHAR* argv[])
{
	// open files
	ifstream fundFile("T:/fundraiser.dat");
	ofstream totalFile;

	// create a student array
	student FFA[5];

	// set create and set default for variables
	float total = 0;

	// read input file into students
	// calculate revenue for the students
	for (int i = 0; i < 5; i++)
	{
		fundFile >> FFA[i];
		FFA[i].revenue();
	}

	// sort students in decsending order by revenue
	FFA[0].sort(FFA, 5);

	// output to txt file
	for (int k = 0; k < 5; k++)
	{
		totalFile << FFA[k];
	}

	// calculate total revenue of all the students
	total = FFA[0].totalRevenue(FFA, 5);

	// open output file to append the total revenue to the end
	totalFile.open("T:/totalr.txt", ios::app);
	totalFile << "\nTotal Revenue: $" << setw(5) << total << endl;
	totalFile.close();

	return 0;
}

