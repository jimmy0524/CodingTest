import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node> arr = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.add(new Node(a, b, c));
		}
		arr.sort((a, b) -> a.value - b.value);
		int answer = 0;
		int last = 0;
		for (int i = 0; i < arr.size(); i++) {
			Node now = arr.get(i);
			if (find(now.from) != find(now.to)) {
				answer += now.value;
				last = now.value;
				union(now.from, now.to);
			}
		}
		answer -= last;
		System.out.println(answer);
	}
	
	public static void union(int a, int b) {
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
	
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	public static class Node {
		int from, to, value;
		
		public Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}
}
