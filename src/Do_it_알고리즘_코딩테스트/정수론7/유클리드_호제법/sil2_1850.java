package Do_it_알고리즘_코딩테스트.정수론7.유클리드_호제법;

import java.io.*;
import java.util.StringTokenizer;

public class sil2_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong((st.nextToken()));
        long B = Long.parseLong((st.nextToken()));
        long result = gcd(A, B);
        for (int i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.flush();
    }

    public static long gcd(long A, long B) {
        if (B == 0){
            return A;
        }
        else {
            return gcd(B, A % B);
        }
    }
}
