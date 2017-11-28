// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

class rational
{
private:
	long num, dem;

public:
	friend ostream& operator << (ostream&, rational&);
	friend istream& operator >> (istream&, rational&);
	void reduce();
	long greatestcommonfactor(long, long);
	long lcd(long);
	rational operator + (rational);
	rational operator * (rational);
};