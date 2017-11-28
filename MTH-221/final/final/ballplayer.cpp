// Joshua Wiley

#include "stdafx.h"
#include "ballplayer.h"
#include <fstream>
#include <iomanip>

ifstream& operator >> (ifstream& infile, ballplayer& p)
{
	// Sets the private variables from a .dat file
	char string1[80], string2[80];
	infile.get(p.name, 11);
	infile.getline(string1,80);
	infile >> p.gp >> p.twoa >> p.twom >> p.treya >> p.treym;
	infile >> p.fta >> p.ftm >> p.assists >> p.oreb;
	infile.getline(string2,80);

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	*
	*	Calculates the points per game, field goals percentage,
	*	free throw percentage, 3 point basket percentage, assists
	*	per game, offensive rebounds/ game, and offensive index in
	*	in the order above.
	*
	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	p.ppg = (2 * p.twom + 3 * p.treym + p.fta) / p.gp;
	p.fgpct = ((p.twom + p.treym) * 100) / (p.twoa + p.treya);
	p.ftpct = p.ftm * 100 / p.fta;
	p.treypct = p.treym * 100 / p.treya;
	p.apg = p.assists / p.gp;
	p.orpg = p.oreb / p.gp;
	p.oindex = 2 * p.apg + p.ppg + 1.2 * p.orpg;

	return infile;
}

ostream& operator << (ostream& cout, ballplayer p1)
{
	// prints the table of players
	cout << setw(15) << left << p1.name  
		 << setw(9) << setprecision(1) << fixed << p1.fgpct 
		 << setw(9) << setprecision(1) << fixed << p1.treypct 
		 << setw(9) << setprecision(1) << fixed << p1.ftpct 
		 << setw(9) << setprecision(1) << fixed << p1.apg 
		 << setw(9) << setprecision(1) << fixed << p1.orpg 
		 << setw(9) << setprecision(1) << fixed << p1.ppg
		 << setw(9) << setprecision(1) << fixed << p1.oindex << endl;

	return cout;
}
void ballplayer::sort(ballplayer player[], int n) //Sequence Sort Function
{
	ballplayer max, temp;
	for(int m = 0; m < n - 1; m++)
	{
		max = player[m];
		for(int k = m + 1; k < n; k++)
		{
			if (player[k].oindex > max.oindex)
			{
				temp = player[k];
				player[k] = max;
				max = temp;
			}
		}
		player[m] = max;
	}
}
