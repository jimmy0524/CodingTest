import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue p = new PriorityQueue<>(Collections.reverseOrder());;

        for(int i=0; i<priorities.length; i++){
            p.add(priorities[i]);
        }

        while(!p.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)p.peek()){
                    answer++;
                    if(i == location){
                        return answer;
                    }
                    p.poll();
                }
            }
        }

        return answer;
    }
}