import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQueue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            daysQueue.add(days);
        }

        while (!daysQueue.isEmpty()) {
            int currentDay = daysQueue.poll(); 
            int count = 1; 

            while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDay) {
                count++;
                daysQueue.poll();
            }

            result.add(count);
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}