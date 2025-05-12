import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		ArrayList<Node> arr = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr.add(new Node(i, j, now));
			}
            parent[i] = i;
		}
		arr.sort((a, b) -> a.value - b.value);
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (find(arr.get(i).to) != find(arr.get(i).from)) {
				count++;
				answer += arr.get(i).value;
				union(arr.get(i).to, arr.get(i).from);
				if (count == N - 1) {
					break;
				}
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
