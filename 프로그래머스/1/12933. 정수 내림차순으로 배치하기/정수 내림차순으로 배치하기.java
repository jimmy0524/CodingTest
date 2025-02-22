import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        String answerString = "";
        for (String temp : split) {
            answerString += temp;
        }
        long answer = Long.parseLong(answerString);
        return answer;
    }
}