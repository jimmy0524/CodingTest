import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static Node[] arr;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new Node[M];
		StringTokenizer st;
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i] = new Node(a, b, cost);
		}
		Arrays.sort(arr, (a,b) -> {return a.cost - b.cost;});
		for (int i = 0; i < M; i++) {
			if (find(arr[i].a) != find(arr[i].b)) {
				union(arr[i].a, arr[i].b);
				answer += arr[i].cost;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}
	
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	public static class Node {
		int a, b, cost;
		
		Node (int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
	
	
}
