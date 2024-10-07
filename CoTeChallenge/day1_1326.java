import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class day1_1326 {
    static int[] stones;
    static boolean[] visited;
    static int[] jumps;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stones = new int[N + 1];
        visited = new boolean[N + 1];
        jumps = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //출발점
        int b = Integer.parseInt(st.nextToken()); //도착점

        System.out.println(BFS(a, b));
    }

    public static int BFS(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a); //출발점 큐에 넣기
        jumps[a] = 0; //출발점에서의 점프 횟수 0
        visited[a] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            //앞으로 점프
            for (int i = 1; now + stones[now] * i <= N; i++) {
                int next = now + stones[now] * i;

                if(!visited[next]) {
                    visited[next] = true;
                    jumps[next] = jumps[now] + 1;
                    q.add(next);

                    if (next == b) {
                        return jumps[next];
                    }
                }
            }

            //뒤로 점프
            for (int i = 1; now - stones[now] * i >= 1; i++) {
                int next = now - stones[now] * i;

                if(!visited[next]) {
                    visited[next] = true;
                    jumps[next] = jumps[now] + 1;
                    q.add(next);

                    if (next == b) {
                        return jumps[next];
                    }
                }
            }
        }
        return -1;
    }
}