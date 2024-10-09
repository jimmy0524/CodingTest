import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class day3_27737 {
    static int[][] arr;
    static boolean[][] visited;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N * N
        int M = Integer.parseInt(st.nextToken()); //버섯 포자 개수
        K = Integer.parseInt(st.nextToken()); //x * K개의 버섯이 자람
        int tempM = 0;
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    if (tempM >= M) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    } else {
                        tempM++;
                        BFS(i, j);
                    }
                }
            }
        }
        if (tempM == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M - tempM);
        }
    }

    private static void BFS(int i, int j) {
        int tempK = K - 1;
        //상하좌우
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 1 && ny >= 1 && nx <= N && ny <= N &&
                        !visited[nx][ny] && arr[nx][ny] == 0 && tempK >= 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    tempK --;
                }
            }
        }
    }
}
