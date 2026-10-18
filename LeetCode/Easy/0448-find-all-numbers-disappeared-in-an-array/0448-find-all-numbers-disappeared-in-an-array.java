class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> hold = new ArrayList<>();
        int n = nums.length;

        boolean[] seen = new boolean[n + 1];

        for (int x : nums) {
            seen[x] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                hold.add(i);
            }
        }

        return hold;
    }
}