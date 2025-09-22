import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); //총감독관
        int C = Integer.parseInt(st.nextToken()); //부감독관

        long answer = 0;
        for (int i = 0; i < N; i++) {
            int temp = A[i] - B;
            answer++;
            if (temp > 0) {
                if (temp % C == 0) {
                    answer += (temp / C);
                } else {
                    answer += (temp / C + 1);
                }
            }
        }
        System.out.println(answer);
    }
}
