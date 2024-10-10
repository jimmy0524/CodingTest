import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class day4_10026 {
    static char[][] arr;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j); //색약 x
                    answer ++;
                }
            }
        }
        System.out.print(answer + " ");

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N + 1][N + 1];
        answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j); //색약 o
                    answer ++;
                }
            }
        }
        System.out.print(answer);

    }

    private static void BFS(int i, int j) {
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
                if (nx <= N && ny <= N && nx >= 1 && ny >= 1) {
                    if (arr[nx][ny] == arr[x][y] && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
    }
}
