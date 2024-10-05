package Do_it_알고리즘_코딩테스트.동적계획법11.동적계획법_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sil3_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[N]);
    }
}
