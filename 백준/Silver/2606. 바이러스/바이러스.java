import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        BFS();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count - 1);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

}

