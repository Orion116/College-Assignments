// Quiz 2.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13


# include <iostream>
# include <iomanip>
# include <cmath>
using namespace std;

float pi(int);
double doublePi(int);
int main(int argc, char *argv[])
{
	// variabless
	int terms;
	float answerPI;
    double dPi;

	// User input
	cout << "Enter Terms:  ";
	terms = 1048;

	// Gets what PI is 
	answerPI = pi(terms);
    dPi = doublePi(terms);
	cout << "Error: " << setprecision(20) << fixed<< answerPI << endl;
    cout << "Error double: " << setprecision(20) << fixed<< dPi << endl;
	return 0;
}

float pi(int i)
{
	// variables
    float terms = .3;
    cout << "Terms start = " << setprecision(20) << fixed << terms << endl;
	// loops until the user input terms has been reached
    for(int n = 0; n <= i; n++)
    {
        cout << n << ". " << setprecision(20) << terms << endl;
        terms += terms;
    }
    return terms;
}

double doublePi(int i)
{
    // variables
    double terms = .3;
    cout << "Terms start = " << setprecision(20) << fixed << terms << endl;
    // loops until the user input terms has been reached
    for(int n = 0; n <= i; n++)
    {
        cout << n << ". " << setprecision(20) << terms << endl;
        terms += terms;
    }
    return terms;
}
