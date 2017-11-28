// FirstTest.cpp : Defines the entry point for the console application.
// Joshua Wiley
// Mth221 13

#include "stdafx.h"
#include<iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// varibles 
	float base, height, area;

	// gather input
	cout << "Input the base" << endl;
	cin >> base;

	cout << "Input the height" << endl;
	cin >> height;

	area = .5 * base * height;

	cout << "The area of the triangke is: " << area << endl;

	return 0;
}

