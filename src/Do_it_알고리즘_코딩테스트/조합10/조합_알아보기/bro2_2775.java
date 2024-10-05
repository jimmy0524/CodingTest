package Do_it_알고리즘_코딩테스트.조합10.조합_알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bro2_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[15][15]; //0층 ~ 14층, 1호 ~ 14호
        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(bufferedReader.readLine()); //층
            int B = Integer.parseInt(bufferedReader.readLine()); //호
            System.out.println(arr[A][B]);
        }
    }
}
