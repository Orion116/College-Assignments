// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;

class complex
{
	private:
		float real, imag;

	public:
		friend ifstream& operator >> (ifstream&, complex&);
		friend ostream& operator << (ostream&, complex&);
		complex operator + (complex);
		complex operator * (complex);
		
};