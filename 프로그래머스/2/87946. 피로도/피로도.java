class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }                 
            int a = dungeons[i][0]; //최소 필요 피로도
            int b = dungeons[i][1]; //소모 피로도
            if (k >= a) {
                visited[i] = true;   
                dfs(k - b, dungeons, count + 1);
                visited[i] = false;  
            }
        }
        
    }
}