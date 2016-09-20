// ConsoleApplication1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <conio.h>
#include <iostream>
#include <array>
#include <string>


using namespace std;

int main()
{
	const char COLORS[] = { 'R','G','B','P','O','Y','W' };
	string Answer = "";
	for (int x = 0; x < 4; x++)
	{
		Answer += COLORS[rand() % 8];
	}
	string input = "";
	unsigned int correct = 0;
	unsigned int wrongSpot = 0;
	cout << "Welcome user to a Mastermind clone!" << endl;
	cout << "The colors that can be used are:" << endl;
	cout << "'R'=Red, 'G'=Green, 'B'=Blue, 'P'=Pink, 'O'=Orange, 'Y'=Yellow, 'W'=White." << endl;
	cout << "Please input 4 colors and then press enter ex 'ROBP'." << endl;
	cout << "The computer will tell you how many are correct and how many are in the right place." << endl;
	while (input != Answer)
	{
		cout << "Please input 4 colors: ";
		cin >> input;
		for (int x = 0; x < 4; x++)
		{
			for (int y = 0; y < 4; y++)
			{
				if (input.at(x) == Answer.at(y)&& x!=y)
				{
					wrongSpot++;
				}
			}
			if (input.at(x) == Answer.at(x))
			{
				correct++;
			}
		}
		cout << "You have " << correct << " in the correct spot and " << wrongSpot << " in the wrong spot but right color." << endl;
		correct = 0;
		wrongSpot = 0;

	}

    return 0;
}

