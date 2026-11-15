class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[k] = nums[left] * nums[left];
                left++;
            } 
            else {
                res[k] = nums[right] * nums[right];
                right--;
            }

            k--;
        }

        return res;
    }
}