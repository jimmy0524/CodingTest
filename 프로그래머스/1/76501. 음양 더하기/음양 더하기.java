class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int pm = 1;
            if (!signs[i]) {
                pm = -1;
            }
            answer += absolutes[i] * pm;
        }
        return answer;
    }
}