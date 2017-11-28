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
#include <stdlib.h> 
#include "queue.h"

void enqueue(queueNode **front, queueNode **back, queueNode insertData)
{
    queueNode *newNode = NULL;  // queueNode to hold new appData to queue

    // allocate memory to new queueNode
    newNode = (queueNode*) malloc(sizeof(queueNode));

    // set data value of new queueNode to the value stored in insertData
    newNode->appData = insertData.appData;

    // set next to NULL since queueNode is added to back
    newNode->next = NULL;

    // if is empty, must set front and back, else just append to tail
    if (isEmpty(*front, *back))
    {
        *front = *back = newNode;
    }
    else
    {
        (*back)->next = newNode;
        *back = (*back)->next;
    }
    printf("\nData in queue: %lf\n\n", insertData.appData);
    
    //printf("\nfront: %lf back: %lf\n newNode: %lf", 
    //      (*front)->appData, (*back)->appData, newNode->appData);  
             
    return;
}

double dequeue(queueNode **front, queueNode **back)
{
    double data = 0;
        
    queueNode *tempNode;        // pointer to queueNode to be dequeued
    
    if (isEmpty(*front, *back))
    {
        printf("\nQueue is empty.  Add some data to the queue.");
    }
    else if (*front != *back) // queuefront is not equal to queueback
    {
        /*
         *  set the data to a variable to return to the application
         *  set the tempNode to the front
         *  push the front to next which is null
         *  free the tempNode from memory
         */
        data = (*front)->appData;
        tempNode = *front;
        *front = (*front)->next;
        free(tempNode);
    }
    else
    {
        /*
         *  special case dequeue for last node in a queue
         *  set the data from front to the return to the application
         *  free front from memory
         *  null out the data in back and front
         */
        data = (*front)->appData;
        free(*front);
        *back = *front = NULL;
    }

    return(data);
}

void printAll(queueNode *front, queueNode *back)
{
    queueNode *current;

    printf ("Data in queue:\n");
    
    if (isEmpty(front, back))
    {
        printf("\nQueue is empty.\n\n");
    }
    else
    {
        for (current=front; current != NULL; current=current->next)
             printf("\tData: %lf\n", current->appData);    
    }

    return;
}

bool isEmpty(queueNode *front, queueNode *back)
{
    return front == NULL;
}


void deleteAll(queueNode **front, queueNode **back)
{
//    printf("front: %p back: %p\n", *front, *back);
    // sets the queue to null 
    queueNode *current;
    
    current = *front;
    
    // set the temp to the front of the queue.  Then loop while the temp
    // is not null.  And end once it reaches null
    while (!isEmpty(*front, *back))
        dequeue(front, back);

    *front = *back = NULL;
    
//    printf("front: %p back: %p\n", *front, *back);     
        
    return;
}
