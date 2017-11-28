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

struct queueNode
{
    double appData;
    queueNode *next;
};

void deleteAll(queueNode **front, queueNode **back);
bool isEmpty(queueNode *front, queueNode *back);
void printAll(queueNode *front, queueNode *back);
double dequeue(queueNode **front, queueNode **back);
void enqueue(queueNode **front, queueNode **back, queueNode insertData);
