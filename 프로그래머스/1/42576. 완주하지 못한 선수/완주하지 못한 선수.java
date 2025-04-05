import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Queue<String> participantQueue = new LinkedList<>();
        Queue<String> completionQueue = new LinkedList<>();
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        
        for (String s : participant) {
            participantQueue.add(s);
        }
        
        for (String s : completion) {
            completionQueue.add(s);
        }
        
        while(!completionQueue.isEmpty()) {
            String c = completionQueue.poll();
            String p = participantQueue.poll();
            if (!c.equals(p)) {
                return p;
            }
        }
        
        if (participantQueue.size() == 1) {
            answer = participantQueue.poll();
        }
        
        return answer;
    }
}