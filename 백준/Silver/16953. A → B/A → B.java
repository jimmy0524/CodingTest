import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int count = 0;
		while(a < b) {
			if (b % 2 == 0) {
				b = b / 2;
			} else if (b % 10 == 1) {
				b = b / 10;
			} else {
				System.out.println(-1);
				return;
			}
			count ++;
		}
		
		if (a != b) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(count + 1);
	}
}
