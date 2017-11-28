/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Programmer:         Joshua Wiley
 *  Course:             CSCI 201-001
 *  Semester:           Fall 2016
 *  Build Instructions: g++ -o application queue.h queue.cpp application.cpp
 *  Execution Command:  ./application
 *  Description:        This program is a generic queue that stores doubles.
 *                      You need a unix/linux compiler for C++ like g++.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */ 
 
#include <stdio.h>
#include "queue.h"

using namespace std;

int main()
{
    Queue queueData;
    AppData myData;
    char inChar;
    bool empty;

    do
    {
        // menu
        cout << "Please select one of the following:\n";
        cout << "\te/E - Enqueue data\n";
        cout << "\td/D - Dequeue data\n";
        cout << "\tp/P - Print the contents of the queue\n";
        cout << "\ti/I - Check for an empty queue\n";
        cout << "\tq/Q - Quit program\n";
        
        // choice
        cout << "Selection? ";
        cin >> inChar;
        cin.clear();
        
        switch (inChar)
        {
            // enqueue data
            case 'e':
            case 'E':
                cout << "\nPlease enter the real number to enqueue: ";
                cin >> myData;
                cin.clear();
                queueData.enqueue(myData);
            break;
            
            // delete the front of the queue and displays it
            case 'd':
            case 'D':
                myData = queueData.dequeue();
                cout << "\nThe Dequeue value was: " << myData << "\n\n";
            break;

            // prints the queue
            case 'p':
            case 'P':
                queueData.printAll();
            break;

            // checks to see if the queue is empty
            case 'i':
            case 'I':
                empty = queueData.isEmpty();
                if (empty)
                    cout << "\t\nQueue is empty.\n\n";
                else
                    cout << "\t\nQueue is not empty.\n\n";
            break;

            // exits the program and frees the memory
            case 'q':
            case 'Q':
                cout << "\nQuitting program & freeing memory.\n";
                queueData.~Queue();
                cout << "\nMemory Freed!\n";            

            break;

            default:
                cout << "\n\nERROR: Bad selection " << inChar << endl;
            break;
        }
    } while (inChar != 'Q' && inChar != 'q');
 
    return(0);
}