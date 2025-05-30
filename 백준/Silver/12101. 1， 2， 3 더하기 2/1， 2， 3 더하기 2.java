import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<String>[] dp = new ArrayList[n + 3];
		for (int i = 0; i <= n + 2; i++) {
			dp[i] = new ArrayList<>();
		}
		dp[1].add("1");
		dp[2].add("1+1");
		dp[2].add("2");
		dp[3].add("1+2");
		dp[3].add("2+1");
		dp[3].add("1+1+1");
		dp[3].add("3");
		
		for (int i = 4; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				for (String s : dp[i - j]) {
					dp[i].add(s + "+" + j);
				}
			}
		}
		
		if (dp[n].size() < k) {
			System.out.println(-1);
		} else {
			Collections.sort(dp[n]);
			System.out.println(dp[n].get(k - 1));
		}
	}
}
