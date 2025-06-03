import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer>[] reverse;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	    reverse = new ArrayList[N + 1]; //작은거 -> 큰거
		arr = new ArrayList[N + 1]; //큰거 -> 작은거
		for (int i = 1; i <= N; i++) {
			reverse[i] = new ArrayList<>();
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			reverse[b].add(a);
		}
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			boolean possible = bfs(i);
			
			if (!possible) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean bfs(int start) {
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		int answer1 = 0;
		int answer2 = 0;
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			answer1++;
			for (int next : arr[now]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
		
		if (answer1 - 1 >= (N + 1) / 2) {
			return false;
		}
		
		visited = new boolean[N + 1];
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			answer2++;
			for (int next : reverse[now]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
		
		if (answer2 - 1 >= (N + 1) / 2) {
			return false;
		} else {
			return true;
		}
	}
}
