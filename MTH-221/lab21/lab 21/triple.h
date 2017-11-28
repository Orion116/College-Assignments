// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;

class triple
{
private:
	float num1, num2, num3;

public:
	friend ostream& operator << (ostream&, triple&);
	friend ifstream& operator >> (ifstream&, triple&);
	triple operator + (triple);
	float operator / (triple);
};