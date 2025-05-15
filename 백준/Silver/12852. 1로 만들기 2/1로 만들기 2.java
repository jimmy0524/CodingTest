import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		arr[1].add(1);
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			int what = 1;  
			if (i % 2 == 0) {
				int two = dp[i / 2] + 1;
				if (dp[i] > two) {
					what = 2;
					dp[i] = two;
				}
			}
			if (i % 3 == 0) {
				int three = dp[i / 3] + 1;
				if (dp[i] > three) {
					what = 3;
					dp[i] = three;
				}
			}
			switch (what) {
			case 1 :
				for (int j : arr[i - 1]) {
					arr[i].add(j);
				}
				break;
			case 2 : 
				for (int j : arr[i / 2]) {
					arr[i].add(j);
				}
				break;
			case 3 : 
				for (int j : arr[i / 3]) {
					arr[i].add(j);
				}
			}
			arr[i].add(i);
		}
		System.out.println(dp[n]);
		for (int i = arr[n].size() - 1; i >= 0; i--) {
			System.out.print(arr[n].get(i) + " ");
		}
	}
}
