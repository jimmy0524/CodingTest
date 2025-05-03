import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int answer = 0;
		int i = 1;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		while(true) {
			for (int j = 0; j < i; j++) {
				arr.add(i);
			}
			if (arr.size() >= b) {
				break;
			}
			i++;
		}

		for (int j = a - 1; j < b; j++) {
			answer += arr.get(j);
		}
		System.out.println(answer);
	}
}
