package Do_it_알고리즘_코딩테스트.조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gol5_1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arrN = new long[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] S = new int[N + 1];
        arrN[0] = 1;
        //팩토리얼 초기화
        for (int i = 1; i <= N; i++) {
            arrN[i] = arrN[i - 1] * i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        if (Q == 1) {
            long K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                long cnt = 1;
                for (int j = 1; j <= N; j++) { //정답 순열에 넣을 수
                    if (visited[j]) {
                        continue;
                    }
                    if (K <= cnt * arrN[N - i]) {
                        K -= (cnt - 1) * arrN[N - i];
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(S[i] + " ");
            }
        } else {
            long K = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (visited[j] == false) {
                        cnt++;
                    }
                }
                K += cnt * arrN[N - i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}
