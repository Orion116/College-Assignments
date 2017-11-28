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

int main()
{
    queueNode inData, *front = NULL, *back = NULL;
    double myDouble;
    char inChar;
    bool empty;

    do
    {
        // menu
        printf("Please select one of the following:\n");
        printf("\te/E - Enqueue data\n");
        printf("\td/D - Dequeue data\n");
        printf("\tp/P - Print the contents of the queue\n");
        printf("\ti/I - Check for an empty queue\n");
        printf("\tq/Q - Quit program\n");
        
        // choice
        printf("Selection? ");
        scanf("%c", &inChar);
        fflush(stdin);
        
        switch (inChar)
        {
            case 'e':
            case 'E':
                printf("\nPlease enter the real number to enqueue: ");
                scanf("%lf", &inData.appData);
                fflush(stdin);
                enqueue(&front, &back, inData);
            break;

            case 'd':
            case 'D':
                myDouble = dequeue(&front, &back);
                printf("\nThe Dequeue value was: %lf\n\n", myDouble);
            break;

            case 'p':
            case 'P':
                printAll(front, back);
            break;

            case 'i':
            case 'I':
                empty = isEmpty(front, back);
                if (empty)
                    printf("\nQueue is empty.\n\n");
                else
                    printf("\nQueue is not empty.\n\n");
            break;

            case 'q':
            case 'Q':
                printf("\nQuitting program & freeing memory.\n");
                printAll(front, back);
                printf("\nMemory Freed!\n");            
                deleteAll(&front, &back);
            break;

            default:
                printf("ERROR: Bad selection %c\n", inChar);
            break;
        }
    } while (inChar != 'Q' && inChar != 'q');
 
    return(0);
}
