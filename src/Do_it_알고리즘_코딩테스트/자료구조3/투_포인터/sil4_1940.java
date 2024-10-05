package Do_it_알고리즘_코딩테스트.자료구조3.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sil4_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()); //재료의 개수
        st = new StringTokenizer(br.readLine());
        long M = Integer.parseInt(st.nextToken()); //갑옷이 완성되는 번호의 합
        long[] A = new long[(int) (N + 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        long count = 0;
        long start = 1;
        long end = N;

        while(start < end) {
            if(A[(int) start] + A[(int) end] < M){
                start ++;
            }
            else if(A[(int) start] + A[(int) end] > M) {
                end --;
            }
            else {
                count ++;
                start ++;
                end --;
            }
        }
        System.out.println(count);

    }
}
