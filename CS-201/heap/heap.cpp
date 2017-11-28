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
{    // set heap to 
    heapSize = 0;
}

Heap::~Heap()
{
}

void Heap::insert(ItemType data)
{
    // variables
    int child = 0, parent = 0;
     
    // Check for full heap
    if (heapSize == (MAX_HEAP_SIZE-1))
    {
        string exceptionString = "\nERROR: Heap out of bounds.  You tried to add to many items the heap\n";
        throw exceptionString;                                                                                                                                                                                
    }
     
    // iterate the max of the heap at every insert
    heapSize++;
    
    // set the child to the size of the heap
    child = heapSize;
    parent = child / 2;
    
    // Percolate up
    while ((child > 1) && (heap[parent] < data))
    {
        // cout << "\nM: " << heapSize << " HM: " << heap[heapSize] << "\nP: " << parent << " PH: " << heap[parent] << endl;
        heap[child] = heap[parent];
        child = parent;
        parent = child / 2;
    }

    // Insert new entry in heap
    heap[child] = data;
    
    // cout << "insert() end of function heapSize: " << heapSize << endl; 
          
}

void Heap::ExtractMax()
{   
    // Variables
    ItemType tempItem, data;
    int parent = 1, largest = 0, left, right;

    // should swap heap with leaf
    // Check for empty heap
    if (heapSize == 0)
    {
        string exceptionString = "\nERROR: Heap is Empty.\n";
        throw exceptionString;
        return;
    }
    // Save top of heap
    data = heap[1];

    // Swap last value into heap position
    heap[1] = heap[heapSize];
    heap[heapSize] = data;
    heapSize--;

    // flag to stop
    bool done = false;
    
    largest = parent;
    // Shuffle data down the heap
    while (!done)
    {
        left = parent * 2;
        right = (parent * 2) + 1;

        if (heap[left] > heap[largest])    // Check left node
        {
            largest = left;    // set the largest to to the left child
        }
        else if (heap[right] > heap[largest]) // Check right node
        {
            largest = right;    // set the largest to to the right child
        }    
        else
        {

            done = true;
        }
        if (largest != parent)
        {
            /* * * * * * * * * * * * * * * * * * * * * * * * * * * 
            *
            *    set the temp itemtype to the parent itemtype
            *    swap the largest itemtype to the parent itemtype
            *    swap the temp itemtype to largest 
            *    set the largest index to the parent index
            *    set the parent index to the largest and set 
            *    to 1
            *
             * * * * * * * * * * * * * * * * * * * * * * * * * * */
            tempItem = heap[parent];
            heap[parent] = heap[largest];
            heap[largest] = tempItem;
            parent = largest;
            largest = parent;
            parent = 1;
        }
    }   
} 

void Heap::printArray()
{
    // prints the array
    for (int j = 1; j <= heapSize; j++)
        cout << "\t" << heap[j] << endl;
        // cout << "\t" << heap[j] << endl;
        // cout << "Number of j: " << j << " " << heap[j] << endl;
        
}

void Heap::printEntireHeap()
{
    // prints the array
    for (int i = 0; i < MAX_HEAP_SIZE; i++)
        cout << "\t" << heap[i] << endl;
        // cout << "\t" << heap[i] << endl;
        // cout << "Number of i: " << i << " " << heap[i] << endl;
}

int Heap::getSize()
{
    return heapSize;
}
