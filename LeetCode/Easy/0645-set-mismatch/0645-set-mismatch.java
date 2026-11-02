class Solution {
public int[] findErrorNums(int[] nums) {
int n = nums.length;
int i = 0;


    // Step 1: Cyclic Sort
    while (i < n) {
        int correctIndex = nums[i] - 1;

        if (nums[i] != nums[correctIndex]) {
            // Swap
            int temp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = temp;
        } else {
            i++;
        }
    }

    // Step 2: Find duplicate and missing number
    for (int j = 0; j < n; j++) {
        if (nums[j] != j + 1) {
            return new int[]{nums[j], j + 1};
        }
    }

    return new int[]{};
}


}
