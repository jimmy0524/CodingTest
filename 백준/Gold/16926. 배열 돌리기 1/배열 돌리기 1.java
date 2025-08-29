import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            rotate(0, 0, N - 1, M - 1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void rotate(int sx, int sy, int ex, int ey) {
        if (sx >= ex || sy >= ey)
            return;
        // 모서리들 왼쪽 위부터 반시계 방향
        int tempA = arr[sx][sy];
        int tempB = arr[ex][sy];
        int tempC = arr[ex][ey];

        // 윗줄
        for (int i = sy + 1; i <= ey; i++) {
            arr[sx][i - 1] = arr[sx][i];
        }
        // 왼쪽
        for (int i = ex - 1; i >= sx; i--) {
            arr[i + 1][sy] = arr[i][sy];
        }
        arr[sx + 1][sy] = tempA;
        // 아래
        for (int i = ey - 1; i >= sy; i--) {
            arr[ex][i + 1] = arr[ex][i];
        }
        arr[ex][sy + 1] = tempB;
        // 오른쪽
        for (int i = sx + 1; i <= ex; i++) {
            arr[i - 1][ey] = arr[i][ey];
        }
        arr[ex - 1][ey] = tempC;
        rotate(sx + 1, sy + 1, ex - 1, ey - 1);
    }
}