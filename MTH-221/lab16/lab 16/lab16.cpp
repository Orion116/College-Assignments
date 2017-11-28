// lab 16.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

// #include "stdafx.h"
#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
#include<cmath>
using namespace std;


void readarray(float tests[], float quizzes[], string &);
void writearray(float[], int);
void stats(float t[], float Q[],
		   float &, float &,
		   float &, float &, 
		   float &, float &);
void sort(float[], int);
int main(int argc, char *argv[])
{
	// variables 
	const int T = 5, Q = 15;
	float sumT = 0, 
		  avgT,
		  sumQ = 0, 
		  avgQ,
		  sumTotal = 0, 
		  avgTotal,
		  tests[T], 
		  quizzes[Q];
	string filename = "/home/orion116/Desktop/Misc/C++/lab16.dat";

	/*** reads the arrays and sorts them ***/
	readarray(tests, quizzes,  filename);
	sort(tests, T);	// sort tests
	cout << "\nTest Grades Highest to Lowest: \n\n";
	writearray(tests, T);
	sort(quizzes, Q);	// sort quizzes
	cout << "\nQuiz Grades Highest to Lowest: \n\n";
	writearray(quizzes, Q);

	// finds the overall average
	// stats(tests, quizzes,
	// 	  sumT, avgT, 
	// 	  sumQ, avgQ,
	// 	  sumTotal, avgTotal);

	// pauses the program so that I can clear the 
	// screen without the user first reading the output
	// system("pause");
	// system("cls");
	
	// // print outs the stats
	// cout << left << setw(18) << "\n  Total Score of " << (T - 1) << " Tests and "
	// 						 << (Q - 2) << " Quizes: " << setw(6) 
	// 						 << setprecision(3) << fixed << right << avgTotal 
	// 						 << endl << endl;
	return 0;
}

void readarray(float tests[], float quizzes[], string &filename)
{
	// variables
	int i;
	
	// opens new file
	fstream data(filename.c_str());
	// validation structrure 
	if (data)
	{
		// loops until the end of the file
		while(!data.eof())
		{
			// reads the first 5 lines for tests
			for (i = 0; i < 5; i++)
			{
				data >> tests[i];
			}

			// read the next 15 lines for quizzes
			for (i = 0; i < 15; i++)
			{
				data >> quizzes[i];
			}
		}		
		data.close();	// closes the data file
	}
	else 
	{
		cout << "ERROR: Could Not Read File.  Make Sure It Exsits.\n";
		cout << "Enter Filename:  ";
		cin >> filename;
	}
}

/*** Prints the sorted array ***/
void writearray(float x[], int c)
{
	for (int i = 0; i < c; i++)
	{
		cout << x[i] << endl;
	}
	cout << endl;
}

/*** Finds the stats for a a file ***/
// void stats(float tests[], float quizzes[],
// 		   float &sumT, float &avgT,
// 		   float &sumQ, float &avgQ, 
// 		   float &sumTotal, float &avgTotal)
// {
// 	// constance for array size
// 	const int T = 4, Q = 13;

// 	// sums the entire contents of an array
// 	for (int k = 0; k < T; k++)
// 	{
// 		sumT += tests[k];
// 	}
// 	avgT = sumT / T;	// finds the average of the array

// 	// sums the entire contents of an array
// 	for (int j = 0; j < Q; j++)
// 	{
// 		sumQ += quizzes[j];
// 	}
// 	avgQ = sumQ / Q;	// finds the average of the array
	
// 	// finds the overall average
// 	sumTotal = sumT + sumQ;
// 	avgTotal = sumTotal / (T + Q);
// }

void sort(float x[], int n) //Sequence Sort Function
{
	float max, temp;
	for(int m = 0; m < n - 1; m++)
	{
		max = x[m];
		for(int k = m + 1; k < n; k++)
		{
			if (x[k] > max)
			{
				temp = x[k];
				x[k] = max;
				max = temp;
			}
		}
		x[m] = max;
	}
}