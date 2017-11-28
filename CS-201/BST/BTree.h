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
#include "itemType.h"

#ifndef BTREE
#define BTREE

class BTree
{
    public:
        BTree();
        ~BTree();
        void insert(ItemType data);
        void remove(ItemType data);
        ItemType find(ItemType data);
        void printInOrder();
        void printPreOrder();
        void printPostOrder();
        bool isEmpty();
        ItemType maxBTree();
        ItemType minBTree();

    private:
        struct BTreeNode
        {
            ItemType appData;
            BTreeNode *left, *right;
        };

        BTreeNode *root;

        void destructHelper(BTreeNode *current);
        void insertHelper(BTreeNode* &parent, BTreeNode *current, ItemType data);
        void removeHelperRef(BTreeNode* &parent, BTreeNode *current, ItemType data);
        void removeHelperCWay(BTreeNode **parent, ItemType data);
        ItemType findHelper(BTreeNode *current, ItemType data);
        void printInOrderHelper(BTreeNode *current);
        void printPreOrderHelper(BTreeNode *current);
        void printPostOrderHelper(BTreeNode *current);
        ItemType maxBTreeHelper(BTreeNode *current);
        ItemType minBTreeHelper(BTreeNode *current);
};

#endif