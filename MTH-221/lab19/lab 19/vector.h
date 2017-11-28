// Joshua Wiley
// mth22113

#include "stdafx.h"
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;

class vector
{
	private:
		float xC, yC, zC;

	public:
		friend ostream& operator << (ostream&, vector&);
		friend ifstream& operator >> (ifstream&, vector&);
		vector operator + (vector);
		vector operator - (vector);
			// I used the "/" because the "#" is resevered for includes
		vector operator / (vector);  
		float operator * (vector);
		
};