package Do_it_알고리즘_코딩테스트.조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gol2_1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] D = new int[201][201];

        for (int i = 0; i < 201; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }
        for (int i = 2; i < 201; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                if (D[i][j] > 1000000000) {
                    D[i][j] = 1000000001;
                }
            }
        }
        if (D[a + z][z] < K) {
            System.out.println("-1");
        } else {
            while (!(a == 0 && z == 0)) {
                if (D[a - 1 + z][z] >= K) {
                    System.out.print("a");
                    a--;
                } else {
                    System.out.print("z");
                    K = K - D[a - 1 + z][z];
                    z--;
                }
            }
        }
    }
}
