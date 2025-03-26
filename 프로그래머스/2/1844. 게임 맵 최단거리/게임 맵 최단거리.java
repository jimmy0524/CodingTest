import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps);
    }
    public int bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            int distance = now.distance;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx <= maps.length - 1 && ny >= 0 && ny <= maps[0].length - 1 && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, distance + 1));
                    if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                        System.out.println(nx);
                        System.out.println(ny);
                        return distance + 1;
                    }
                }
            }
        }
        return -1;
    }
    public static class Point {
        int x, y, distance;
        
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}