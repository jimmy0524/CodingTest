import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[N + 1];
        result = new ArrayList<>();
        DFS(V);
        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
        visited = new boolean[N + 1];
        result = new ArrayList<>();
        BFS(V);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }

    public static void DFS(int V) {
        result.add(V);
        visited[V] = true;
        for (int next : arr[V]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int next : arr[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
