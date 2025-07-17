import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int N;
    static int M;
    static boolean[] visited;
    static boolean answer = false;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1);  

            if (answer) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static void dfs(int now, int depth) {
        if (answer) {
            return;
        }

        if (depth == 5) {  
            answer = true;
            return;
        }

        for (int next : arr[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}