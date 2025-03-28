import java.util.*;

class Solution {
    boolean[] visited;
    int[][] computers;
    int n;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer ++;
            }
        }
        return answer;
    }
    
    public void bfs(int index) {
        visited[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < n; i++) {
                if (i != now && !visited[i] && computers[now][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}