import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		long count = 0;
		for (long i = 1; i <= S; i++) {
			sum += i;
			count += 1;
			if (sum == S) {
				break;
			}
			if (sum > S) {
				count -= 1;
				break;
			}
		}
		System.out.println(count);
	}
}
