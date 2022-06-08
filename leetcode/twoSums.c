#include <stdio.h>
#include <stdlib.h>

// From Leetcode, 1. Two Sums

// Solution
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    
    int * sum = calloc(sizeof(int), 2);
    
    // Start at first element, check if each other element equals the target
    for (int i = 0; i < numsSize; i++) {
        for (int j = 0; j < numsSize; j++) {
            if ((nums[i] + nums[j]) == target) {
                sum[0] = nums[i];
                sum[1] = nums[j];
                return sum;
            }
        }
    }
    return 0;
}   // End of Solution

// Used only for testing
int main() {
    // Set up inputs
    int * returnSize;
    *returnSize = 4;

    int nums[] = {2,7,11,15};

    int * sum = twoSum(nums, 4, 9, returnSize);

    // Print output
    printf("[%d,%d]\n", sum[0], sum[1]);
    free(sum);
}
