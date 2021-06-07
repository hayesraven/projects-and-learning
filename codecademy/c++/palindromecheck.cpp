#include <iostream>

// Define is_palindrome() here:

bool is_palindrome(std::string text){

  std::string rtext = "";

  for (int i = text.size() - 1; i >= 0; i--){

    rtext += text[i];

  }

  if (text == rtext){

    return true;

  }
  else {

    return false;

  }

}

int main() {
  
  std::cout << is_palindrome("madam") << "\n";
  std::cout << is_palindrome("ada") << "\n";
  std::cout << is_palindrome("lovelace") << "\n";
  
}