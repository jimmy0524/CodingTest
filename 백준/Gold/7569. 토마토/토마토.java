import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] arr;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        boolean isPossible = true;
        Queue<Point> q = new LinkedList<>();
        int result = 0;

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[h][x][y] = num;
                    if (num == 0) {
                        isPossible = false;
                    }
                    if (num == 1) {
                        q.add(new Point(h, x, y));
                    }
                }
            }
        }

        if (isPossible) {
            System.out.println(0);
            return;
        }
        bfs(q);

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[h][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, arr[h][x][y] - 1);
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int l = 0; l < 6; l++) {
                int nx = p.x + dx[l];
                int ny = p.y + dy[l];
                int nh = p.h + dh[l];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && nh >= 0 && nh < H) {
                    if (arr[nh][nx][ny] == 0) {
                        arr[nh][nx][ny] = arr[p.h][p.x][p.y] + 1;
                        q.add(new Point(nh, nx, ny));
                    }
                }
            }
        }
    }

    public static class Point {
        int x, y, h;

        public Point(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}