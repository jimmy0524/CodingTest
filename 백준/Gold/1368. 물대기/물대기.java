import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		ArrayList<Node> arr = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(br.readLine());
			arr.add(new Node(i, 0, value));
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr.add(new Node(i, j, value));
			}
		}
		arr.sort((a, b) -> a.value - b.value);
		for (int i = 0; i < arr.size(); i++) {
			Node now = arr.get(i);
			if (find(now.to) != find(now.from)) {
				answer += now.value;
				union(now.to, now.from);
			}
		}
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
