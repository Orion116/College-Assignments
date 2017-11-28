/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Programmer:         Joshua Wiley
 *  Course:             CSCI 201-001
 *  Semester:           Fall 2016
 *  Build Instructions: 
 *  Execution Command:  
 *  Description:        
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */ 

#include <iostream>
#include "linkedListClass.h"

using namespace std;

LinkedList::LinkedList()
{
    head = NULL;
}

LinkedList::~LinkedList()
{
    LLNode *nodePtr;
    LLNode *nextNode;

    nodePtr = head;

    while (nodePtr != NULL)
    {
        nextNode = nodePtr->next;
        delete(nodePtr);
        nodePtr = nextNode;
    }
}

void LinkedList::insert(ItemType insertData)
{
    LLNode *insertNode;
    LLNode *insertPtr;
    LLNode *parent = NULL;

    insertNode = new LLNode;
    insertNode->data = insertData;

    if (head == NULL)
    {
        head = insertNode;
        insertNode->next = NULL;
    }
    else
    {
        insertPtr = head;
        parent = NULL;

        while (insertPtr != NULL && insertPtr->data < insertData)
        {
       	    parent = insertPtr;
            insertPtr = insertPtr->next;
        }
		
        if (insertPtr == NULL)
        {
            parent->next = new LLNode;
            parent = parent->next;
            parent->next = NULL;
            parent->data = insertData;		
        }
        else if (parent == NULL)
        {
            parent = new LLNode;
            parent->next = head;
            parent->data = insertData;
            head = parent;
        }
        else if (insertPtr->data == insertNode)  // This case checks for duplicate 
		{
            // Set insertPtr to a new node then set the new node to null
            // then you push the data from insertData to insertPtr
            // this will override data in insertPtr with the data in
            // insertData
            insertPtr->data = insertNode;

            return;
        }
		else
        {
            parent->next = new LLNode;
            parent = parent->next;
            parent->next = insertPtr;
            parent->data = insertData;
        }
    }
	
//    cout << "Insert not implemented\n";
}

void LinkedList::remove(ItemType removeData)
{
    LLNode *nodePtr;
    LLNode *parent;

    // if the list is empty abort operation
    if (isEmpty())
    {
        return;
    }

    // if the head is = to the data to be removed 
    // set nodePtr to head and set head to the new
    // item in the list then delete the nodePtr
    if (head->data == removeData)
    {
        nodePtr = head;
        head = head->next;
        delete(nodePtr);	
    }
    else
    {
        nodePtr = head;

        while (nodePtr != NULL && nodePtr->data != removeData)
        {
            parent = nodePtr;
            nodePtr = nodePtr->next;	
        }

        if (nodePtr != NULL)
        {
            parent->next = nodePtr->next;
            delete(nodePtr);   		
        }
        else
        {
            cout << "\nERROR: \nItem " << removeData << " not found\n";
            // ERROR message
        }
    }
}

void LinkedList::printAll()
{
    // declare a temp node to loop through
    LLNode *current;

    current = head;

    // print out the contains until null  
    while (current != NULL)
    {
        cout << current->data << endl;
        current = current->next;
    }
}

bool LinkedList::isEmpty()
{			// checks for empty head
    return(head == NULL);
}
