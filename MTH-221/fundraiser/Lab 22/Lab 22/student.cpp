// file to contain the code for the functions for the student class
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "student.h"
#include<fstream>
#include<iomanip>

ifstream& operator >> (ifstream& studentFile, student& stu)
{
	// variable
	char string[80];

	// set the global variables
	studentFile.getline(stu.name, 30);
	studentFile >> stu.appleboxes >> stu.orangeboxes >> stu.grapeboxes;
	studentFile.getline(string, 80);

	return studentFile;
}

ofstream& operator << (ofstream& totalFile, student& stu)
{
	totalFile.open("T:/totalr.txt", ios::app);
	totalFile << "\nName: " << setw(30) << left << stu.name 
		      << "\nTotal Revenue: $" << setw(5) << right << stu.trevenue << endl;
	totalFile.close();
	return totalFile;
}

void student::revenue()
{
	// local constants
	const int appleRate = 25, orangesRate = 18, grapefruitRate = 22;
	int appleCost, orangesCost, grapeFruitCost;

	// calcuate the price of 
	appleCost = appleboxes * appleRate;
	orangesCost = orangeboxes * orangesRate;
	grapeFruitCost = grapeboxes * grapefruitRate;

	// set trevenue
	trevenue = appleCost + orangesCost + grapeFruitCost;

		/* * * Debugging * * */
	// int total = appleCost + orangesCost + grapeFruitCost;
	// cout << trevenue << endl;
}

float student::totalRevenue(student stu[], int n)
{
	float total = 0;

	/* * * * * * * * * * * * * * * * * * * * * * *
	*
	*	Note to Self: remember 'for-loop' and to 
	*	use 'i' in the array ;)
	*
	* * * * * * * * * * * * * * * * * * * * * * */
	for (int i = 0; i < n; i++)
	{
		total += stu[i].trevenue;
	}
	return total;
}

void student::sort(student stu[], int n) //Sequence Sort Function
{
	student max, temp;
	for(int m = 0; m < n - 1; m++)
	{
		max = stu[m];
		for(int k = m + 1; k < n; k++)
		{
			if (stu[k].trevenue > max.trevenue)
			{
				temp = stu[k];
				stu[k] = max;
				max = temp;
			}
		}
		stu[m] = max;
	}
}
