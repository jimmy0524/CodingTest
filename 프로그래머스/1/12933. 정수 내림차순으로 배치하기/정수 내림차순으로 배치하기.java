import java.util.*;

class Solution {
    public long solution(long n) {
        String[] split = String.valueOf(n).split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String temp : split) {
            sb.append(temp);
        }
        long answer = Long.parseLong(sb.toString());

        return answer;
    }
}