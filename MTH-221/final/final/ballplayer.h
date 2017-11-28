//ballplayer.h - declare the class for basketball players
// Joshua Wiley
// mth22113

#include <fstream>
#include <iostream>
using namespace std;

class ballplayer
{
private:
	char name[11];
	float gp, twoa, twom, treya, 
		  treym, fta, ftm, assists, 
		  oreb, ppg, fgpct, ftpct, 
		  treypct, apg, orpg, oindex;
	
public:
	friend ifstream& operator >> (ifstream&, ballplayer&);
	friend ostream& operator << (ostream&, ballplayer);
	void sort(ballplayer[], int);
};