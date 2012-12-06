#include <iostream>
#include <stdio.h>
#include <fstream>
#include <string>
#include <stdlib.h>
 
using namespace std;

int readInt()
{
	 
	string line = "";
	char c;
	while(cin.get(c) && (c != ' ' && c != '\n'))
   	{
	 line += c;
	}
 
	return atoi(line.c_str());
}

void printTestFile()
{
	int max = 10000000;
    cout<<max<<" "<<2<<"\n";
 
    for(int i = 0; i <= max; i++)
    {
	  cout<<i<<"\n";
    }
}

int main(int argc, char *argv[]) {
	
char c;	
int length = 0;
 
int testCases, divisor, currentValue;
 
scanf("%d %d",&testCases, &divisor);
 
int divisibleCount = 0;
for(int i = 0; i < testCases; ++i)
{
    scanf("%d",&currentValue);
 
	if(currentValue % divisor == 0)
	{
		++divisibleCount;
	}
}

    cout<<divisibleCount;
    //printTestFile();
 	return 0;
}
