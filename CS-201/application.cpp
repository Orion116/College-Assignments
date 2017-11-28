#include <stdio.h>
#include "queue.h"

using namespace std;

int main()
{
    queueNode inData, *front = NULL, *back = NULL;
    double myDouble;
    char inChar;
    bool empty;

    do  //print menu
    {
        printf("Select one of the following:\n");
        printf("\te/E - Enqueue Data\n");
        printf("\td/D - Dequeue Data\n");
        printf("\tp/P - Print Queue\n");
        printf("\ti/I - Check Queue\n");
        printf("\tq/Q - Quit the program\n");
        printf("Selection? ");
        scanf("%c", &inChar);
        fflush(stdin);
        
        switch (inChar)
        {
            case 'e':
            case 'E':
                printf("Please enter a real number to enqueue: ");
                scanf("%lf", &(inData.appData));
                printf("Enqueue number is: %f", inData.appData);
                enqueue (&front, &back, inData);
                fflush(stdin);
                break;
                
            case 'd':
            case 'D':
                printf("Prints what was dequeued\n");
                myDouble = dequeue(&front, &back);
                break;
                
            case 'p':
            case 'P':
                printf("Prints entire queue\n");
                printAll(front, back);
                break;
                
            case 'i':
            case 'I':
                printf("Checks for empty queue\n");
                empty = isEmpty(front, back);
                break;
            
            case 'q':
            case 'Q':
                break;
            
            default:
                printf("ERROR: invalid option");
                deleteAll(&front, &back);
                break;
        }
    }while(inChar != 'Q' && inChar !='q');

    return(0);
}
