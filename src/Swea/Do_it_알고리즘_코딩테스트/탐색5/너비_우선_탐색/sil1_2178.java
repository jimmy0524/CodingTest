package Do_it_알고리즘_코딩테스트.탐색5.너비_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sil1_2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        A = new int[N][M];
        //2차원 배열 입력받기
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        while(!q.isEmpty()) {
            int now[] = q.poll();
            visited[i][j] = true;
            //상하좌우 탐색
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y>= 0 && x < N && y < M) { //배열을 넘어가면 안됨
                    if(A[x][y] != 0 && !visited[x][y]) { //0이여서 갈 수 없거나 이미 방문한 곳이면 안됨
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
