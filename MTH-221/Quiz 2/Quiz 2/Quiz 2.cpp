// Quiz 2.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13


#include<iostream>
#include<iomanip>
#include<cmath>

using namespace std;

float pi(int);
int main(int argc, char *argv[])
{
	// variabless
	int terms;
	float answerPI;

	// User input
	cout << "Enter Terms:  ";
	cin >> terms;

	// Gets what PI is 
	answerPI = pi(terms);
	cout << "Error? " << answerPI << endl;
	return 0;
}

float pi(int i)
{
	// variables
    float terms = .3;

	// loops until the user input terms has been reached
    for(int n = 0; n <= i; n++)
    {
        terms += terms;
    }
    return terms;
}
