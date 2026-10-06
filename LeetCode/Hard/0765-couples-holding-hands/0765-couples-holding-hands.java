class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        int swaps = 0;

        for (int i = 0; i < n; i += 2) {
            int person = row[i];
            int partner = person ^ 1;

            if (row[i + 1] == partner) {
                continue;
            }

            int partnerIndex = pos[partner];

            int other = row[i + 1];

            row[i + 1] = partner;
            row[partnerIndex] = other;

            pos[partner] = i + 1;
            pos[other] = partnerIndex;

            swaps++;
        }

        return swaps;
    }
}