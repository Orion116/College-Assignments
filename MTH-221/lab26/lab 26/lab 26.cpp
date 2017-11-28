// lab 26.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

double lameAverage(double [], double, int, int);
void sort(double [], int);
int _tmain(int argc, _TCHAR* argv[])
{
	// variables
	double *testScores = nullptr,
			totalTestScore = 0.0,
			average = 0.0;
	int numOfScores, i;	// 'i' == counter flag

	cout << "\nEnter the Number of Test Scores: ";
	cin >> numOfScores;

	// check for negative numbers
	while (numOfScores <= 0)
	{
		cout << "\nInvalid Number Of Test Scores! Please Enter Another Number of Test Scores: ";
		cin >> numOfScores;
	}
	
	// create a pointer array
	testScores = new double[numOfScores];

	cout << "\n\nEnter the Test Scores Below\n\n";

	for (i = 0; i < numOfScores; i++)
	{
		cout << "Test Score " << (i + 1) << " of " << numOfScores << ": ";
		cin >> testScores[i];

		// check for negative numbers
		while (testScores[i] < 0)
		{
			cout << "\nInvalid Test Score! Please Enter Another Test Scores: ";
			cin >> testScores[i];
			cout << endl;
		}
	}

	system("cls");

	sort(testScores, numOfScores) ;

	// finds average
	average = lameAverage(testScores, average, numOfScores, i);

	cout << "The inputed Test Scores\n";
	for (i = 0; i < numOfScores; i++)
	{
		cout << " " << testScores[i];
	}
	cout << "\n\nThe Average of the Test Scores: "
         << setprecision(2) << fixed << right << average << endl;

	return 0;
}

double lameAverage(double testScores[], double average, 
				   int numOfScores, int i)
{
	// variable
	double totalTestScore = 0.0;

	// finds the total
	for (i = 0; i < numOfScores; i++)
	{
		totalTestScore += testScores[i];
	}

	// finds the average
	average = totalTestScore / numOfScores;

	return average;
}

void sort(double x[], int n) //Sequence Sort Function
{
	double minPtr;
	int min;

	for(int max = 0; max < n - 1; max++)
	{
		min = max;
		minPtr = x[max];
		for(int i = max + 1; i < n; i++)
		{
			if ((x[i]) < minPtr)
			{
				minPtr = x[i];
				min = i;
			}
		}
		x[min] = x[max];
		x[max] = minPtr;
	}
}
