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
#include "itemType.h"

#ifndef HEAP
#define HEAP

const int MAX_HEAP_SIZE = 17;

class Heap
{
    public:
        Heap();
        ~Heap();
        void insert(ItemType data);
        void ExtractMax(); // should swap root with leaf
        void printArray();  // prints the array
        void printEntireHeap(); 
        int getSize();    
       
    private:     
        ItemType heap[MAX_HEAP_SIZE];
        int heapSize;
};

#endif