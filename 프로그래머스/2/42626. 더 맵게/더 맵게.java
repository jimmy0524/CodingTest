import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        for (int i : scoville) {
            queue.add(i);
        }

        for (int i = 0; i < scoville.length; i++) {
            if (queue.size() >= 2) {
                if (queue.peek() < K) {
                    int first = queue.poll();
                    int second = queue.poll();
                    queue.add(first + (second * 2));
                    answer++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        if (queue.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}