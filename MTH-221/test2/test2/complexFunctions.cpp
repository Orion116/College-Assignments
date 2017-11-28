// Joshua Wiley
// mth22113
#include "stdafx.h"
#include "complex.h"
#include<iostream>
#include<iomanip>
#include<fstream>
using namespace std;

// Input the the numbers from the dat file 
// into the two complex numbers variables from the class complex.h
ifstream& operator >> (ifstream& datFile, complex& V)
{
	datFile >> V.real >> V.imag;
	return datFile;
}

// Addition 
complex complex::operator + (complex B)
{
	complex add;
	
	add.real = real + B.real;
	add.imag = imag + B.imag;

	return add;
}

// multiply
complex complex::operator * (complex B)
{
	complex multiply;

	multiply.real = (real * B.real) - (imag * B.imag);
	multiply.imag = (imag * B.imag) + (imag * B.imag);

	return multiply;
}


// custom cout display
ostream& operator << (ostream& cout, complex& V)
{
	cout << "\n real" << setw(5) << V.real 
         << " + imag " << setw(10) << V.imag << "i\n";
	return cout;
}
