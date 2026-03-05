import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int count;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        arr = new ArrayList[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (i != j && computers[i][j] == 1) {
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                count++;
                bfs(i);
            }
        }

        return count;
    }
    
    public void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}