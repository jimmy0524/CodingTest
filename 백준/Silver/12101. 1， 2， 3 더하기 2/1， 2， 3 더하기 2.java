import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		count = k;
		back(0, new ArrayList<>());
		if (count != 0) {
			System.out.println(-1);
		}
	}
	
	public static void back(int sum, ArrayList<Integer> arr) {
		if (count == 0) {
			return;
		}
		
		if (sum > n) {
			return;
		}
		
		if (sum == n) {
			count--;
			if (count == 0) {
				StringBuilder sb = new StringBuilder();
				for (int a : arr) {
					sb.append(a);
					sb.append("+");
				}
				sb.deleteCharAt(sb.length() - 1);
				System.out.println(sb.toString());
				return;
			} else {
				return;
			}
		}
		
		for (int i = 1; i <= 3; i++) {
			arr.add(i);
			back(sum + i, arr);
			arr.remove(arr.size() - 1);
		}
	}
}
