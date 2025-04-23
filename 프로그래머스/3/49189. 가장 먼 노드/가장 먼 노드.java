import java.util.*;

class Solution {
    boolean visited[];
    ArrayList<Integer>[] arr;
    int count = 0;
    public int solution(int n, int[][] edge) {
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int[] temp : edge) {
            int a = temp[0];
            int b = temp[1];
            arr[a].add(b);
            arr[b].add(a);
        }
        bfs();
  
        return count;
    }
    public void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            count = size;
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int next : arr[now]) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
              }
            }
        } 
    }
}