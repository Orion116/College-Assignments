// Sort.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>

using namespace std;

void cbsort(float[],int);
void bsort(float[],int);
void ssort(float[],int);

int _tmain(int argc, _TCHAR* argv[])
{
	const int n=10;
	int choice;
	float x[n]={9,8,9.1,6,5,4,3,2,9.2,6};

	cout<<"Input your choice\n 1.  Crude Bubble Sort\n 2.  Modified Buble Sort\n 3.  Selection Sort\n";
	cin>>choice;
	system("cls");
	switch (choice)  // Uses only the sort the user chooses
	{
		case 1:
			cbsort(x,n);
			break;
		case 2:
			bsort(x,n);
			break;
		case 3:
			ssort(x,n);
			break;
		default:
			cout<<"Dumbkopf"<<endl;
			exit(0);
	}
	for(int i=0;i<10;i++)
		cout<<x[i]<<endl;
	
	return 0;
}

void ssort(float x[],int n) //Sequence Sort Function
{
	float min, temp;
	for(int m=0;m<n-1;m++)
	{
		min=x[m];
		for(int k=m+1;k<n;k++)
		{
			if(x[k]<min)
			{
				temp=x[k];
				x[k]=min;
				min=temp;
			}
		}
		x[m]=min;
    }
}

void cbsort(float x[], int n) // Crude Bubble Sort Function with max iterations
{
	float test1,test2;
	int cntr, cntr2;
	for(cntr2=0;cntr2<n-1;cntr2++)
	{
		for(cntr=0;cntr<n-1;cntr++)
		{
			test1=x[cntr];
			test2=x[cntr+1];
			if(test2<test1)
			{
				x[cntr]=test2;
				x[cntr+1]=test1;
			}
		}
	}
}

void bsort(float x[], int n) // Bubble Sort Function stopping when done
{
	bool swap;
	float test1,test2;
	int cntr;
	
	do
	{
		swap=false;
		for(cntr=0;cntr<n-1;cntr++)
		{
			test1=x[cntr]; 
			test2=x[cntr+1];
			if(test2<test1)
			{
				x[cntr]=test2;
				x[cntr+1]=test1;
				swap=true;
			}
		}
	}while(swap);
}
