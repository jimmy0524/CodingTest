import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[n + 3];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j = 4; j <= n; j++) {
				dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
			}
			System.out.println(dp[n]);
		}
	}
}
