import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] values;
	static boolean[] visited;
	static ArrayList<Node>[] arr;
	static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		int[] dij1 = new int[N + 1];
		int[] dij2 = new int[N + 1];
		int[] ans = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(b, c));
		}
	
		dij1 = dijkstra(X);
		for (int i = 1; i <= N; i++) {
			if (i == X) {
				continue;
			}
			dij2 = dijkstra(i);
			ans[i] = dij1[i] + dij2[X];
		}
		
		int index = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (ans[i] > max) {
				max = ans[i];
				index = i;
			}
		}
		System.out.println(max);
	}
	
	public static int[] dijkstra(int start) {
		values = new int[N + 1];
		Arrays.fill(values, Integer.MAX_VALUE);
		values[start] = 0;
		visited = new boolean[N + 1];

		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.to]) {
				visited[now.to] = true;
				for (Node next : arr[now.to]) {
					if (!visited[next.to] && values[next.to] > next.value + now.value) {
						values[next.to] = next.value + now.value;
						pq.add(new Node(next.to, values[next.to]));
					}
				}
			}
		}
		return values;
	}
	
	public static class Node {
		int to, value;
		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}
	}
}
