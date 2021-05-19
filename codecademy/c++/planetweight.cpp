#include <iostream>

//Begin function 
int main() {
  //Declare variables
  double weight;
  int planet;

  //Prompt user for weight

  std::cout << "Enter your Earth weight in lbs: \n"  ;
  std::cin >> weight;
  
  //Prompt user for planet to fight on
  
  std::cout << "What planet do you want to fight on? (enter 1-8)\n";
  std::cout << "(1) Mercury\n";
  std::cout << "(2) Venus\n";
  std::cout << "(3) Mars\n";
  std::cout << "(4) Jupiter\n";
  std::cout << "(5) Saturn\n";
  std::cout << "(6) Uranus\n";
  std::cout << "(7) Neptune\n";
  std::cout << "(8) Exit\n";
  std::cin >> planet;

  //Determine the weight
  if (planet == 8) {
    std::cout << "Exiting!\n";
  }
  else {
    switch(planet) {
      //Mercury
      case 1 :
        weight = (weight * 0.38);
        break;
      //Venus
      case 2 :
        weight = (weight * 0.91);
        break;
      //Mars
      case 3 :
        weight = (weight * 0.38);
        break;
      //Jupiter
      case 4 :
        weight = (weight * 2.34);
        break;
      //Saturn
      case 5 :
        weight = (weight * 1.06);
        break;
      //Uranus
      case 6 :
        weight = (weight * 0.92);
        break;
      //Neptune
      case 7 :
        weight = (weight * 1.19);
        break;
      default :
        std::cout << "Invalid\n";
        break;
    }
    std::cout << "Your weight on that planet would be ";
    std::cout << weight << " lbs!\n";
  } 
}
