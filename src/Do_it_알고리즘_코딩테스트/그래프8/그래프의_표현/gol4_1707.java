package Do_it_알고리즘_코딩테스트.그래프8.그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gol4_1707 {
    static int K, V, E;
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int answer[];
    static boolean check; //이분 그래프인가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); //테스트케이스 개수
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            for (int j = 0; j < V + 1; j++) {
                A[j] = new ArrayList<>();
            }
            visited = new boolean[V + 1];
            answer = new int[V + 1];
            check = true;
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
            }
            //그래프가 하나로 되어있지않을 경우를 고려해서 모든 노드를 BFS 해준다.
            for (int k = 1; k <= V; k++) {
                if (check) {
                    BFS(k);
                } else {
                    break;
                }
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static void BFS(int v) {
        if (!visited[v]) {
            visited[v] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(v);
            answer[v] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i : A[cur]) {
                    if (answer[i] == 0 && answer[cur] == 1) {
                        answer[i] = 2;
                    } else if (answer[i] == 0 && answer[cur] == 2) {
                        answer[i] = 1;
                    }
                    if (answer[cur] == answer[i]) {
                        check = false;
                        return;
                    }
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}
