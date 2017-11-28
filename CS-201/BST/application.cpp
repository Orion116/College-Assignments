#include <iostream>
#include <fstream>
#include "itemType.h"
#include "BTree.h"

using namespace std;

int main(int argc, char *argv[])
{
    ItemType fileData, retData;
    char command;
    ifstream infile;
    BTree employees;

    if (argc != 2)
    {
        cout << "ERROR: Wrong number of arguments\n";
        cout << "Usage: " << argv[0] << " <input filename>\n";
        return(-1);
    }
    else
    {
        cout << "Trying to open file " << argv[1] << endl;
        fflush(stdout);
        infile.open(argv[1]);
        if (infile.fail())
        {
            cout << "ERROR: Could not open file " << argv[1] << " for input.\n";
            return(-2);
        }
        cout << "Successfully opened.\n";
        fflush(stdout);
    }
    do
    {
        infile >> command;
        //cout << "\n" << command << endl;
        switch (command)
        {
            case 'i':
            case 'I':
                infile >> fileData;
                employees.insert(fileData);
                break;

            case 'r':
            case 'R':
                infile >> fileData;
                employees.remove(fileData);
                break;

            case 'f':
            case 'F':
                infile >> fileData;
                retData = employees.find(fileData);
                if (retData.getID() == badID)
                    cout << "\nItem not found\n";
                else if (employees.isEmpty())
                    cout << "\nItem not found\n";
                else
                    cout << "\nItem " << retData << " found\n";
                break;

            case 'p':
            case 'P':
            // call the print all method in the list
                if (!employees.isEmpty())
                {
                    cout << "\nInOrder\n";
                    employees.printInOrder();
                }
                break;

            case 'b':
            case 'B':
            // call the print all method in the list
                if (!employees.isEmpty())
                {
                    cout << "\nPreOrder\n";
                    employees.printPreOrder();
                }
                break;
            
            case 'a':
            case 'A':
            // call the print all method in the list
                if (!employees.isEmpty())
                {
                    cout << "\nPostOrder\n";
                    employees.printPostOrder();
                }
                break;

            case 'e':
            case 'E':
            // call the is empty method in our list
                if (employees.isEmpty())
                    cout << "\nThe tree is empty\n";
                else
                    cout << "\nThe tree is not empty\n";
                break;

            case 'm':
            case 'M':
            // call the is empty method in our list
                if (employees.isEmpty())
                    cout << "The tree is empty\n";
                else
                    cout << "\nMaximum of the tree: " << employees.maxBTree() << endl;
                break;

            case 'n':
            case 'N':
            // call the is empty method in our list
                if (employees.isEmpty())
                    cout << "The tree is empty\n";
                else
                    cout << "\nMinimum of the tree: " << employees.minBTree() << endl;
                break;

            case 'd':
            case 'D':
                cout << "\nThe Destructor was called here.\n";
                employees.~BTree();

                if (employees.isEmpty())
                    cout << "\nThe tree is empty\n";
                else
                    cout << "\nThe tree is full of junk\n";
                break;

            case 'q':
            case 'Q':
                break;

            default:
                cout << "ERROR: Bad command " << command << " in file " << argv[1] << endl;
                cout << "Shutting down...\n";
                command = 'q';
                break;

        }
    } while (command != 'q' && command != 'Q');
    // call our list's destructor
    employees.~BTree();
    
    infile.close();
    cout << "\nShutting down...\n";
    return 0;
}