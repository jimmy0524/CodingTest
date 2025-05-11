import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(b, c));
		}
		int[] values = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(values, Integer.MAX_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		values[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		pq.add(new Node(start, 0));
		
		int[] root = new int[n + 1];
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.to]) {
				visited[now.to] = true;
				if (now.to == end) {
					break;
				}
				for (Node next : arr[now.to]) {
					if (!visited[next.to] && values[next.to] > next.value + now.value) {
						values[next.to] = next.value + now.value;
						pq.add(new Node(next.to, values[next.to]));
						root[next.to] = now.to;
					}
				}
			}
		}
		System.out.println(values[end]);
		int count = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while(true) {
			int pre = root[end];
			stack.push(pre);
			if (pre == start) {
				break;
			}
			end = pre;
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static class Node {
		int to, value;

		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}
	}
}
