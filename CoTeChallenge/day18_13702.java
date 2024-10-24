import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day18_13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주전자의 개수
        int K = Integer.parseInt(st.nextToken()); // 은상이 포함 친구들의 수
        long[] arr = new long[N];
        long max = 0; // 막걸리의 최대 용량
        long answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long i : arr) {
                count += i / mid; // mid 용량으로 몇 명에게 가능한지
            }

            if (count >= K) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
