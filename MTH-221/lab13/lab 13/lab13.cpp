// lab 13.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

// #include "stdafx.h"
#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int);
int main(int argc, char* argv[])
{

	int mysteryNumber;
	int answer;
	int i = 2;
	int j = 0;
	int ans, temp2, temp3;

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
	int i = 2;
	
	while (i < testNum1)
	{
		answer = testNum1 % i;

		if (answer == 0)
			return false;
		else 
			continue;

		i++;
	}
	return true;
}
