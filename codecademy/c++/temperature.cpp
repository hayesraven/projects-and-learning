#include <iostream>

//Temperature calculator found in Codecademy 'Learn C: Lesson 2'
//Things to add:
//1. Prompt user for either Fahrenheit or Celsius
//2. Give temperature in both the other 

int main() {
  
  // Declare variables
  
  double tempf, tempc;
  
  // Ask the user
  
  std::cout << "Enter the temperature in Fahrenheit: ";
  std::cin >> tempf;

  tempc = (tempf - 32) / 1.8;
  
  std::cout << "The temp is " << tempc << " degrees Celsius.\n";
  
}
