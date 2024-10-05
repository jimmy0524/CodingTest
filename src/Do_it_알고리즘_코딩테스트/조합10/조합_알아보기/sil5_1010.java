package Do_it_알고리즘_코딩테스트.조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil5_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] D = new int[30][30];
        for (int i = 0; i < 30; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N >= M) {
                System.out.println(D[N][M]);
            } else {
                System.out.println(D[M][N]);
            }
        }

    }
}
