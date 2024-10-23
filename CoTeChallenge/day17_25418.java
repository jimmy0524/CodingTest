import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day17_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] D = new int[K + 1];

        for (int i = A + 1; i <= K; i++) {
            if (i >= A * 2 && i % 2 == 0) {
                D[i] = Math.min(D[i - 1], D[i / 2]) + 1;
            } else {
                D[i] = D[i - 1] + 1;
            }
        }
        System.out.println(D[K]);
    }
}
