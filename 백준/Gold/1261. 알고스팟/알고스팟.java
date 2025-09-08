import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] value;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N, M;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        value = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            Arrays.fill(value[i], Integer.MAX_VALUE);
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        disk();
        System.out.println(value[M - 1][N - 1]);
    }

    static void disk() {
        value[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.toX][now.toY]) {
                visited[now.toX][now.toY] = true;

                for (int k = 0; k < 4; k++) {
                    int nx = now.toX + dx[k];
                    int ny = now.toY + dy[k];
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                        continue;

                    int cost = value[now.toX][now.toY] + arr[nx][ny];
                    if (value[nx][ny] > cost) {
                        value[nx][ny] = cost;
                        pq.add(new Node(nx, ny, cost));
                    }
                }
            }
        }
    }

    static class Node {
        int toX, toY, value;

        Node(int toX, int toY, int value) {
            this.toX = toX;
            this.toY = toY;
            this.value = value;
        }
    }
}