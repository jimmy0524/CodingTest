import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] day = new int[N + 1];
		int[] cost = new int[N + 1];
		int[] dp = new int[N + 1]; //i까지의 최대 값
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			//선택 안할때
			dp[i] = Math.max(dp[i], dp[i - 1]);
			//선택 할때
			int nextDay = i + day[i] - 1;
			if (nextDay <= N) {
				dp[nextDay] = Math.max(dp[nextDay], dp[i - 1] + cost[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
