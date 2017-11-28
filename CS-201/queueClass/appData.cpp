/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Programmer:         Joshua Wiley
 *  Course:             CSCI 201-001
 *  Semester:           Fall 2016
 *  Build Instructions: g++ -o application queue.h queue.cpp application.cpp
 *  Execution Command:  ./application
 *  Description:        This program is a generic queue that stores doubles.
 *                      You need a unix/linux compiler for C++ like g++.
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */ 

#include <iostream>
#include <fstream>

using namespace std;

#include "appData.h"

AppData::AppData()
        : data(0)
{
}

AppData::~AppData()
{
}

AppData::AppData(const AppData &origElement)
{
    data = origElement.data;
}

const AppData & AppData::operator=(const AppData &rhs)
{
    if (this != &rhs)
    {
        data = rhs.data;
    }

    return *this;
}

double AppData::getData()
{
    return(data);
}

void AppData::setData(double nData)
{
    data = nData;
}

ostream& operator<<(ostream& out, const AppData &it)
{
    out << it.data;

    return out;
}

istream& operator>>(istream& in, AppData &it)
{
    double dummy;

    in >> dummy;
    it.data = dummy;

    return in;
}