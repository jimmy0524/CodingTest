import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][2];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
			parent[i] = i;
		}
		ArrayList<Node> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int ax = arr[i][0];
				int ay = arr[i][1];
				int bx = arr[j][0];
				int by = arr[j][1];
				double distance = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
				list.add(new Node(i, j , distance));
			}
		}
		Collections.sort(list, (a, b) -> Double.compare(a.value, b.value));
		double answer = 0;
		for (int i = 0; i < list.size(); i++) {
			Node now = list.get(i);
			if (find(now.s) != find(now.e)) {
				answer += now.value;
				union(now.s, now.e);
			}
		}
		System.out.printf("%.2f", answer);
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
		int s, e;
		double value;
		public Node(int s, int e, double value) {
			this.s = s;
			this.e = e;
			this.value = value;
		}
	}
}
