#include <iostream>

int main() {
  //Declare variables
  
  int year;

  //Ask for input
  
  std::cout << "Please enter a year (yyyy): \n";
  std::cin >> year;

  //Check for four digit input
  if (999 > year || 10000 < year) {
  
    std::cout << "Invalid input.\n";
	
  } 
  
  //Calculate if its a leap year 
  else if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
  
     std::cout << year << " is a leap year.\n";
	 
  }
  
  else {
  
    std::cout << year << " is not a leap year.\n";
	
  } 
  
}
