package 그리디6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil3_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()); //동전 수
        long amount = Long.parseLong(st.nextToken()); //목표 금액
        long[] A = new long[(int) N];
        long count = 0;
        //동전 입력 받기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        //필요한 최소한의 동전 찾기
        for (long i = N - 1; i>=0; i--) {
            if(A[(int) i] <= amount) {
                count += amount / A[(int) i]; //count에 추가
                amount = amount % A[(int) i]; //남은 금액으로 갱신
            }
        }
        System.out.println(count);
    }
}
