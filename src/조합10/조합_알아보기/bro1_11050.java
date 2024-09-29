package 조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bro1_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        //풀이1 조합 점화식
        int[][]D = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            //D배열 초기화
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }
        System.out.println(D[N][K]);
        //풀이2
//        int A = 1;
//        int B = 1;
//        int C = 1;
//        for (int i = 1; i <= N; i++) {
//            A *= i;
//        }
//        for (int i = 1; i <= K; i++) {
//            B *= i;
//        }
//        for (int i = 1; i <= N - K; i++) {
//            C *= i;
//        }
//        System.out.println(A/(B*C));
    }
}
