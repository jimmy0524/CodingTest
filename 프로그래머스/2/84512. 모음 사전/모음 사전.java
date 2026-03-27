class Solution {
    int answer;
    String word;
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        answer = 0;
        this.word = word;
        dfs("");
        return answer;
    }
    
    public boolean dfs(String s) {
        if (s.equals(word)) return true;
        if (s.length() == 5) return false;
        
        for (int i = 0; i < 5; i++) {
            answer++;
            if (dfs(s + alpha[i])) {
                return true;
            }
        }
        return false;
    }
}