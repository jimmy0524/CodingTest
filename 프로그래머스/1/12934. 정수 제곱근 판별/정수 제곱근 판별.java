class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        long answer = -1;
        if (sqrt % 1 == 0) {
            answer = ((long)sqrt + 1) * ((long)sqrt + 1);
        }
        return answer;
    }
}