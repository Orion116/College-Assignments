// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

class measure
{
private:
	int feet, inches, ans;

public:
	measure operator + (measure);
	friend istream& operator >> (istream&, measure&);
	friend ostream& operator << (ostream&, measure);
};