// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<iomanip>
using namespace std;

class date
{
private:
	int month, day, year;

public:
	date operator + (int);
	int maxDays();
	void birthday();
	friend istream& operator >> (istream&, date&);
	friend ostream& operator << (ostream&, date);
};