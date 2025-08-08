import java.util.*;
import java.io.*;

public class Main {
	static Node[] nodeArr;
	static int[] parent;
	static int answer;
	static Connect[] conArr;
	static PriorityQueue<Connect> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		nodeArr = new Node[N];
		parent = new int[N];
		conArr = new Connect[N * 3];
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nodeArr[i] = new Node(i, x, y, z);
		}
		
		Arrays.sort(nodeArr, (a, b) -> {
			return a.x - b.x;
		});
		
		for (int i = 0; i < N - 1; i++) {
			int cost = nodeArr[i + 1].x - nodeArr[i].x;
			pq.add(new Connect(nodeArr[i].index, nodeArr[i + 1].index, cost));
		}
		
		Arrays.sort(nodeArr, (a, b) -> {
			return a.y - b.y;
		});
		
		for (int i = 0; i < N - 1; i++) {
			int cost = nodeArr[i + 1].y - nodeArr[i].y;
			pq.add(new Connect(nodeArr[i].index, nodeArr[i + 1].index, cost));
		}
		
		Arrays.sort(nodeArr, (a, b) -> {
			return a.z - b.z;
		});
		
		for (int i = 0; i < N - 1; i++) {
			int cost = nodeArr[i + 1].z - nodeArr[i].z;
			pq.add(new Connect(nodeArr[i].index, nodeArr[i + 1].index, cost));
		}
		
		while (!pq.isEmpty()) {
			Connect now = pq.poll();
			if (find(now.a) != find(now.b)) {
				union(now.a, now.b);
				answer += now.cost;
			}
		}
		System.out.println(answer);
	}

	public static class Node {
		int index, x, y, z;

		Node(int index, int x, int y, int z) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static class Connect {
		int a, b, cost;

		Connect(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
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
}
