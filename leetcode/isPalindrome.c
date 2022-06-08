#include <stdio.h>
#include <stdlib.h>

// From Leetcode, 9. Palindrome 

// Create boolean
typedef enum {
    false, true
} bool;

bool isPalindrome(int x){
    long int rem = 0, rev = 0;
    long int num = x;

    // Check for negative numbes
    if (x < 0) {
        return false;
    }

    // Reverse the number
    while (num != 0) {
        rem = num % 10;
        rev = (rev * 10) + rem;
        num /= 10;
    }

    if (rev == x) {
        return true;
    }

    return false;

}

int main() {
    // Set up inputs
    int x = 121;

    // Print output
    if (isPalindrome(x) == 1) {
        printf("True\n");
    }
    else {
        printf("False\n");
    }

}
