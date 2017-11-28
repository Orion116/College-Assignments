/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Programmer:         Joshua Wiley
 *  Course:             CSCI 201-001
 *  Semester:           Fall 2016
 *  Build Instructions: g++ -o Euclid euclid.cpp
 *  Execution Command:  ./Euclid
 *  Description:        This program is a generic queue that stores doubles.
 *                      You need a unix/linux compiler for C++ like g++.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */ 
 
#include <stdio.h>
#include <iostream>

using namespace std;

int GCD(int, int, int&);

int main()
{
    int num1, num2, depth, gcd;
    
    do
    {
        depth = 1;

        cout << "To terminate, enter 0 for either number\n\n";
        
        // choice
        cout << "Enter the first number: ";
        cin >> num1;
        cin.clear();
        
        cout << "Enter the second number: ";
        cin >> num2;
        cin.clear();

        gcd = GCD(num1, num2, depth);

        if ((num1 != 0) && (num2 != 0))
        {
            cout << "\nThe GCD of " << num2 << " and " << num1 << " is " << gcd << endl;
            cout << "The recursive calculation required a depth of " << depth << endl;
        }

    } while ((num1 != 0) && (num2 != 0));
 
    return(0);
}

int GCD(int num1, int num2, int &depth)
{
    if (num1 == 0) 
    {
        return num2;
    }
    else if (num2 == 0) 
    {
        return num1;
    }
    else if (num1 >= num2 && num2 > 0)
    {
        depth++;
        //cout << "\nnum1 >= num2 && num2 > 0\n";
        return GCD(num2, (num1 % num2), depth);
    }
    else if (num1 <= num2 && num1 > 0)
    {
        depth++;
        //cout << "\nnum1 <= num2 && num1 > 0\n";
        return GCD(num1, (num2 % num1), depth);
    }
}