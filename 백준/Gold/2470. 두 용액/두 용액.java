import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int[] result = {arr[start], arr[end]};
        int min = Math.abs(arr[start] + arr[end]);

        while(true) {
            int sum = arr[start] + arr[end];
            if (sum < 0) {
                start ++;
            } else if(sum > 0) {
                end --;
            } else {
                break;
            }
            if (start >= end) {
                break;
            }
            if (Math.abs(arr[start] + arr[end]) < min) {
                min = Math.abs(arr[start] + arr[end]);
                result[0] = arr[start];
                result[1] = arr[end];
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}