import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1]; // 최대가치
        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken()); // 무게
            V[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (w < W[i]) { // 현재 사물의 무게가 너무 커서 담을 수 없음
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
