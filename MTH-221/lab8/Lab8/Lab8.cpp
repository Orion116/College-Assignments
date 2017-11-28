// Lab9.cpp : Defines the entry point for the console application.
// STARTING POINT FOR LAB 9
// Joshua Wiley
// mth221 13

/* 
	This program uses an if/else statement to assign a
	letter grade (A,B,C,D, or F) to a numeric test score.
*/

#include "stdafx.h"
#include<iostream>
using namespace std;


int _tmain(int argc, _TCHAR* argv[])
{
	int testScore;

	cout<<"Enter your test socre and I will tell you\n";
	cout<<"the letter grade you earned: ";
	cin>>testScore;
	if (testScore <= 60 && testScore > 0)
		cout<<"Your grade is F.\n";
	else if (testScore <= 70 && testScore > 60)
		cout<<"Your grade is D.\n";
	else if (testScore <= 80 && testScore > 70)
		cout<<"Your grade is C.\n";
	else if (testScore <= 90 && testScore > 80)
		cout<<"Your grade is B.\n";
	else if (testScore <= 100 && testScore > 90)
		cout<<"Your grade is A.\n";
	else
		cout<<"That is not a valid score.\n";

	return 0;
}

