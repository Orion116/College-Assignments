// Quiz 3.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
#include<cmath>
using namespace std;

void pi();
int _tmain(int argc, _TCHAR* argv[])
{
	// Gets what PI is 
	pi();
	
	return 0;
}

void pi()
{
	// variables
	ofstream pieTable;
	pieTable.open("t:/PI.txt");
    double terms;//changed to double DR
	
	// loops until 1000 terms has been reached
	pieTable << "Terms	Estimate of Pi\n"
		<< "-------------------------\n";
	for (int count = 100; count <= 1000; count +=100)
	{
		terms = 0;
		// calculate pi by looping the number of terms that the main loop provides
		for(int n = 0; n <= count; n++)
		{
			terms += 4 * (pow(-1.0, n) / ((2. * n + 2) * (2. * n + 3) *(2. * n + 4)));
		}
		// prints estimate of pie to a text file
		pieTable << count << "\t"  
                 << setprecision(9) << fixed << right << (terms + 3) 
                 << endl << endl;
	}
	cout << "Estimate of PI is " 
         << setprecision(8) << fixed << (terms + 3) << endl;
}

