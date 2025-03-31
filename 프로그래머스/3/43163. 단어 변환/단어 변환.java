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
        
        String[] beginArr = begin.split("");
        for (int i = 0; i < words.length; i++) { //6
            int unSameCount = 0;
            String[] wordsSplit = words[i].split(""); //h, o , t
            for (int j = 0; j < wordsSplit.length; j++) { //3
                if (!beginArr[j].equals(wordsSplit[j])) {
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