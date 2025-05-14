import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= k; i++) {
				if (i - arr[j] < 0) {
					continue;
				}
				dp[i] += dp[i - arr[j]];
			}
		}
		System.out.println(dp[k]);
	}
}
