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

#ifndef QUEUE
#define QUEUE
#define DEBUG 0

#include "appData.h"
class Queue
{
    public:
        Queue();                // Constructor
        ~Queue();               // Destructor
        bool isEmpty();         // Empty queue test
        void enqueue(AppData data);     // Insert data into the queue
        AppData dequeue();      // Delete data from the queue
        void printAll();        // Prettyprint the contents of the queue

    private:
        struct QueueNode
        {
            AppData item;
            QueueNode *next;
        };

        QueueNode *front, *back;
};
#endif