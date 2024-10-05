package Do_it_알고리즘_코딩테스트.탐색5.너비_우선_탐색;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sil2_1260 {
    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드 개수
        int E = Integer.parseInt(st.nextToken()); // 엣지 개수
        int S = Integer.parseInt(st.nextToken()); // 시작점
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        DFS(S); //시작점을 넘겨줌
        visited = new boolean[N + 1]; //방문배열 초기화
        BFS(S);
    }

    private static void DFS(int s) throws IOException {
        //이미 방문했다면 return
        if (visited[s]) {
            return;
        } else {
            visited[s] = true;
            br.write(s + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[s][i] == 1) {
                    DFS(i);
                }
            }
        }
    }

    private static void BFS(int s) throws IOException {
        br.write("\n");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            s = queue.poll();
            br.write(s + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[s][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        br.flush();
    }


}
