import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			String binary = Integer.toBinaryString(n);
			for (int j = binary.length() - 1; j >= 0; j--) {
				if (binary.charAt(j) == '1') {
					sb.append(binary.length()- 1 - j + " ");
				}
			}
			System.out.println(sb.toString().trim());
		}
	}
}
