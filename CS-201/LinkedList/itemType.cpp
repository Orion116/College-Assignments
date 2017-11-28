#include <iostream>
#include <string.h>
#include "itemType.h"

using namespace std;

ItemType::ItemType()
{
    fname[0] = '\0';
    lname[0] = '\0';
    id = -1;
    salary = 0;
}

ItemType::~ItemType()
{
    id = -1;
    salary = 0;
    lname[0] = '\0';
    fname[0] = '\0';
}

ItemType::ItemType(const ItemType & item)
{
    id = item.id;
    salary = item.salary;
    strncpy(lname, item.lname, NAMESIZE+1);
    strncpy(fname, item.fname, NAMESIZE+1);
}

void ItemType::getLName(char destName[])
{
    strncpy(destName, lname, NAMESIZE+1);
    return;
}

void ItemType::setLName(char theName[])
{
    strncpy(lname, theName, NAMESIZE+1);

    return;
}

void ItemType::getFName(char destName[])
{
    strncpy(destName, fname, NAMESIZE+1);
    return;
}

void ItemType::setFName(char theName[])
{
    strncpy(fname, theName, NAMESIZE+1);

    return;
}

double ItemType::getSalary()
{
    return(salary);
}

void ItemType::setSalary(double newValue)
{
    if (newValue >= 0)
	   salary = newValue;
    else
	   cout << "ERROR: Bad salary value " << newValue << " in setSalary()\n";

    return;
}

long ItemType::getID()
{
    return(id);
}

void ItemType::setID(long newID)
{
    if (newID > 0)
    {
	   id = newID;
    }
    else
    {
	   //Should throw an error, but we don't know how yet.
	   cout << "ERROR: ID numbers are not allowed to be negative\n";
    }
}

const ItemType ItemType::operator=(const ItemType &rhs)
{
    id = rhs.id;
    salary = rhs.salary;
    strncpy(lname, rhs.lname, NAMESIZE+1);
    strncpy(fname, rhs.fname, NAMESIZE+1);

    return *this;
}

bool operator<(const ItemType &lhs, const ItemType &rhs)
{
    int result;

    result = strncmp(lhs.lname, rhs.lname, NAMESIZE);
    if (result < 0)
	   return(true);
    else if (result > 0)
	   return(false);
    else
    {
        result = strncmp(lhs.fname, rhs.fname, NAMESIZE);
        if (result < 0)
	       return(true);
	    else if (result > 0)
	       return(false);
	    else 
	       return(lhs.id < rhs.id);
    }
}

bool operator>(const ItemType &lhs, const ItemType &rhs)
{
    return(rhs < lhs);
}

bool operator<=(const ItemType &lhs, const ItemType &rhs)
{
    return(!(rhs < lhs));
}

bool operator>=(const ItemType &lhs, const ItemType &rhs)
{
    return(!(lhs < rhs));
}

bool operator==(const ItemType &lhs, const ItemType &rhs)
{
    return(!(lhs < rhs) && !(rhs < lhs));
}

bool operator!=(const ItemType &lhs, const ItemType &rhs)
{
    return((lhs < rhs) || (rhs < lhs));
}

ostream & operator<< (ostream & output, const ItemType & item)
{
    output << item.lname << ", " << item.fname << " ID: " << item.id;
    output << " Salary: $" << fixed << setprecision(2) << item.salary;

    return(output);
}

istream & operator>> (istream & input, ItemType & item)
{
    input >> item.lname;
//    cout << item.lname << endl;
    fflush(stdout);

    input >> item.fname;
//    cout << item.fname << endl;
    fflush(stdout);

    input >> item.id;
//    cout << item.id << endl;
    fflush(stdout);

    input >> item.salary;
//    cout << item.salary << endl;
    fflush(stdout);

    return(input);
}
