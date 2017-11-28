// lab 13.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

// #include "stdafx.h"
#include <iostream>
using namespace std;

bool isPrime(int);
int main(int argc, char* argv[])
{

	int mysteryNumber;

	cout << "Enter a Number: ";
	cin >> mysteryNumber;
	//system("cls");

	while (mysteryNumber <= 1)
	{
		cout << "\nInvalid Number! Number Must Be Greater than 1.\n";
		cout << "Enter a Number: ";
		cin >> mysteryNumber;
		//system("cls");
	}

	if(isPrime(mysteryNumber))
	{
		cout << endl << mysteryNumber << " is a Prime Number\n\n";
	}
	else
	{
		cout << endl << mysteryNumber << " is not Prime Number\n\n";
	}
	return 0;
}

bool isPrime(int testNum1)
{
	bool flag = false;
	int testNum2 = testNum1;
	int answer;
	
	for (int i = 2; i < testNum1; i++)
	{
		answer = testNum1 % i;

		if (answer == 0)
			return false;
		else 
			continue;
	}
	return true;
}
