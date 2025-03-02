import java.util.*;

class Solution {
    public int solution(String t, String p) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i + p.length() <= t.length(); i++) {
            arr.add(t.substring(i, i + p.length()));
        }
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (Long.parseLong(arr.get(i)) <= Long.parseLong(p)) {
                answer ++;
            } 
        }
        return answer;
    }
}