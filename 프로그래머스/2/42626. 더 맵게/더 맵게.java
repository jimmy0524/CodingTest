import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for (int i : scoville) {
            pq.add(i);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }
        
        return count;
    }
}