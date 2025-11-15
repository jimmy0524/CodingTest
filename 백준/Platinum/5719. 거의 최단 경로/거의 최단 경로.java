import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] arr;
    static ArrayList<Integer>[] child; //나에게 연결되어있는
    static boolean[][] removed;
    static PriorityQueue<Node> pq;
    static boolean[] visited;
    static int[] values; //시작점부터 모든 노드까지의 최단거리
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                return;
            }
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N];
            child = new ArrayList[N];
            removed = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = new ArrayList();
                child[i] = new ArrayList();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[a].add(new Node(b, c));
            }
            dijk(S);
            removePath(D);
            dijk(S);
            if (values[D] == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(values[D]);
        }
    }

    public static void dijk(int start) {
        pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        values = new int[N];
        Arrays.fill(values, Integer.MAX_VALUE);
        visited = new boolean[N];
        values[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.to]) continue;
            visited[now.to] = true;
            for (Node next : arr[now.to]) {
                if (removed[now.to][next.to]) continue;
                if (values[now.to] + next.value < values[next.to]) {
                    child[next.to].clear();
                    child[next.to].add(now.to);
                    values[next.to] = values[now.to] + next.value;
                    pq.add(new Node(next.to, values[next.to]));
                } else if (values[now.to] + next.value == values[next.to]) {
                    child[next.to].add(now.to);
                    pq.add(new Node(next.to, values[next.to]));
                }
            }
        }
    }

    public static void removePath(int index) {
        for (int child : child[index]) {
            if (removed[child][index]) {
                continue;
            }
            removed[child][index] = true;
            removePath(child);
        }
    }

    static class Node {
        int to, value;

        Node (int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
