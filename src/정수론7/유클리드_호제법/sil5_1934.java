package 정수론7.유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil5_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(A * B / gcd(A, B));
        }
    }
    public static int gcd(int A, int B) {
        if (B == 0){
            return A;
        }
        else {
            return gcd(B, A % B);
        }
    }
}
