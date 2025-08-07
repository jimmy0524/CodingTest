import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		bfs(1);
		System.out.print(answer);
	}
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		int depth = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			if (depth >= 3) {
				break;
			}
			for (int j = 0; j < size; j++) {
				int now = q.poll();
				for (int next : arr[now]) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
						answer++;
					}
				}
			}
		}
	}
}
