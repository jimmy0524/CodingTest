import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] arr;
    static ArrayList<Node>[] revArr;
    static int[] values;
    static int[] revValues;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //학생 수
        int M = Integer.parseInt(st.nextToken()); //도로 수
        int X = Integer.parseInt(st.nextToken()); //파티 장소
        values = new int[N + 1];
        Arrays.fill(values, Integer.MAX_VALUE);
        revValues = new int[N + 1];
        Arrays.fill(revValues, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        revArr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            revArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            revArr[b].add(new Node(a, c));
        }
        dijk(X, arr, values);
        visited = new boolean[N + 1];
        dijk(X, revArr, revValues);
        for (int i = 1; i <= N; i++) {
            values[i] += revValues[i];
        }
        Arrays.sort(values);
        System.out.println(values[N - 1]);
    }

    static public void dijk(int start, ArrayList<Node>[] ar, int[] val) {
        val[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.to]) continue;
            visited[node.to] = true;

            for (Node next : ar[node.to]) {
                if (val[next.to] > val[node.to] + next.value) {
                    val[next.to] = val[node.to] + next.value;
                    pq.add(new Node(next.to, val[next.to]));
                }
            }
        }
    }

    static class Node{
        int to;
        int value;

        Node(int to, int value){
            this.to = to;
            this.value = value;
        }
    }
}
