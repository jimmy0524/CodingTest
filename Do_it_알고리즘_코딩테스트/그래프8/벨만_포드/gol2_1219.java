package Do_it_알고리즘_코딩테스트.그래프8.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gol2_1219 {
    static int N, M, sCity, eCity;
    static long ans[], cityMoney[];
    static Edge edges[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //노드 수
        sCity = Integer.parseInt(st.nextToken()); //시작 도시
        eCity = Integer.parseInt(st.nextToken()); //종료 도시
        M = Integer.parseInt(st.nextToken()); //에지 수
        edges = new Edge[M];
        ans = new long[N];
        cityMoney = new long[N];

        Arrays.fill(ans, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        ans[sCity] = cityMoney[sCity];

        for (int i = 0; i < N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                //출발 노드가 방문하지 않은 노드이면 skip
                if (ans[start] == Long.MIN_VALUE) {
                    continue;
                } else if (ans[start] == Long.MAX_VALUE) {
                    ans[end] = Long.MAX_VALUE;
                } else if (ans[end] < ans[start] + cityMoney[end] - price) {
                    ans[end] = ans[start] + cityMoney[end] - price;

                    if(i >= N - 1) {
                        ans[end] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if (ans[eCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (ans[eCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(ans[eCity]);
        }
    }
    static class Edge {
        int start, end, price;
        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
