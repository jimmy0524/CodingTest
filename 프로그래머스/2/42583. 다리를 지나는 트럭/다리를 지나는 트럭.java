import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int nowWeight = 0;
        Queue<Integer> bridgeStatus = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeStatus.add(0);
        }
        
        int index = 0;
        int time = 0;
        while(index < truck_weights.length) {
            nowWeight -= bridgeStatus.poll();
            if (truck_weights[index] + nowWeight <= weight) {
                bridgeStatus.add(truck_weights[index]);
                nowWeight += truck_weights[index];
                index++;
            } else {
                bridgeStatus.add(0);
            }
            time++;
        }
        
        return time += bridge_length;
    }
}