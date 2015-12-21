// binary search and sort.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include <iostream>
#include <string>
#include <array>
#include <vector>
#include <fstream>
#include <sstream>
#include <algorithm>
using namespace std;
void quicksort(vector<string> &, vector<string>::iterator min, vector<string>::iterator max);
vector<string>::iterator partition(vector<string> &, vector<string>::iterator min, vector<string>::iterator max);

vector<string> &split(const std::string &s, char delim, std::vector<std::string> &elems);
int _tmain(int argc, _TCHAR* argv[])
{
	bool boolean = false;
	ifstream fin;
	/*
	Things I am trying to do
	while(user doesn't quit)
	{
		cout << "user help"
		getline(cin, input);
		if quit then break
		input.lowercase
		send input to and increase array size
	}
	send to function quicksort
	ask what to search for
	input goes to binarysearch function
	*/
	string fileinput;
	int i = 0;
	vector<string> stringInput;
	fin.open("Array File.txt");
	cout << "Inputed strings already included: \n";
	if (fin.fail())
	{
		cout << "File opening error" << endl;
	}
	else
	{
		while (getline(fin, fileinput))
		{
			cout << fileinput << endl;
			split(fileinput, ' ', stringInput);
		}
	}
	fin.close();
	string input;
	i = stringInput.size()+1;
	
	while( input != "q" || input != "Q")
	{
		cout << "Print a word to put into a sorted array(type q press enter to submit): ";
		getline(cin, input);
		if (input == "q" || input == "Q")
		{
			boolean = true;
			break;
		}
			
		transform(input.begin(), input.end(), input.begin(), tolower);
		stringInput.push_back(input);
		i++;
		stringInput.resize(i+1);
		boolean = false;
	}
	int max = i-1;
	//before quicksort
	/*for (int j = 0; j < max; j++)
	{
		cout << stringInput[j] << " ";
	}*/

	quicksort(stringInput, stringInput.begin(), stringInput.end());

	//after quicksort
	/*for (int j = 0; j < max+1; j++)
	{
		cout << stringInput[j] << " ";
	}*/
	vector<string>::iterator j = stringInput.begin();
	while (j != stringInput.end())
	{
		if (j->find(' ', 0) != string::npos)
		{
			j = stringInput.erase(j);
		}
		else
		{
			++j;
		}
	}
	ofstream fout;
	fout.open("Array File.txt");
	if (fout.is_open())
	{
		for (vector<string>::iterator k = stringInput.begin(); k != stringInput.end(); ++k)
		{
			if (i == 0)
			{
				stringInput.pop_back();
			}
			fout << *k << ' ';
		}
	}
	else
	{
		cout << "File could not be opened." << endl;
	}
	fout.close();
	int newint = 0;
	bool position_found = false;
	while (input != "q" || input != "Q")
	{
		position_found = false;
		cout << "\nPrint a word to find (type q press enter when you want to quit the program): ";
		getline(cin, input);
		if (input == "q" || input == "Q")
			break;
		transform(input.begin(), input.end(), input.begin(), tolower);
		for (vector<string>::iterator newoutput = stringInput.begin(); newoutput != stringInput.end(); ++newoutput)
		{
			if (*newoutput == input)
			{
				auto position = newoutput - stringInput.begin();
				cout << "The poisition of the string you inputted is at: " << position << endl;
				position_found = true;
			}
		}
		if (position_found = false)
		{
			cout << "The position of the string that you inputted is not in the array." << endl;
		}
		cout << endl ;
	}
	stringInput.clear();
	return 0;
}
void quicksort(vector<string>& Array1, vector<string>::iterator min, vector<string>::iterator max)
{
	vector<string>::iterator p;
	if(min < max)
	{ 
		p = partition(Array1, min, max);
		quicksort(Array1, min, p - 1);
		quicksort(Array1, p + 1, max);
	}
		
}
vector<string>::iterator partition(vector<string>& Array, vector<string>::iterator min, vector<string>::iterator max)
{
	string pivot = *max;
	string swap = "";
	vector<string>::iterator i = min;
	for (vector<string>::iterator j = min; j < max; ++j)
	{
		if (*j <= pivot)
		{
			swap = *i;
			*i = *j;
			*j = swap;
			++i;
		}
	}
	swap = *i;
	*i = *max;
	*max = swap;
	return i;
}
/*int binarysearch(vector<string> & Array2, string input, int min, int max, int mid1 = 0)
{
	while(min <= max)
	{
		mid1 = ((min + max) / 2);
		if (Array2[mid1] == input)
			return mid1;
		if (Array2[mid1] < input)
			min = mid1 + 1;
		else
			max = mid1 - 1;
	}
	return -1;
}*/
vector<string> &split(const string &s, char delim, vector<string> &elems)
{
	stringstream ss(s);
	string item;
	while (getline(ss, item, delim))
	{
		elems.push_back(item);
	}
	return elems;
}

