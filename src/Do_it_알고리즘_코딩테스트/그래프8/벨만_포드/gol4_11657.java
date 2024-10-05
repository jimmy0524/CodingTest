package Do_it_알고리즘_코딩테스트.그래프8.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gol4_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드 개수
        int M = Integer.parseInt(st.nextToken()); //에지 개수
        Edge[] edges = new Edge[M + 1];
        long[] distance = new long[N + 1];

        //최단 거리 배열 초기화
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(a, b, c);
            edges[i] = edge;
        }

        //벨만-포드 수행
        distance[1] = 0;
        for (int i = 1; i < N; i++) { //N-1번 반복
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //더 작은 최단거리 있을 때 업데이트
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        //음수 사이클 확인
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }

        if(mCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
