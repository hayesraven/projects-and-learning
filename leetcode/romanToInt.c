#include <stdio.h>
#include <stdlib.h>

// From Leetcode, 13. Roman to Integer 

// Solution - this desperately needs to be refactored
int romanToInt(char * s){
    // Set up variables
    int length = (sizeof(s)) / (sizeof(s[0]));
    int i = 0, num = 0;
    char prev;

    // Loop through input 
    while (i < (length -1)) {
        switch (s[i]) {
            case 'I':
                num += 1;
                break;

            case 'V':
                num += 5;
                if (prev == 'I') {
                    num -= 2;
                }
                break;

            case 'X':
                num += 10;
                if (prev == 'I') {
                    num -= 2;
                }
                break;

            case 'L':
                num += 50;
                if (prev == 'X') {
                    num -= 20;
                }
                break;

            case 'C':
                num += 100;
                if (prev == 'X') {
                    num -= 20;
                }
                break;

            case 'D':
                num += 500;
                if (prev == 'C') {
                    num -= 200;
                }
                break;

            case 'M':
                num += 1000;
                if (prev == 'C') {
                    num -= 200;
                }
                break;
        }
        prev = s[i];
        i++;
    }

    return num;
} // End of solution

// Used for testing only
int main() {
    // Set up inputs
    char s[] = {'M', 'C', 'M', 'X', 'C', 'I', 'V'};

    int num = romanToInt(s);

    // Print output
    if (num == 1994) {
        printf("Passed\n");
    }
    else {
        printf("Failed. Got %d\n", num);
    }

}
