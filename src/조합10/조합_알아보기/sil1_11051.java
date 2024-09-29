package 조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil1_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        //조합 점화식
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
                D[i][j] = D[i][j] % 10007;
            }
        }
        System.out.println(D[N][K]);
    }
}
