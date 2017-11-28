// Joshua Wiley
// mth22113
#include "stdafx.h"
#include "vector.h"
#include<iostream>
using namespace std;

// Input the the numbers from the dat file into the vectors
ifstream& operator >> (ifstream& datFile, vector& V)
{
	datFile >> V.xC >> V.yC >> V.zC;
	return datFile;
}

// Addition 
vector vector::operator + (vector V)
{
	vector Sum;
	
	Sum.xC = xC + V.xC;
	Sum.yC = yC + V.yC;
	Sum.zC = zC + V.zC;

	return Sum;
}

// Subtraction
vector vector::operator - (vector V)
{
	vector Sub;

	Sub.xC = xC - V.xC;
	Sub.yC = yC - V.yC;
	Sub.zC = zC - V.zC;

	return Sub;
}

// dot product
float vector::operator * (vector V)
{
	float d;

	d = (xC * V.xC) + (yC * V.yC) + (zC * V.zC);

	return d;
}

// cross product
vector vector::operator / (vector V)
{
	vector C;

	C.xC = (yC * V.zC) - (zC * V.yC);
	C.yC = (zC * V.xC) - (xC * V.zC);
	C.zC = (xC * V.yC) - (yC * V.xC);

	return C;
}

// custom cout display
ostream& operator << (ostream& cout, vector& V)
{
	cout << "\n " << V.xC << "i + " << V.yC << "j + " << V.zC << "k";
	return cout;
}