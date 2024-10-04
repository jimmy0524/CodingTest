package 동적계획법11.동적계획법_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i >= 1; i--) {
            if(i + T[i] - 1 >= N + 1) {
                D[i] = D[i + 1];
            } else {
                D[i] = Math.max(D[i + 1], P[i] + D[i + T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
