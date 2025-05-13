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
		st = new StringTokenizer(br.readLine());
		int fa = Integer.parseInt(st.nextToken());
		int fb = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());
		if (fc == 1) {
			fc = 0;
		} else {
			fc = 1;
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.add(new Node(a, b, c));
		}
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		arr.sort((a, b) -> a.value - b.value); //최악
		int worst = fc;
		for (int i = 0; i < arr.size(); i++) {
			Node now = arr.get(i);
			if (find(now.from) != find(now.to)) {
				if (now.value == 0) {
					worst += 1;
				}
				union(now.from, now.to);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		arr.sort((a, b) -> b.value - a.value); //good
		int best = fc;
		for (int i = 0; i < arr.size(); i++) {
			Node now = arr.get(i);
			if (find(now.from) != find(now.to)) {
				if (now.value == 0) {
					best += 1;
				}
				union(now.from, now.to);
			}
		}
		
		System.out.println(worst * worst - best * best);	
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
