// lab 15.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
#include<cmath>
using namespace std;

void readarray(float x[], int &, string &);
void writearray(float[], int);
void stats(float x[], int n, float &, float &, float &, float &, float &, float &);
void sort(float[], int);
int _tmain(int argc, _TCHAR* argv[])
{
	// variables 
	int i = 0, n;
	float sum = 0, 
		  x[50], 
		  avg, 
		  ss = 0,
		  std, 
		  range, 
		  med;
	string filename;

	// declares and opens file 
	fstream data;
	
	// gets the file name
	cout << "Enter Filename:  ";
	cin >> filename;
	system("cls");

	// reads the array, does calculations, write out the sorted array, 
	// then pauses the program so that I can clear the screen
	readarray(x, n, filename);
	stats(x, n, sum, avg, ss, std, range, med);
	writearray(x, n);
	system("pause");
	system("cls");
	
	// print outs the stats
	cout << left << setw(25) << "Average = " << setw(6) 
							 << setprecision(3) << fixed << right << avg << endl;
	cout << left << setw(25) << "Standard Deviation = " << setw(6) 
							 << setprecision(3) << fixed << right << std << endl;
	cout << left << setw(25) << "Range = " << setw(6) 
							 << setprecision(3) << fixed << right << range << endl;
	cout << left << setw(25) << "Median = " << setw(6) 
							 << setprecision(3) << fixed << right << med << endl;
	return 0;
}

void readarray(float x[], int &n, string &filename)
{
	// variables
	int i = 0;
	n = 50;
	
	// opens new file
	fstream data(filename.c_str());
	// validation structrure 
	while (!data) 
	{
		cout << "ERROR: Could Not Read File.  Make Sure It Exsits.\n";
		cout << "Enter Filename:  ";
		cin >> filename;
	}
	while (data)
	{
		// loops until the end of the file
		while(!data.eof())
		{
			data >> x[i];
			i++;
		}
		n = i;
		data.close();	// closes the data file
	}
	/*while (!data) 
	{
		cout << "ERROR: Could Not Read File.  Make Sure It Exsits.\n";
		cout << "Enter Filename:  ";
		cin >> filename;
	}*/
}

/*** Prints the sorted array ***/
void writearray(float x[], int n)
{
	for (int i = 0; i < n; i++)
	{
		cout << x[i] << endl;
	}
}

/*** Finds the stats for a a file ***/
void stats(float x[], int n, 
		   float &sum, float &avg, 
		   float &ss, float &std, 
		   float &range, float &med)
{
	// sums the entire contents of an array
	for (int k = 0; k < n; k++)
	{
		sum += x[k];
	}

	avg = sum / n;	// finds the average of the array

	// finds the standard deviation
	for (int j = 0; j < n; j++)
	{
		ss += pow((avg - x[j]), 2);
	}
	std = sqrt(ss / (n - 1));
	
	// sorts then finds the range
	sort(x, n);
	range = x[n - 1] - x[0];
	
	// finds if it is odd or even then finds the median
	if ((n % 2) == 0)
	{
		med = (x[n / 2] + x[(n / 2) - 1]) / 2;
	}
	else
	{
		med = x[(n - 1) / 2];
	}
	
}

void sort(float x[], int n) //Sequence Sort Function
{
	float min, temp;
	for(int m = 0; m < n - 1; m++)
	{
		min = x[m];
		for(int k = m + 1; k < n; k++)
		{
			if (x[k] < min)
			{
				temp = x[k];
				x[k] = min;
				min = temp;
			}
		}
		x[m] = min;
	}
}


