import java.util.*;
import java.io.*;


public class Main {
    static int[][] arr;
    static int[] start; //뱀의 머리 
    static int[] end; //뱀의 꼬리 
    static int[] dx = {0,1,0,-1}; //우하좌상
    static int[] dy = {1,0,-1,0};
    static int dir = 0;
    static int N, K;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1; //사과는 1
        }
        arr[1][1] = 2; //뱀은 2
        start = new int[]{1, 1};
        end = new int[]{1, 1};
        int L = Integer.parseInt(br.readLine());
        int[] X = new int[L];
        char[] C = new char[L];
        int time = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1,1});

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            C[i] = st.nextToken().charAt(0);
        }
        int idx = 0;
        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N || arr[nx][ny] == 2) {
                System.out.println(time);
                return;
            }

            snake.addFirst(new int[]{nx, ny});
            if (arr[nx][ny] != 1) {
                int[] tail = snake.removeLast();
                arr[tail[0]][tail[1]] = 0;
            }
            arr[nx][ny] = 2;
            
            if (idx < L && time == X[idx]) {
                if (C[idx] == 'L') dir = (dir + 3) % 4;  // 왼쪽
                else dir = (dir + 1) % 4;                // 오른쪽
                idx++;
            }
        }
    }
}