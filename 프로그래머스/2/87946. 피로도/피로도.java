class Solution {
    int answer = 0;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        dfs(k, new boolean[dungeons.length], 0);
        return answer;
    }
    
    public void dfs(int k, boolean[] visited, int possible) {
        if (possible > answer) {
            answer = possible;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (k >= dungeons[i][0]) {
                    dfs(k - dungeons[i][1], visited, possible + 1);
                }
                visited[i] = false;
            }
        }
    }
}