import java.util.*;
import java.io.*;

public class Solution {
    static int length;
    static List<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[V + 1];
            int[] D = new int[V + 1]; // 몇개의 간선이 가르키는가
            Queue<Integer> q = new ArrayDeque();
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                D[b]++;
            }

            for (int i = 1; i <= V; i++) {
                if (D[i] == 0) {
                    q.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");
            while (!q.isEmpty()) {
                int now = q.poll();
                sb.append(now + " ");
                for (int next : graph[now]) {
                    D[next]--;
                    if (D[next] == 0) {
                        q.add(next);
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
