#include <iostream>

//Temperature calculator found in Codecademy 'Learn C: Lesson 2'
//This is my heavily modified version used to capture things that I learn
//Please check version history to see my progress in learning!

int main() {
  
	// Declare variables
  
	double tempf, tempc;
	int option;
  
	// Ask the user
  
	std::cout << "Choose what calculation you'd like to run today (enter 1 or 2): \n";
	std::cout << "(1) Fahrenheit to Celsius \n";
	std::cout << "(2) Celsius to Fahrenheit \n";
	std::cout << "(3) Exit \n";
	std::cin >> option;
	
	//Moving from if-else if-else structure to switch setup
	switch(option) {
		
		case 1 :
			std::cout << "Enter the temperature in Fahrenheit: ";
			std::cin >> tempf;
			tempc = (tempf - 32) / 1.8;
			std::cout << "The temp is " << tempc << " degrees Celsius.\n";
			break;
		case 2 :
			std::cout << "Enter the temperature in Celsius: ";
			std::cin >> tempf;
			tempf = (tempc * (9 / 5)) + 32;
			std::cout << "The temp is " << tempc << " degrees Fahrenheit.\n";
			break;
		case 3 :
			std::cout << "Goodbye!\n";
			break;
		default :
			std::cout << "Invalid\n";
			break;
	
	}
	
	std::cout << "this is a new change I'm making to demonstrate pull requests"
}
