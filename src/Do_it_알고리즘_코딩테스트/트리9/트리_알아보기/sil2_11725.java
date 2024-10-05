package Do_it_알고리즘_코딩테스트.트리9.트리_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sil2_11725 {
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //노드 개수
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void DFS(int i) {
        visited[i] = true;
        for (int next : tree[i]) {
            if (!visited[next]) {
                answer[next] = i;
                DFS(next);
            }
        }
    }

}
