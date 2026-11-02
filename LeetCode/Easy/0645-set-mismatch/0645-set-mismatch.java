class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int xor = 0;

      
        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        int bit = xor & -xor;

        int a = 0, b = 0;

        
        for (int num : nums) {
            if ((num & bit) != 0)
                a ^= num;
            else
                b ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & bit) != 0)
                a ^= i;
            else
                b ^= i;
        }

        
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
            if (num == b) {
                return new int[]{b, a};
            }
        }

        return new int[]{};
    }
}