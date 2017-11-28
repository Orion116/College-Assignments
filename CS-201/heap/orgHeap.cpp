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
#include "heap.h"

Heap::Heap()
{
    maxHeap = 0;
    ItemType temp;

    for (int i = 1; i < HEAPSIZE; i++)
    {
        heap[i] = temp;
        // cout << "Number of i: " << i << " " << heap[i] << endl;
    }
    // cout << "maxHeap: " << maxHeap << endl; 
}

Heap::~Heap()
{
}

void Heap::insert(ItemType data)
{
    // variables
    int child, parent;
        
    // iterate the max of the heap at every insert
    maxHeap++;

    // cout << "if isFull() maxHeap: " << maxHeap << endl;
    
    // Check for full heap
    if (isFull())
    {
        // cout << "if isFull() maxHeap: " << maxHeap << endl;
        // cout << "This is a sign that the tank is full\n";
        return;
    }
    // cout << "insert() maxHeap: " << maxHeap << endl;
    

    // set the child to the max of the heap
    child = maxHeap;
    parent = child / 2;
    
    // Shuffle data up the heap
    while ((child > 1) && (heap[parent] < data))
    {
        // cout << "I am in the while loop\n";
        heap[child] = heap[parent];
        child = parent;
        parent = child / 2;
    }

    // Insert new entry in heap
    heap[child] = data;
    // cout << "insert() end of function maxHeap: " << maxHeap << endl;
}

void Heap::ExtractMax()
{   
    cout << "ExtractMax maxHeap: " << maxHeap << endl;
    ItemType nullItem, data;
    int parent = 1, largest = 0, left, right;
    // should swap heap with leaf
    // Check for empty heap
    if (isEmpty())
    {
        return;
    }
    // Save top of heap
    data = heap[1];

    // Swap last value into heap position
    heap[1] = heap[maxHeap];
    heap[maxHeap] = data;
    // heap[maxHeap] = heap[HEAPSIZE];
    maxHeap--;

    // Shuffle data down the heap
    
    while (parent != largest)
    {
        // Check left node
        largest = parent;
        left = parent * 2;
        right = (parent * 2) + 1;
        if ((left <= maxHeap) && (heap[left] > heap[largest]))
        {
            largest = left;
        }
        if ((right <= maxHeap) && (heap[right] > heap[largest])) // Check right node
        {
            largest = right;
        }
        // Swap data values if needed
        if (parent != largest)
        {
            nullItem = heap[parent];
            heap[parent] = heap[largest];
            heap[largest] = nullItem;
            parent = largest;
            largest = 0;
        }
    }
} 

void Heap::printAll()
{
    // prints the array
    
    for (int j = 1; j <= maxHeap; j++)
        cout << "\t" << heap[j] << endl;
}

void Heap::printEntireHeap()
{
    // prints the array
    for (int i = 0; i < HEAPSIZE; i++)
        cout << "\t" << heap[i] << endl;
        // cout << "Number of i: " << i << " " << heap[i] << endl;
}

int Heap::getSize()
{
    return maxHeap;
}

bool Heap::isEmpty()
{
    string exceptionString = "ERROR: Heap is Empty.\n";
    // cout << "isEmpty() maxHeap: " << maxHeap << endl;
    if (maxHeap == 0)
    {
        maxHeap = 0;
        throw exceptionString;
        return true;
    }
    else
    {
        return false;
    }
}

bool Heap::isFull()
{
    string exceptionString = "ERROR: Heap out of bounds.  You tried to add to many items the heap\n";
    // cout << "isFull() maxHeap: " << maxHeap << endl;
    if (maxHeap == HEAPSIZE)
    {
        //maxHeap = HEAPSIZE-1;
        throw exceptionString;
        return true;
    }
    else
    {
        return false;
    }
}

int Heap::parent(int elemt)
{
    return (elemt / 2);
}

int Heap::left(int elemt)
{
    return (elemt * 2);
}

int Heap::right(int elemt)
{
    return ((elemt * 2) + 1);
}

