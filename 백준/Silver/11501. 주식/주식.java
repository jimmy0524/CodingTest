import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long answer = 0;
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int max = arr[N - 1];
			for (int j = N - 2; j >= 0; j--) {
				if (max < arr[j]) {
					max = arr[j];
				} else {
					answer += max - arr[j];
				}
			}
			System.out.println(answer);
		}
	}
}
