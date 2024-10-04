package 조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gol3_1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 1000000000;
        long[] D = new long[N + 2];

        D[1] = 0;
        D[2] = 1;

        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % M;
        }

        System.out.println(D[N]);
    }
}
