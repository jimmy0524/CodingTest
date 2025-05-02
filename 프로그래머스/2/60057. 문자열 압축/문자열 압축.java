import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        } 
        int answer = Integer.MAX_VALUE;
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            StringBuilder sb = new StringBuilder();
            Queue<String> q = new LinkedList<>();
            String remain = "";
            for (int j = 0; j <= s.length() - i; j += i) {
                q.add(s.substring(j, j + i));
                remain = s.substring(j + i, s.length());
            }
            while(!q.isEmpty()) {
                int count = 1;
                String temp = q.poll();
                while (!q.isEmpty() && temp.equals(q.peek())) {
                    q.poll();
                    count++;
                }
                if (count == 1) {
                    sb.append(temp);
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(temp);
                }
                count = 1;
            }
            sb.append(remain);
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }
}