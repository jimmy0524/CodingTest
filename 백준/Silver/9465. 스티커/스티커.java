import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] DP = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                DP[0][0] = arr[0][0];
                DP[1][0] = arr[1][0];
            } else {
                DP[0][0] = arr[0][0];
                DP[1][0] = arr[1][0];
                DP[0][1] = arr[1][0] + arr[0][1];
                DP[1][1] = arr[0][0] + arr[1][1];

                for (int j = 2; j < n; j++) {
                    DP[0][j] = Math.max(DP[1][j - 1], DP[1][j - 2]) + arr[0][j];
                    DP[1][j] = Math.max(DP[0][j - 1], DP[0][j - 2]) + arr[1][j];
                }
            }

            System.out.println(Math.max(DP[0][n - 1], DP[1][n - 1]));
        }
    }
}

