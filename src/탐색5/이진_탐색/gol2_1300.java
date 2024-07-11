package 탐색5.이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gol2_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long K = Integer.parseInt(br.readLine());
        long start = 1, end = K; //K번쨰 값은 K를 넘지 않는다
        long ans = 0;
        //이진 탐색 수행
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            //중앙값보다 작은 수 세기
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
