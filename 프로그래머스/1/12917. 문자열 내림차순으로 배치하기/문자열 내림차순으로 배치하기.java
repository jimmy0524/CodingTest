import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = new String[s.length()];
        arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        String answer = "";
        for (String c : arr) {
            answer += c;
        }
        return answer;
    }
}