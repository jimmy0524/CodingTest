class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += i * price;
        }
        if (money < totalPrice) {
            return totalPrice - money;
        }
        return 0;
    }
}