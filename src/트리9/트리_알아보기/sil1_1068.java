package 트리9.트리_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sil1_1068 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int ans = 0;
    static int deleteNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //노드 개수
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                root = i;
            } else {
                tree[i].add(a);
                tree[a].add(i);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());

        if (root == deleteNode) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(ans);
        }
    }

    private static void DFS(int i) {
        visited[i] = true;
        int depth = 0;
        for (int next : tree[i]) {
            if (!visited[next] && next != deleteNode) {
                depth++;
                DFS(next);
            }
        }
        if (depth == 0) {
            ans++;
        }
    }
}
