import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int max = 100000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[max + 1];
        bfs(N, M);

        System.out.println(min);
    }

    public static void bfs(int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            visited[now.x] = true;

            if (now.x == m) {
                min = Math.min(min, now.time);
            }

            if (now.x * 2 <= max && !visited[now.x * 2]) {
                q.add(new Node(now.x * 2, now.time));
            }

            if (now.x + 1 <= max && !visited[now.x + 1]) {
                q.add(new Node(now.x + 1, now.time + 1));
            }

            if (now.x - 1 <= max && now.x - 1 >= 0 && !visited[now.x - 1]) {
                q.add(new Node(now.x - 1, now.time + 1));
            }
        }

    }

    public static class Node {
        int x, time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}