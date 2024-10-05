package Do_it_알고리즘_코딩테스트.자료구조3.구간_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gol3_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 나누는 수
        long[] S = new long[(n + 1)];
        long[] C = new long[m]; //나머지가 같은 값 카운팅
        long result = 0;
        st = new StringTokenizer(br.readLine());
        //구간합을 구함
        for (int i = 1; i <= n; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken()));
        }
        //m으로 나눠서 변경된 합 배열로 저장
        for(int i = 1; i <= n; i++) {
            S[i] = S[i] % m;
            if(S[i] == 0) {
                result ++;
            }
            C[(int) S[i]]++;
        }
        //m이 3이면 나머지 0, 1, 2 인거 찾아서 같은 나머지끼리 2가지 뽑는 경우의 수 구하기
        for (int i = 0; i < m; i++) {
            if (C[i] > 1) {
                result += C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(result);
    }

}
