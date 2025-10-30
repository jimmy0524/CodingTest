import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[N * 2];
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            arr[i] = now;
        }

        int index = 0;
        for (int i = N; i < N + k; i++) {
            arr[i] = arr[index];
            index++;
        }

        int left = 0;
        int right = left + k - 1;
        while (left < N + k && right < N + k) {
            for (int i = left; i <= right; i++) {
                set.add(arr[i]);
            }
            set.add(c);
            answer = Math.max(answer, set.size());
            set.clear();
            left += 1;
            right = left + k - 1;
        }

        System.out.println(answer);
    }
}
