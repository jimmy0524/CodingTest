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
        int layers = Math.min(N, M) / 2;
        for (int i = 0; i < layers; i++) {
            rotate(i);
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

    public static void rotate(int layer) {
        int len = (N - 2 * layer) * 2 + (M - 2 * layer) * 2 - 4;
        int r = R % len;
        ArrayList<Integer> tempArr = new ArrayList<>();
        int sx = layer, sy = layer;
        int ex = N - 1 - layer, ey = M - 1 - layer;
        // 왼쪽
        for (int i = sx; i < ex; i++) {
            tempArr.add(arr[i][sy]);
        }

        // 아래쪽
        for (int i = sy; i < ey; i++) {
            tempArr.add(arr[ex][i]);
        }

        // 오른쪽
        for (int i = ex; i > sx; i--) {
            tempArr.add(arr[i][ey]);
        }
        // 위쪽
        for (int i = ey; i > sy; i--) {
            tempArr.add(arr[sx][i]);
        }

        for (int i = 0; i < r; i++) {
            int temp = tempArr.get(tempArr.size() - 1);
            tempArr.add(0, temp);
            tempArr.remove(tempArr.size() - 1);
        }
        // 왼쪽
        for (int i = sx; i < ex; i++) {
            arr[i][sy] = tempArr.get(0);
            tempArr.remove(0);
        }

        // 아래쪽
        for (int i = sy; i < ey; i++) {
            arr[ex][i] = tempArr.get(0);
            tempArr.remove(0);
        }

        // 오른쪽
        for (int i = ex; i > sx; i--) {
            arr[i][ey] = tempArr.get(0);
            tempArr.remove(0);
        }
        // 위쪽
        for (int i = ey; i > sy; i--) {
            arr[sx][i] = tempArr.get(0);
            tempArr.remove(0);
        }
    }
}