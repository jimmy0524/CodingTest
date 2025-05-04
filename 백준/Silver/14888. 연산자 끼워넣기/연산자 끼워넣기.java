import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static int[] math;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //수의 개수
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		math = new int[4];
		for (int i = 0; i < 4; i++) {
			math[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(new ArrayList<>());
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(ArrayList<Integer> q) {
		if (q.size() == N - 1) {
			int result = num[0]; 
			for (int i = 1; i < N; i++) {
				int b = num[i]; 
				int m = q.get(i - 1);
				switch (m) {
				case 0:
					result += b;
					break;
				case 1:
					result -= b;
					break;
				case 2:
					result *= b;
					break;
				case 3:
					result /= b;
				}
			}
			max = Math.max(result, max);
			min = Math.min(result, min);
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (math[i] > 0) {
				math[i] -= 1;
				q.add(i);
				dfs(q);
				q.remove(q.size() - 1);
				math[i] += 1;
			}
		}
	}
}
