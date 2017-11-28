/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Programmer:         Joshua Wiley
 *  Course:             CSCI 201-001
 *  Semester:           Fall 2016
 *  Build Instructions: g++ -o app application.cpp heap.cpp itemType.cpp
 *  Execution Command:  ./app testdata.txt
 *  Description:        
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */ 
 
#include <iostream>
#include <fstream>
#include "itemType.h"
#include "heap.h"

using namespace std;

int main(int argc, char *argv[])
{
    Heap employees;
    ItemType fileData, retData;
    char command;
    ifstream infile;

    if (argc != 2)
    {
        cout << "ERROR: Wrong number of arguments\n";
        cout << "Usage: " << argv[0] << " <input filename>\n";
        return(-1);
    }
    else
    {
        cout << "Trying to open file " << argv[1] << endl;
        fflush(stdout);
        infile.open(argv[1]);
        if (infile.fail())
        {
            cout << "ERROR: Could not open file " << argv[1] << " for input.\n";
            return(-2);
        }
        cout << "Successfully opened.\n";
        fflush(stdout);
    }
    do
    {
        infile >> command;
        // cout << "\n" << command << endl;
        switch (command)
        {
            case 'i':
            case 'I':
                try
                {
                    //cout << "\nAt insert\n";
                    infile >> fileData;
                    employees.insert(fileData);
                    break;
                }
                catch (string exceptionString)
                {
                    // cout << "\n\nCaught You!!!\n\n\n";
                    cout << exceptionString;
                    break;
                }
                

            case 'e':
            case 'E':
                try
                {
                    employees.ExtractMax();
                    break;
                }
                catch (string exceptionString)
                {
                    cout << exceptionString;
                    break;
                }

            case 'p':
            case 'P':
            // call the print all method in the list
                cout << "\nItems in heap:\n";
                employees.printArray();
                break;

            case 'c':
            case 'C':
            // call the print all method in the list
                cout << "\nComplete heap:\n";
                employees.printEntireHeap();                
                break;

            case 's':
            case 'S':
            // call the print all method in the list
                cout << "\nThe size of the array is " << employees.getSize() << endl;               
                break;

            case 'q':
            case 'Q':
                break;

            default:
                cout << "ERROR: Bad command " << command << " in file " << argv[1] << endl;
                cout << "Shutting down...\n";
                command = 'q';
                break;

        }
    } while (command != 'q' && command != 'Q');
    // call our list's destructor
    employees.~Heap();
    
    infile.close();
    cout << "\nShutting down...\n";    

    // cout << employees << endl;

    return 0;
}
