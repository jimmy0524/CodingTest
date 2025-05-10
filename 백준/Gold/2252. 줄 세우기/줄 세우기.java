import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[N + 1];
		List<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			count[b]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now);
			sb.append(" ");
			for (int i : arr[now]) {
				count[i]--;
				if (count[i] == 0) {
					q.add(i);
				}
			}
		}
		System.out.println(sb);
	}
	
}
