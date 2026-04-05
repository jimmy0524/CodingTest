import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] arr;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        arr = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        answer = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,v));
        }
        dijk(K);
        for (int i = 1; i <= V; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(answer[i]);
            }
        }
    }

    public static void dijk(int K) {
        answer[K] = 0;
        visited[K] = true;
        pq.add(new Node(K,0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.to] = true;
            for (Node next : arr[node.to]) {
                int nextTo = next.to;
                if (visited[nextTo]) continue;
                if (answer[nextTo] > answer[node.to] + next.value) {
                    answer[nextTo] = answer[node.to] + next.value;
                    pq.add(new Node(nextTo,answer[nextTo]));
                }
            }
        }
    }

    public static class Node {
        int to, value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
