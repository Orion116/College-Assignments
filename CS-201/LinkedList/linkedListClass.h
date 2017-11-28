#ifndef LINKEDLISTCLASS
#define LINKEDLISTCLASS

#include <iostream>
#include <fstream>
#include "itemType.h"

using namespace std;

class LinkedList
{
    public:
		LinkedList();
		~LinkedList();
		void insert(ItemType insertData);
		void remove(ItemType removeData);
		void printAll();
        bool isEmpty();

    private:
		struct LLNode
		{
		    ItemType data;
		    LLNode *next;
		};

		LLNode *head;
};

#endif