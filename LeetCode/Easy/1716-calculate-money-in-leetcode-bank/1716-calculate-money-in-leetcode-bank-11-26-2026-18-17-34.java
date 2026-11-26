class Solution {
    public int totalMoney(int n) {
        int res = 0;
        int monday = 1;
        int money = 1;

        for (int i = 1; i <= n; i++) {

            if (i % 7 == 1 && i != 1) {
                monday++;
                money = monday;
            }

            res += money;
            money++;
        }

        return res;
    }
}