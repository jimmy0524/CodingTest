package Do_it_알고리즘_코딩테스트.그래프8.그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sil2_18352 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int N, M, K, X;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //도시 개수
        M = Integer.parseInt(st.nextToken()); //도로 개수
        K = Integer.parseInt(st.nextToken()); //거리 정보
        X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (visited[i] == -1) {
                    queue.add(i);
                    visited[i] = visited[now] + 1;
                }
            }
        }
    }
}
