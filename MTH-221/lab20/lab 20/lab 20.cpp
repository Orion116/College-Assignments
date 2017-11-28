// lab 20.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "rational.h"
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	// vector declearations
	rational a, b, c, S, M, SM;

	// user inputs fractions
	cout << "Enter the first fraction: ";
	cin >> a;
	cout << "Enter the second fraction: ";
	cin >> b;
	cout << "Enter the third fraction: ";
	cin >> c;

	system("cls");

	// calculations
	S = a + b;
	M = b * c;
	SM = c + a * b;

	// display answers
	cout << "\n Answers:";
	cout << "\n\ta + b =" << S << endl;
	cout << "\tb * c =" << M << endl;
	cout << "\tc + a * b =" << SM << "\n";

	return 0;
}

/***********************
*
*	Helper functions
*
***********************/

// Addition 
rational rational::operator + (rational N)
{
	rational Sum;
	
	Sum.dem = lcd(N.dem);
	Sum.num = num * (Sum.dem / dem) + N.num * (Sum.dem / N.dem);
	Sum.reduce();

	return Sum;
}

// multiplication
rational rational::operator * (rational N)
{
	rational M;
	
	M.num = num * N.num;
	M.dem = dem * N.dem;
	M.reduce();

	return M;
}

// reduces the fraction to the lowest terms
void rational::reduce()
{
	long gcf;
	gcf = greatestcommonfactor(num, dem);
	num/=gcf;
	dem/=gcf;
}

// finds the greatest common factor
long rational::greatestcommonfactor(long x1, long x2)
{
	long minnum, maxnum, gcf;
	minnum = min(abs(x1), abs(x2));
	maxnum = max(abs(x1), abs(x2));
	gcf = minnum;
	while(maxnum % gcf !=0 || minnum % gcf !=0)
		gcf--;
	return gcf;
}

// finds the least common multiple
long rational::lcd(long d2)
{
	long mindem, maxdem, multiple;
	mindem = min(dem, d2);
	maxdem = max(dem, d2);
	multiple = 1;
	while(maxdem*multiple%mindem !=0)
		multiple++;
	return maxdem*multiple;
}

// overloaded input 
istream& operator >> (istream& cin, rational& f)
{
	cin >> f.num;
	cin.ignore();
	cin >> f.dem;
	
	// validates n / 0 errors and 0 / n
	while (f.num == 0 || f.dem == 0)
	{
		cout << "\nRe-enter fraction: ";
		cin >> f.num;
		cin.ignore();
		cin >> f.dem;
		cout << "\n";
	}

	return cin;
}

// custom cout display
ostream& operator << (ostream& cout, rational& O)
{
	cout << " " << O.num << " / " << O.dem;
	return cout;
}