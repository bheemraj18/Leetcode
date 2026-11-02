class Solution {
public int[] findErrorNums(int[] nums) {
int n = nums.length;
int i = 0;


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

 
    for (int j = 0; j < n; j++) {
        if (nums[j] != j + 1) {
            return new int[]{nums[j], j + 1};
        }
    }

    return new int[]{};
}


}
