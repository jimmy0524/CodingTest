import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day20_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] D = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N - 1; i++) {
            if (D[i] == Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < N) {
                    D[i + j] = Math.min(D[i] + 1, D[i + j]);
                }
            }
        }
        if (D[N - 1] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(D[N - 1]);
        }
    }
}
