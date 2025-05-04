import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int sum = 0;
		int first = 0;
		boolean findFirst = false;
		boolean[] arr = new boolean[b + 1];
		arr[0] = arr[1] = true;
		for (int i = 2; i <= Math.sqrt(b); i++) {
			if (!findFirst) {
				for (int j = i * i; j <= b; j += i) {
					arr[j] = true;
				}
			}
		}
		for (int i = a; i <= b; i++) {
			if (!arr[i]) {
				if (!findFirst) {
					first = i;
					findFirst = true;
				}
				sum += i;
			}
		}
		if (!findFirst) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(first);
	}
}
