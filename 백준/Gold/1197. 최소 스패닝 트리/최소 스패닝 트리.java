import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		//크루스칼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점 
		int E = Integer.parseInt(st.nextToken()); //간선
		int[][] graph = new int[E][3];
		parent = new int[V + 1];
		int answer = 0;
		int count = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(graph, (a, b) -> a[2] - b[2]);
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			int a = graph[i][0];
			int b = graph[i][1];
			if (find(a) != find(b)) {
				answer += graph[i][2];
				union(a, b);
				count++;
			}
			if (count == E - 1) {
				break;
			}
		}
		System.out.println(answer);
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a > b) {
				parent[a] = b;
			} else {
				parent[b] = a;
			}
		}
	}
	
	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
