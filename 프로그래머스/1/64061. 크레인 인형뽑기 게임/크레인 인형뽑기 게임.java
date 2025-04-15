import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            here:
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    int now = board[j][moves[i] - 1];
                    board[j][moves[i] - 1] = 0;
                    if (!stack.isEmpty()) {
                        if (stack.peek() == now) {
                            stack.pop();
                            answer += 2;
                            break here;
                        } 
                    }
                    stack.push(now);
                    break here;
                }
            } 
        }
        return answer;
    }
}