#include <stdio.h>

int main()
{
    int x =10;
    int y = 11;
    int *p = &x;
    int *q = &y;

    printf("%d",(*q)++);
    
    
}