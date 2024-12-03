import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(BFS(0, 0));
    }

    private static int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                int nx = p.x;
                int ny = p.y;
                if (nx == N - 1 && ny == M - 1) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = nx + dx[j];
                    int nextY = ny + dy[j];
                    if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                        if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                            q.add(new Point(nextX, nextY));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

