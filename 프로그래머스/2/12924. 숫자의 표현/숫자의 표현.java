class Solution {
    public int solution(int n) {
        int count = 1, start = 1, end = 1, sum = 1;
        while (start < n / 2 + 1) {
            if (sum == n) {
                count ++;
                sum -= start;
                start ++;
            } else if (sum > n) {
                sum -= start;
                start ++;
            } else {
                end ++;
                sum += end;
            }
        }
        return count;
    }
}