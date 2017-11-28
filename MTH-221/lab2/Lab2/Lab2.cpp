// Lab2.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

#include "stdafx.h"
#include<iostream>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// declare variables
	double acre = 43560, tracOfLand = 30000000, numOfAcres;

	// calculate how many acre's thats in the trac of land
	numOfAcres = tracOfLand / acre;

	// display total
	cout << "Number of acre's in the trac of land: " << numOfAcres << endl;

	return 0;
}

