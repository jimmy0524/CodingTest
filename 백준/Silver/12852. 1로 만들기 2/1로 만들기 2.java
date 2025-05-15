import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] before = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			before[i] = i - 1;
			int what = 1;  
			if (i % 2 == 0) {
				int two = dp[i / 2] + 1;
				if (dp[i] > two) {
					before[i] = i / 2;
					dp[i] = two;
				}
			}
			if (i % 3 == 0) {
				int three = dp[i / 3] + 1;
				if (dp[i] > three) {
					before[i] = i / 3;
					dp[i] = three;
				}
			}
		}
		System.out.println(dp[n]);
		while (n > 0) {
			System.out.print(n + " ");
			n = before[n];
		}
	}
}
