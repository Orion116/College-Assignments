// functions.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "vector.h"
#include<iostream>
using namespace std;

void vector::setData(float x, float y, float z)
{
	xC = x;
	yC = y;
	zC = z;
}
vector vector::add(vector B)
{
	vector Sum;
	
	Sum.xC = xC + B.xC;
	Sum.yC = yC + B.yC;
	Sum.zC = zC + B.zC;

	return Sum;
}

vector vector::subtraction(vector B)
{
	vector Sub;

	Sub.xC = xC - B.xC;
	Sub.yC = yC - B.yC;
	Sub.zC = zC - B.zC;

	return Sub;
}

// dot product
float vector::dot(vector B)
{
	float d;

	d = (xC * B.xC) + (yC * B.yC) + (zC * B.zC);

	return d;
}

// cross product
vector vector::cross(vector B)
{
	vector C;

	C.xC = (yC * B.zC) - (zC * B.yC);
	C.yC = (zC * B.xC) - (xC * B.zC);
	C.zC = (xC * B.yC) - (yC * B.xC);

	return C;
}

void vector::vectorsOutput()
{
	cout << "\n " << xC << "i + " << yC << "j + " << zC << "k\n";
}