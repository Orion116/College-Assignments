// lab 12.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth221 13

//#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
#include<cmath>
using namespace std;

float ln(float);
int main()
{
	// variables 
	int choice;
	float value, sum = 0, avg, x, nLog;

	// declares and opens file 
	ifstream datFile;
	//datFile.open("T:/lab12.dat");
	datFile.open("/home/orion116/Desktop/Misc/C++/lab 12/lab 12/lab12.txt");

	// menu options
	cout << "Do you want to read from a file or find the natural log?\n";
	cout << "\n1. Read From File\n2. Find the Natural Log\n";

	cout << "\nEnter Your Choice: ";
	//cin >> choice;
	//system("cls");
	choice = 2;

	// Choice structrure 
	if (choice == 1)
	{
		// reads the file and sums all the numbers
		int i = 0; 

		while(datFile >> value)
		{
			i++;
			sum += value;
		}
		avg = sum / i;
		cout << "Average: " << setprecision(1) << fixed << right << avg << endl; 
		datFile.close();
	}
	else if (choice == 2)
	{
		// User input
		cout << "Enter LOG:  ";
		cin >> x;

		// variable check loop
		while (x < .2 || x > 1.8)
		{
			cout << "\nInvalid LOG!  Please Enter a Valid Number Between 0.2 & 1.8.\n\n";
			cout << "Enter LOG: ";
			cin >> x;
		}
		nLog = ln(x);
		cout << "The Natural Log is " << nLog << endl;
	}
	else  // insult 
	{
		cout << "\nInvalid Option! Please enter a valid one.\n";
		cout << "\n1. Read From File\n2. Find the Natural Log\n";

		cout << "\nEnter Your Choice: ";
		cin >> choice;
	}
	
	return 0;
}

/*** Finds the Natural Log ***/
float ln(float x)
{
    float nLog = 0;
    for(int c = 100; c >= 1; c--)//>= added DR
    {
        nLog += pow((1 - x), c) / (-c);
    }
    return nLog;
}
