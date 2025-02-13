import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }
        
        String answer = "";
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer += key;
            }
        }
    
        return answer;
    }
}