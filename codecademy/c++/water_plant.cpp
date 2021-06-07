#include <iostream>

// Define needs_water() here:

std::string needs_water(int days, bool is_succulent) {

  if (is_succulent != 1 && days > 3) {

    return "Time to water the plant.";

  }
  else if (is_succulent == 1 && days <= 12) {

    return "Dont water the plant!";

  }
  else if (is_succulent == 1 && days >= 13) {

    return "Go ahead and give the plant a little water.";

  }
  else {

    return "Dont water the plant!";

  }
}

int main() {
  
  std::cout << needs_water(14, true) << "\n";
  
}