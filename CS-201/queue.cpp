#include <stdlib.h> 
#include "queue.h"

void enqueue(queueNode **front, queueNode **back, queueNode insertData)
{
    queueNode *newNode = NULL;		// queueNode to hold new insertData to list

	// allocate new queueNode
	newNode = malloc(sizeof(queueNode));
	if (newNode == NULL)
		fprintf(stderr, "No memory is available.\n");
	else
	{
		// set data value of new queueNode to value in insertData
		newNode->appData = insertData.appData;

		// set next to NULL since queueNode is added to tail
		newNode->next = NULL;

		// if is empty, must set head and tail, else just append to tail
		if (isEmpty(*front, *back))
		{
			*front = newNode;
			*back = newNode;
		}
		else
		{
			(*back)->next = newNode;
			*back = (*back)->next;
		}
	}
    printf("\nIn stubbed out enqueue with data: AppData: %lf\n", insertData.appData);
    
    printf("\nfront: %lf back: %lf\n newNode: %lf", (*front)->appData, (*back)->appData, newNode->appData); 
        
    return;
}

double dequeue(queueNode **front, queueNode **back)
{
    double retVal = 0;
    printf("In stubbed out dequeue\n");
    printf("front: %p back: %p\n", *front, *back);
    

    return(retVal);
}

void printAll(queueNode *front, queueNode *back)
{
    printf("In stubbed out printAll\n");
    printf("front: %p back: %p\n", front, back);
    
    queueNode *current;
    
    current = front;
    
    if (!isEmpty(front, back))
    {
        do
        {
            printf("AppData: %fl", current->appData);
            current = (*current).next;
        }while (current != NULL);
    }

    return;
}

bool isEmpty(queueNode *front, queueNode *back)
{
    printf("In stubbed out isEmpty\n");
    printf("front: %p back: %p\n", front, back);

    if (front == NULL)
        return true;
    else 
        return false;
}


void deleteAll(queueNode **front, queueNode **back)
{
    printf("In stubbed out deleteAll\n");
    printf("front: %p back: %p\n", *front, *back);

    return;
}
