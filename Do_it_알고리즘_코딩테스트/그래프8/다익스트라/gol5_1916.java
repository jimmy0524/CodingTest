package Do_it_알고리즘_코딩테스트.그래프8.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class gol5_1916 {
    static int N, M , A, B;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //도시 개수
        M = Integer.parseInt(br.readLine()); //버스 개수
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        list = new ArrayList[N + 1];
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //가중치
            list[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        q.add(new Edge(A, 0));
        distance[A] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if (visited[c_v]) {
                continue;
            }
            visited[c_v] = true;

            for (int i = 0; i < list[c_v].size(); i++) {
                Edge edge = list[c_v].get(i);
                int next = edge.vertex;
                int value = edge.value;

                if (distance[next] > distance[c_v] + value) {
                    distance[next] = distance[c_v] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        System.out.println(distance[B]);
    }

    public static class Edge implements Comparable<Edge> {
        int vertex, value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
