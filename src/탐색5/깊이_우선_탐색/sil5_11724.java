package 탐색5.깊이_우선_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil5_11724 {
    static int A;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); //노드 개수
        int B = Integer.parseInt(st.nextToken()); //엣지 개수
        visited = new boolean[A + 1];
        arr = new int[A + 1][A + 1];

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int i) {
        if (visited[i]) {
            return;
        } else {
           visited[i] = true;
           for (int j = 1; j <= A; j++) {
               if (arr[i][j] == 1) {
                   DFS(j);
               }
           }
        }
    }
}
