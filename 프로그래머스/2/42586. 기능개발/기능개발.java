import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((float)(100 - progresses[i]) / speeds[i]));
        }
        while (!queue.isEmpty()) {
            int count = 1;
            int currentDay = queue.poll();
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }
            arr.add(count);
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}