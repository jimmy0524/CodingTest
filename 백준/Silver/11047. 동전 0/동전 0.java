import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		while(K > 0) {
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] <= K) {
					answer += K / arr[i];
					K %= arr[i];
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
