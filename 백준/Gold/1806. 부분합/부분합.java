import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0; //구간합
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;

        while(true) {
            if (sum >= S) {
                length = Math.min(length, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                if (length == Integer.MAX_VALUE) {
                    length = 0;
                }
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(length);
    }
}