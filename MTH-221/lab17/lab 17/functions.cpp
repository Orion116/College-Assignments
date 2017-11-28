// functions.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "vector.h"
#include<iostream>
using namespace std;

vector add(vector A, vector B)
{
	vector Sum;
	
	Sum.xC = A.xC + B.xC;
	Sum.yC = A.yC + B.yC;
	Sum.zC = A.zC + B.zC;

	return Sum;
}

vector subtraction(vector A, vector B)
{
	vector Sub;

	Sub.xC = A.xC - B.xC;
	Sub.yC = A.yC - B.yC;
	Sub.zC = A.zC - B.zC;

	return Sub;
}

// dot product
float dot(vector A, vector B)
{
	float d;

	d = (A.xC * B.xC) + (A.yC * B.yC) + (A.zC * B.zC);

	return d;
}

// cross product
vector cross(vector A, vector B)
{
	vector C;

	C.xC = (A.yC * B.zC) - (A.zC * B.yC);
	C.yC = (A.zC * B.xC) - (A.xC * B.zC);
	C.zC = (A.xC * B.yC) - (A.yC * B.xC);

	return C;
}

void printVectors( vector Ans)
{
	cout << "\n " << Ans.xC << "i + " << Ans.yC << "j + " << Ans.zC << "k\n";
}