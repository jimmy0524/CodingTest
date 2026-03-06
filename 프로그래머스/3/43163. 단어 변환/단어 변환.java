class Solution {
    boolean[] visited;
    int answer;
    boolean check;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if (!check) {
            return 0;
        }
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int count) {
        
        if (begin.equals(target)) {
            check = true;
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            int unMatch = 0;
            if (!visited[i]) {
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) != words[i].charAt(j)) {
                        unMatch++;
                    }
                }
                
                if (unMatch == 1) {
                        visited[i] = true;
                        dfs(words[i], target, words, count + 1);
                        visited[i] = false;
                    }
            }
        }
    }
}