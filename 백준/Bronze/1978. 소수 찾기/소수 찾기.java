import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			boolean check = true;
			if (a > 1) {
				for (int j = 2; j < a; j++) {
					if (a % j == 0) {
						check = false;
					}
				}
				if (check) answer++;
			}
		}
		System.out.println(answer);
	}
}
