class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int add = (n / a) * b; // 6
            int minus = n / a * a; // 18
            System.out.println("add = " + add + " minus = " + minus);
            answer += add;
            n = n - minus + add;
        }
        return answer;
    }
}