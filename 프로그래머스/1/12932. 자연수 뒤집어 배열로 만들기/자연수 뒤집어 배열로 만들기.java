import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        for (int j = 0, i = s.length() - 1; j < s.length(); j++, i--) {
            answer[j] = s.charAt(i) - '0';
        }
        
        return answer;
    }
}