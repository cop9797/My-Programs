// ConsoleApplication1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <math.h>
#include <cmath>
#include <algorithm>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{

	long long int x = 0;
	string Number1;
	string NumberString;
	bool is_used = false;
	bool is_zero = false;
	cout << "input number for conversion to text :  ";
	getline(cin, Number1);



	while (Number1 != "Quit" || Number1 != "quit")
	{
		NumberString = "";
		if (Number1.find('-') != std::string::npos)
		{
			Number1.erase(remove(Number1.begin(), Number1.end(), '-'), Number1.end());
			NumberString += "negative ";
		}
		x = stoll(Number1);
		Number1 = to_string(x);
		int place = 0;
		for (unsigned int i = 0; i < Number1.length(); i++)
		{
			place = Number1.length() - i - 1;

			is_used = false;
			is_zero = false;
			switch (Number1.at(i))
			{
			case '1':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "eleven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "twelve ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "thirteen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "fourteen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "fifteen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "sixteen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "seventeen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "eighteen ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "nineteen ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "ten ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}

				break;
			case '2':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "twenty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "twenty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "twenty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "twenty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "twenty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "twenty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "twenty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "twenty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "twenty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "twenty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '3':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "thirty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "thirty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "thirty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "thirty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "thirty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "thirty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "thirty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "thirty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "thirty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "thirty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '4':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "forty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "forty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "forty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "forty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "forty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "forty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "forty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "forty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "forty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "forty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '5':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "fifty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "fifty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "fifty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "fifty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "fifty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "fifty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "fifty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "fifty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "fifty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "fifty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '6':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "sixty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "sixty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "sixty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "sixty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "sixty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "sixty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "sixty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "sixty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "sixty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "sixty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '7':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "seventy-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "seventy-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "seventy-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "seventy-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "seventy-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "seventy-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "seventy-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "seventy-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "seventy-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "seventy ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '8':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "eighty-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "eighty-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "eighty-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "eighty-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "eighty-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "eighty-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "eighty-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "eighty-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "eighty-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "eighty ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '9':
				if (place % 3 == 1)//
				{
					if (Number1.at(i + 1) == '1')
					{
						NumberString += "ninety-one ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '2')
					{
						NumberString += "ninety-two ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '3')
					{
						NumberString += "ninety-three ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '4')
					{
						NumberString += "ninety-four ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '5')
					{
						NumberString += "ninety-five ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '6')
					{
						NumberString += "ninety-six ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '7')
					{
						NumberString += "ninety-seven ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '8')
					{
						NumberString += "ninety-eight ";
						i++;
						is_used = true;
					}
					else if (Number1.at(i + 1) == '9')
					{
						NumberString += "ninety-nine ";
						i++;
						is_used = true;
					}
					else
					{
						NumberString += "ninety ";
						i++;
						is_used = true;
						is_zero = true;
					}
				}
				break;
			case '0':
				break;
			}
			if ((Number1.length() - i) % 3 == 1 && (Number1.at(i) != '0' || is_used == true && is_zero == true))
			{
				if (is_used == false)
				{
					switch (Number1.at(i))
					{
					case '1':
						NumberString += "one ";
						break;
					case '2':
						NumberString += "two ";
						break;
					case '3':
						NumberString += "three ";
						break;
					case '4':
						NumberString += "four ";
						break;
					case '5':
						NumberString += "five ";
						break;
					case '6':
						NumberString += "six ";
						break;
					case '7':
						NumberString += "seven ";
						break;
					case '8':
						NumberString += "eight ";
						break;
					case '9':
						NumberString += "nine ";
						break;
					}
				}
				while (place > 1)
				{
					NumberString += "thousand ";
					place -= 3;
				}
			}
			if ((Number1.length() - i) % 3 == 0 && (Number1.at(i) != '0' || is_used == true && is_zero == true))
			{
				if (is_used == false)
				{
					switch (Number1.at(i))
					{
					case '1':
						NumberString += "one ";
						break;
					case '2':
						NumberString += "two ";
						break;
					case '3':
						NumberString += "three ";
						break;
					case '4':
						NumberString += "four ";
						break;
					case '5':
						NumberString += "five ";
						break;
					case '6':
						NumberString += "six ";
						break;
					case '7':
						NumberString += "seven ";
						break;
					case '8':
						NumberString += "eight ";
						break;
					case '9':
						NumberString += "nine ";
						break;
					}
				}
				NumberString += "hundred ";
				if (Number1.at(i + 1) == '0' && Number1.at(i + 2) == '0')
				{
					i += 2;
					place = Number1.length() - i;
					while (place > 1)
					{
						NumberString += "thousand ";
						place -= 3;
					}
				}
			}

		}
		cout << NumberString << endl;
		cout << "input number for conversion to text type 'quit' to quit :  ";
		getline(cin, Number1);
		if (Number1 == "quit" || Number1 == "Quit" || Number1 == "q" || Number1 == "Q")
		{
			return 0;
		}

	}
	return 0;
}

