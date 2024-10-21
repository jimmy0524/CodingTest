import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class day15_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무의 수
        int M = Integer.parseInt(st.nextToken()); //가져가려는 나무의 길이
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long treeLength = 0;
            for (int i = 0; i < N; i++) {
                treeLength += Math.max(arr[i] - mid, 0);
            }

            if (treeLength >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
