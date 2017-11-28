#ifndef ITEMTYPE
#define ITEMTYPE

#include <iostream>
#include <iomanip>
#include <istream>
#include <fstream>

using namespace std;

const int NAMESIZE = 25;

class ItemType
{
    public:
    	ItemType();
    	~ItemType();
    	ItemType(const ItemType & item);
    	void getLName(char destName[]);
    	void setLName(char theName[]);
    	void getFName(char destName[]);
    	void setFName(char theName[]);
    	double getSalary();
    	void setSalary(double newValue);
    	long getID();
    	void setID(long newID);
    	const ItemType operator=(const ItemType & rhs);
    	friend bool operator<(const ItemType &lhs, const ItemType &rhs);
    	friend bool operator>(const ItemType &lhs, const ItemType &rhs);
    	friend bool operator<=(const ItemType &lhs, const ItemType &rhs);
    	friend bool operator>=(const ItemType &lhs, const ItemType &rhs);
    	friend bool operator==(const ItemType &lhs, const ItemType &rhs);
    	friend bool operator!=(const ItemType &lhs, const ItemType &rhs);
    	friend ostream & operator<< (ostream & output, const ItemType & item);
    	friend istream & operator>> (istream & input, ItemType & item);
	private:
		long id;
		double salary;
		char lname[NAMESIZE+1];
		char fname[NAMESIZE+1];
};

#endif
