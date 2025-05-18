import java.util.*;
import java.io.*;

public class Main {
	static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
	static boolean[] visited;
	static int[] result;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];
		result = new int[N + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		dijkstra(1);
		int toV1 = result[v1]; //1 -> v1
		int toV2 = result[v2]; //1 -> v2
		Arrays.fill(result, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		dijkstra(v1);
		int fromV1toV2 = result[v2]; //1 -> v1 -> v2
		int fromV1toN = result[N];
		Arrays.fill(result, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		dijkstra(v2);
		int fromV2toV1 = result[v1];
		int fromV2toN = result[N];
		
		int root1 = toV1 + fromV1toV2 + fromV2toN;
		int root2 = toV2 + fromV2toV1 + fromV1toN;
		
		if (toV1 == Integer.MAX_VALUE || fromV1toV2 == Integer.MAX_VALUE || fromV2toN == Integer.MAX_VALUE && 
				toV2 == Integer.MAX_VALUE || fromV2toV1 == Integer.MAX_VALUE || fromV1toN == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
	
		System.out.println(Math.min(root1, root2));
	}
	
	public static void dijkstra(int start) {
		result[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.to]) {
				visited[now.to] = true;
				for (Node next : list[now.to]) {
					if (!visited[next.to] && result[next.to] > now.value + next.value) {
						result[next.to] = now.value + next.value;
						pq.add(new Node(next.to, result[next.to]));
					}
				}
			}
		}
	}
	
	public static class Node {
		int to, value;
		public Node (int to, int value) {
			this.to = to;
			this.value = value;
		}
	}
}
