import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day16_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[2];
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int sum = arr[i] + arr[mid];

                if (Math.abs(sum) <= max) {
                    ans[0] = arr[i];
                    ans[1] = arr[mid];
                    max = Math.abs(sum);
                }

                if (sum < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
