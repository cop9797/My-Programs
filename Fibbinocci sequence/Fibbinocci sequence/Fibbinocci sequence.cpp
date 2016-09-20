/*
Henry Hitchcock
Fibbinocci sequence with arrays in c++
8/25/2016
*/
#include "stdafx.h"
#include <iostream>
#include <conio.h>


using namespace std;


int main()
{
	long long int f[3];
	f[0] = 1;
	f[1] = 1;
	f[2] = f[0] + f[1];
	int number = 0;
	cout << "What number in the fibbinocci sequence do you want to see? : ";
	cin >> number;
	switch (number) {
		case 1: cout << "Your number is " << f[0] << endl;
			break;
		case 2: cout << "Your number is " << f[1] << endl;
			break;
		case 3:cout << "Your number is " << f[2] << endl;
			break;
		default:
			for (int y = 3; y < number; y++)
			{
				if (y % 2 == 0) {
					f[0] = f[2];
				}
				if (y % 2 == 1) {
					f[1] = f[2];
				}
				f[2] = f[0] + f[1];
			}
		cout << "Your number is " << f[2] << endl;
		break;
	}

	
	_getch();

	return 0;
}

