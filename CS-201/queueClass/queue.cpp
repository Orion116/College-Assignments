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

#include "appData.h"
#include "queue.h"

Queue::Queue()
{
    front = back = NULL;
}

Queue::~Queue()
{
#if DEBUG
    cout << "Destructor "<< endl;
#endif
    // deleteAll() code should be in here!!!
    //    cout << ("front: %p back: %p\n", *front, *back);
    // sets the queue to null 
    QueueNode *current;
    
    current = front;
    
    // set the temp to the front of the queue.  Then loop while the temp
    // is not null.  And end once it reaches null
    while (!isEmpty())
        dequeue();

    front = back = NULL;
        
    return;
}

bool Queue::isEmpty()
{
    return(front == NULL);
}

void Queue::enqueue(AppData ndata)
{
#if DEBUG
    cout << "Enqueue data: " << ndata << endl;
#endif
    // Code for enqueue()
    QueueNode *newNode = NULL;  

    // QueueNode to hold new appData to queue
    newNode = new QueueNode;
    newNode->item = ndata;
    newNode->next = NULL;

    if (isEmpty())
    {   
        front = back = newNode;
    }
    else 
    {
        (back)->next = newNode;
        back = newNode;
    }
    cout << "\nData in queue: " << newNode->item << "\n\n";
 
    return;
}

AppData Queue::dequeue()
{
    AppData tempData;
    QueueNode *tempNode;

    if (!isEmpty())
    {
        // Grab the data out of the first item
        // and put it in the dummy variable
        tempData = front->item;
        
        tempNode = front;
        front = front->next;
        tempNode->next = NULL;
        
        // Check if we should set tail to NULL
        if (front == NULL)
        {
            back = NULL;
        }
        delete(tempNode);
    }
    else
    {
        cout << "\n\tQueue is empty.\n";
    }
#if DEBUG
    cout << "Denqueue data: " << tempData.getData() << endl;
#endif

    return(tempData);
}

void Queue::printAll()
{
#if DEBUG
    cout << "Dumping the queue...\n";
#endif
    // Code for printAll

    QueueNode *current;

    cout << "Data in queue:\n";
    
    if (isEmpty())
    {
        cout << "\n\tQueue is empty.\n\n";
    }
    else
    {
        for (current=front; current != NULL; current=current->next)
            cout << "\n\tData: " << current->item;  

        cout << "\n\n";        
    }

    return;
}