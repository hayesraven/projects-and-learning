#include <iostream>
#include <vector>

int main() {

  //Initialize variables
	int even = 0;
	int odd = 1;
	
  //Initialize the vector
  std::vector<int> num = {2, 4, 3, 6, 1, 9};

  //For loop to loop through the vector
  for (int i = 0; i < num.size(); i++){

    //Check to see if num(i) is even
    //If it is, add it to even
	  if (num[i] % 2 == 0 ) {
		  even = num[i] + even;
  	}
    //If num(i) isn't even, adds it to odd
	  else {
		  odd = num[i] * odd;
	  }

	}

  //Output
	std::cout << "Sum of even numbers is " << even << "\n";
	std::cout << "Product of odd numbers is " << odd << "\n";
	
}