package 조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil3_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        double ans = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i ++) {
            if (arr[i] >= K) {
                double temp = 1.0;
                for (int k = 0; k < K; k++) {
                    temp *= (double) (arr[i] - k) / (sum - k);
                }
                ans += temp;
            }
        }
        System.out.println(ans);
    }
}
