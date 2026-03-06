import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0, 0, 1, -1};
    boolean possible = false;
    int[][] arr;
    
    public int solution(int[][] maps) {
        arr = maps;
        return bfs();
    }
    
    public int bfs() {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int n = arr.length; //행 개수 x
        int m = arr[0].length; //열 게수 y
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        int count = 0;
        boolean check = false;
        
        here:
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int j = 0; j < size; j++) {
                int now[] = q.poll();
                if (now[0] == n - 1 && now[1] == m - 1) {
                    check = true;
                    break here;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 1) {
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        if (!check) {
                return -1;
            } else {
                return count;
            }
    }
}