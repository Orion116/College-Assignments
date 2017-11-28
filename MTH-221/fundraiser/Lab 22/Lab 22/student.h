/**************************************************
*	
*	This header file is for the student 
*	fundraiser project
*
**************************************************/
// Joshua Wiley
// mth22113

#include <fstream>
#include <iostream>

using namespace std;

class student
{
private:

	char name[30];
	int appleboxes, orangeboxes, grapeboxes;

public:
	
	int  trevenue;
	friend ifstream& operator >> (ifstream&, student&);
	friend ofstream& operator << (ofstream&, student&);

	void revenue();
	void sort(student[], int);
	float totalRevenue(student[], int);
};