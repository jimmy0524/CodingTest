import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        Stack<Integer> stack = new Stack<>();
        for (int i : score) {
            stack.push(i);
        }
        int answer = 0;
        int temp = 0;
        while(!stack.isEmpty()) {
            temp++;
            int t = stack.pop();
            if (temp == m) {
                answer += t * m;
                temp = 0;
            }
        }
        
        return answer;
    }
}