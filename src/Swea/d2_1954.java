package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //우, 하, 좌, 상 순서로 방향이 바뀜
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 1; i <= N; i++) {
            int M = Integer.parseInt(br.readLine());
            int[][] arr = new int[M + 1][M + 1];
            boolean[][] visited = new boolean[M + 1][M + 1];
            int x = 1;
            int y = 1;
            int dir = 0;
            for (int j = 1; j <= M * M; j++) {
                arr[x][y] = j;
                visited[x][y] = true;
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                if (nextX > M || nextY > M || nextX <= 0 || nextY <= 0 || visited[nextX][nextY]) {
                    dir = (dir + 1) % 4;
                }
                x += dx[dir];
                y += dy[dir];
            }
            System.out.println("#" + i);
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= M; k++) {
                    System.out.print(arr[j][k]+ " ");
                }
                System.out.println();
            }
        }
    }
}
