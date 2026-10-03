import java.util.*;

class Solution {
    public String minInteger(String num, int k) {
        int n = num.length();

        Queue<Integer>[] pos = new Queue[10];

        for (int i = 0; i < 10; i++) {
            pos[i] = new LinkedList<>();
        }

        // Store original positions of every digit
        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'].offer(i);
        }

        Fenwick bit = new Fenwick(n);

        // Every position is initially available
        for (int i = 0; i < n; i++) {
            bit.add(i, 1);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            for (int d = 0; d <= 9; d++) {

                if (pos[d].isEmpty())
                    continue;

                int index = pos[d].peek();

                // Number of unselected elements before this digit
                int swaps = bit.sum(index);

                if (swaps <= k) {

                    k -= swaps;

                    ans.append((char) ('0' + d));

                    pos[d].poll();

                    // Remove this position
                    bit.add(index, -1);

                    break;
                }
            }
        }

        return ans.toString();
    }

    static class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void add(int index, int value) {
            index++;

            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        // Number of active positions [0, index)
        int sum(int index) {
            int result = 0;

            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }

            return result;
        }
    }
}