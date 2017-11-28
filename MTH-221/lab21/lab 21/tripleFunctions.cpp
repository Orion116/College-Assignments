// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "triple.h"
#include<iostream>
using namespace std;

// Input the the numbers from the dat file into the vectors
ifstream& operator >> (ifstream& datFile, triple& V)
{
	datFile >> V.num1 >> V.num2 >> V.num3;
	return datFile;
}

// Addition 
triple triple::operator + (triple V)
{
	triple Result;
	
	Result.num1 = num1 + V.num1;
	Result.num2 = 2 * (num2 + V.num2);
	Result.num3 = 3 * (num3 + V.num3);

	return Result;
}

// division product
float triple::operator / (triple V)
{
	float Result;

	Result = (num1 + num2 + num3) / (V.num1 + V.num2 + V.num3);
	
	return Result;
}

// custom cout display
ostream& operator << (ostream& cout, triple& V)
{
	cout << "\n Triple Number 1 = " << V.num1 << "\n Triple Number 2 = " << V.num2 << "\n Triple Number 3 = " << V.num3 << "\n\n";
	return cout;
}