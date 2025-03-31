import java.util.*;

class Solution {
    String target;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    String[] words;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        dfs(begin, 0);
        return answer;
    }
    
    public void dfs(String begin, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) { 
            int unSameCount = 0;
            for (int j = 0; j < begin.length(); j++) { 
                if (begin.charAt(j) != words[i].charAt(j)) {
                        unSameCount++;
                    }
            }
            
            if (!visited[i] && unSameCount == 1) {
                visited[i] = true;
                dfs(words[i], count + 1);
                visited[i] = false;
            }
        }
    }
}