#include <stdio.h>

struct queueNode
{
    double appData;
    queueNode *next;
};

void enqueue(queueNode **front, queueNode **back, queueNode insertData);
double dequeue(queueNode **front, queueNode **back);
void printAll(queueNode *front, queueNode *back);
void deleteAll(queueNode **front, queueNode **back);
bool isEmpty (queueNode *front, queueNode *back);
