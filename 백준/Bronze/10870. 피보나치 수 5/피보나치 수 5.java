import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n + 1];
		if (n == 0) {
			System.out.println(0);
			return;
		}
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[n]);
	}
}
