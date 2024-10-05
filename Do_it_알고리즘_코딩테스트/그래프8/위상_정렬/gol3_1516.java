package Do_it_알고리즘_코딩테스트.그래프8.위상_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gol3_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] ans = new int[N + 1];
        int[] indegree = new int[N + 1];

        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            time[i] = a;
            for (int j = 1; j <= N; j++) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                list[b].add(i);
                indegree[i] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int next : list[n]) {
                indegree[next]--;
                ans[next] = Math.max(ans[next], ans[n] + time[n]);
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i] + time[i]);
        }
    }
}
