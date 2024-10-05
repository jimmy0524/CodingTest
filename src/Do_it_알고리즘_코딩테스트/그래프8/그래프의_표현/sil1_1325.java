package Do_it_알고리즘_코딩테스트.그래프8.그래프의_표현;

import java.io.*;
import java.util.*;

public class sil1_1325 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        M = Integer.parseInt(st.nextToken()); //신뢰 관계 개수
        A = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }
        //모든 노드로 BFS 실행
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; //방문 배열 false로 초기화
            BFS(i);
        }
        //answer 배열에서 최댓값 찾기
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }
        //최댓값에 해당하는 answer (신뢰를 가장 많이 받는 노드) 출력하기
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }
    public static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }
}
