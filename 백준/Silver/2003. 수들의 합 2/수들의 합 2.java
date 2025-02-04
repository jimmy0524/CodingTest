import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        int b = 0;
        int result = 0;
        int sum = 0;
        while (true) {
            if (sum >= M) {
                sum -= arr[a++];
            } else if (b == N) {
                break;
            } else {
                sum += arr[b++];
            }

            if (sum == M) {
                result++;
            }
        }
        System.out.println(result);
    }
}