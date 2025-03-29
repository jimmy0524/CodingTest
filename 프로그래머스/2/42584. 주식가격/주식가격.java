//1차시도 : 2중 for문
//2차시도 : stack
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}