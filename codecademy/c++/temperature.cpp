#include <iostream>

//Temperature calculator found in Codecademy 'Learn C: Lesson 2'
//I'm maintaining this as the "original copy". Any updates/improvements will be made to temperature_mine.cpp

int main() {
  
  // Declare variables
  
  double tempf, tempc;
  
  // Ask the user
  
  std::cout << "Enter the temperature in Fahrenheit: ";
  std::cin >> tempf;

  tempc = (tempf - 32) / 1.8;
  
  std::cout << "The temp is " << tempc << " degrees Celsius.\n";
  
}
