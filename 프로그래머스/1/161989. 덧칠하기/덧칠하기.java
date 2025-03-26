class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int temp = 0; //밀대의 끝 위치
        for (int i = 0; i < section.length; i++) {
            if (temp < section[i]) {
                answer++;
                temp = section[i] + m - 1;
            }
        }
        return answer;
    }
}