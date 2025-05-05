import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static boolean[] check;
	static String[] words;
	static int N;
	static int K;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    result = Integer.MIN_VALUE;
		check = new boolean[26];
		check['a'-'a'] = true;
		check['n'-'a'] = true;
		check['t'-'a'] = true;
		check['i'-'a'] = true;
		check['c'-'a'] = true;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}
		K -= 5;
		dfs(0, K);
		System.out.println(result);
	}
	private static void dfs(int index, int k) {
		if (k == 0) {
			int count = 0;
			for (String word : words) {
				boolean temp = false;
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					if (!check[c- 'a']) {
						temp = true;
						break;
					}
				}
				if (!temp) {
					count++;
				}
			}
			result = Math.max(result, count);
		}
		
		for (int i = index  + 1; i < 26; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i, k - 1);
				check[i] = false;
			}
		}
	}
}
