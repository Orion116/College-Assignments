// final.cpp : Defines the entry point for the console application.
// Joshua Wiley
// mth22113

#include "stdafx.h"
#include "ballplayer.h"
#include<fstream>
#include<iostream>
#include<iomanip>

using namespace std;


int ()
{
	// constant for the length of the array
	const int MAX_INDEX = 13;

	// open files
	ifstream bbPlayerFile("T:/final.dat");

	// create a ball player array
	ballplayer BBPlayers[MAX_INDEX];

	// read input file into ball players
	for (int i = 0; i < MAX_INDEX; i++)
	{
		bbPlayerFile >> BBPlayers[i];
	}

	// sort ball players in decsending order by offensive index
	BBPlayers[0].sort(BBPlayers, MAX_INDEX);

	// cout headers for the table
	cout << "\nNAME" << setw(15) 
		 << "FG PCT" << setw(9)
		 << "3 PT PCT" << setw(9)
		 << "FT PCT" << setw(9) 
		 << "ASTS/GM" << setw(9) 
		 << "OFF/GM" << setw(9)
		 << "PTS/GM" << setw(9)
		 << "INDEX" << setw(9) << endl;

	// output to console 
	for (int k = 0; k < MAX_INDEX; k++)
	{
		cout << BBPlayers[k];
	}

	return 0;
}