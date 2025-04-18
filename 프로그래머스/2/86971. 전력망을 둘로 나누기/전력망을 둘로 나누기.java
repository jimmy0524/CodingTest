import java.util.*;

class Solution {
    ArrayList<Integer>[] arr;
    int min = Integer.MAX_VALUE;
    int n;
    public int solution(int n, int[][] wires) {
        this.n = n;
        arr = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]].add(wires[i][1]); 
            arr[wires[i][1]].add(wires[i][0]); 
        }
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            arr[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            int a = dfs(wires[i][0]);
            int b = n - a;
            min = Math.min(min, Math.abs(a - b));
            arr[wires[i][0]].add(wires[i][1]);
            arr[wires[i][1]].add(wires[i][0]);
        }

        return min;
    }
    public int dfs(int i) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}