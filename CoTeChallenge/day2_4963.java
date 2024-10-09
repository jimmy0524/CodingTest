import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class day2_4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int W;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            W = Integer.parseInt(st.nextToken()); //너비
            H = Integer.parseInt(st.nextToken()); //높이
            if (W == 0 && H == 0) {
                return;
            }
            arr = new int[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    if (arr[i][j] == 1) {
                        if (!visited[i][j]) {
                            BFS(i, j);
                            answer += 1;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
        int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int A = now[0];
            int B = now[1];
            if (i <= H && j <= W && A >= 1 && B >= 1) {
                for (int k = 0; k <= 7; k++) {
                    int x = A + dx[k];
                    int y = B + dy[k];
                    if(!visited[x][y]) {
                        if(arr[x][y] == 1) {
                            visited[x][y] = true;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
