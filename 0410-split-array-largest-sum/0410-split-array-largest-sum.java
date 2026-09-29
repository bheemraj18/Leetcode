class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int parts = 1, sum = 0;

            for (int x : nums) {
                if (sum + x > mid) {
                    parts++;
                    sum = 0;
                }
                sum += x;
            }

            if (parts <= k)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}