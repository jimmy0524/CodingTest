import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //25분
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                int i1 = s.charAt(j) - '0';
                arr[i][j] = i1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void BFS(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;
        int sum = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            sum++;
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == 1 &&!visited[nx][ny]) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        result.add(sum);
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}