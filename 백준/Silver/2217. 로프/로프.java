import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            result = Math.max(arr[i] * (i + 1), result);
        }

        System.out.println(result);
    }
}