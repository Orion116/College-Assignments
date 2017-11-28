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
#include "BTree.h"

BTree::BTree()
{
    root = NULL;
}

BTree::~BTree()
{
    destructHelper(root);
}

void BTree::insert(ItemType data)
{
    insertHelper(root, root, data);
}

void BTree::remove(ItemType data)
{
    removeHelperRef(root, root, data);
}

ItemType BTree::find(ItemType data)
{
    return findHelper(root, data);
}

void BTree::printInOrder()
{
    printInOrderHelper(root);
}

void BTree::printPreOrder()
{
    printPreOrderHelper(root);
}

void BTree::printPostOrder()
{
    printPostOrderHelper(root);
}

bool BTree::isEmpty()
{
    return(root == NULL);
}

ItemType BTree::maxBTree()
{
    return maxBTreeHelper(root);
}

ItemType BTree::minBTree()
{
    return minBTreeHelper(root);
}

/*** Helper functions : keep private data private ***/

void BTree::destructHelper(BTreeNode *current)
{
    if (current != NULL)
    {
        // delete right and left as long as current is not NULL
        destructHelper(current->left);
        destructHelper(current->right);
        
        delete(current);
        root = NULL;    // delete root this is important
    }

    return;
}

void BTree::insertHelper(BTreeNode* &parent, BTreeNode *current, ItemType data)
{

    BTreeNode *newPtr;

    if (current == NULL)
    {
        // we have found the place to insert
        newPtr = new(BTreeNode);
        newPtr->appData = data;
        newPtr->left = NULL;
        newPtr->right = NULL;
        parent = newPtr;
    }
    else if (data < current->appData)
    {
        // do we go left?
        insertHelper(current->left, current->left, data);
    }
    else if (data > current->appData)
    {
        // do we go right?
        insertHelper(current->right, current->right, data);
    }
    else
    {
        // they are they equal?  Replace data
        current->appData = data;
    }
    
}

void BTree::removeHelperRef(BTreeNode* &parent, BTreeNode *current, ItemType data)
{
    if (current != NULL)
    {
        // as long as not null check for the correct case
        if (current->appData == data)
        {
            // if current appData is = to the data being past in 
            // set the data to the parent and continue 
            if ((current->left == NULL) && (current->right == NULL))
            {
                // no child case, null the parent and just free it
                parent = NULL;
                delete(current);
            }
            else if (current->left == NULL)
            {
                // set parent to the non-null child ptr
                // free node
                parent = current->right;
                delete(current);
            }
            else if (current->right == NULL)
            {
                // set parent to the non-null child ptr
                // free node
                parent = current->left;

                delete(current);
            }
            else
            {
                // the evil case : two child case
                BTreeNode *inOrderPred;

                // copy the current->left to the predecessor
                inOrderPred = current->left;
                while (inOrderPred->right != NULL)
                {
                    // loop while the predecessor is not null 
                    // copy the data from parent->right to the 
                    // predecessor node
                    inOrderPred = inOrderPred->right;
                }
                // set the current->appData to what was in the 
                // predecessor node
                current->appData = inOrderPred->appData;
                    
                // recurse on the left and send current->appData
                removeHelperRef(current->left, current->left, current->appData);
            }
        }
        else 
        {
            if (data > current->appData)
            {
                // if the data is greater then the data in the tree
                // then recurse on the right
                removeHelperRef(current->right, current->right, data);
            }
            else
            {
                // else recurse on the left
                removeHelperRef(current->left, current->left, data);
            }
        }
    }
    else
    {
        cout << "ERROR: In remove(), data not found\n";
    }    
}

ItemType BTree::findHelper(BTreeNode *current, ItemType data)
{
    ItemType findData;

    if (current == NULL)
    {
        // if null return the null value
        return findData;
    }
    else if (current->appData == data)
    {
        // if the current data is = to the data passed in
        // push return it
        findData = current->appData;
    }
    else if (data < current->appData)
    {
        // if the data passed it is greater 
        // than current recurse left
        findData = findHelper(current->left, data);
    }
    else
    {
        // else recurse right
        findData = findHelper(current->right, data);
    }

    return findData;
}

void BTree::printInOrderHelper(BTreeNode *current)
{
    if (current != NULL)
    {
        // print the left sub-tree
        // print root
        // print the right sub-tree
        printInOrderHelper(current->left);
        cout << current->appData << endl;
        printInOrderHelper(current->right);
    }
}

void BTree::printPreOrderHelper(BTreeNode *current)
{
    if (current != NULL)
    {
        // print root
        // print the left sub-tree
        // print the right sub-tree
        cout << current->appData << endl;
        printPreOrderHelper(current->left);
        printPreOrderHelper(current->right);
    }
}

void BTree::printPostOrderHelper(BTreeNode *current)
{
    if (current != NULL)
    {   
        // print the left sub-tree
        // print the right sub-tree 
        // print root 
        printPostOrderHelper(current->left);
        printPostOrderHelper(current->right);
        cout << current->appData << endl;
    }
}

ItemType BTree::maxBTreeHelper(BTreeNode *current)
{
    BTreeNode *maxPtr = current;
    ItemType maxData;

    if (current != NULL)
    {
        while (maxPtr->right != NULL)
        {
            // while max right is not null
            // copy data from right to the parent
            maxPtr = maxPtr->right;
        }
        // copy the data from max to itemtype
        maxData = maxPtr->appData;
    }

    return maxData;
}

ItemType BTree::minBTreeHelper(BTreeNode *current)
{
    BTreeNode *minPtr = current;
    ItemType minData;

    if (current != NULL)
    {
        while (minPtr->left != NULL)
        {
            // while min right is not null
            // copy data from right to the parent
            minPtr = minPtr->left;
        }
        // copy the data from min to itemtype
        minData = minPtr->appData;
    }

    return minData;
}