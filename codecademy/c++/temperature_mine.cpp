#include <iostream>

//Temperature calculator found in Codecademy 'Learn C: Lesson 2'
//Things to add:
//1. Prompt user for either Fahrenheit or Celsius
//2. Give temperature in both the other 

int main() {
  
	// Declare variables
  
	double tempf, tempc;
	int option;
  
	// Ask the user
  
	std::cout << "Choose what calculation you'd like to run today (enter 1 or 2): \n";
	std::cout << "(1) Fahrenheit to Celsius \n";
	std::cout << "(2) Celsius to Fahrenheit \n";
	std::cin >> option;
  
	if (option == 1) {
	
		std::cout << "Enter the temperature in Fahrenheit: ";
		std::cin >> tempf;

		tempc = (tempf - 32) / 1.8;
  
		std::cout << "The temp is " << tempc << " degrees Celsius.\n";
	}
	else
		
		std::cout << "Enter the temperature in Celsius: ";
		std::cin >> tempf;

		tempf = (tempc * (9 / 5)) + 32;
  
		std::cout << "The temp is " << tempc << " degrees Fahrenheit.\n";
		
	}
  
}
