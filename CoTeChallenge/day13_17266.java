import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day13_17266 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N;
        int result = N;

        while (left <= right) {
            int mid = (right + left) / 2; //가로등 높이

            if (lightPossible(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean lightPossible(int height) {
        int last = 0;

        //가로등은 i - height ~ i + mid의 구간을 비춤
        for (int i : arr) {
            if (i - height > last) {
                return false;
            }
            last = i + height;
        }

        return last >= N;
    }
}
