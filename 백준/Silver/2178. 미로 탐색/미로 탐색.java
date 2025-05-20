import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점 개수
		M = Integer.parseInt(st.nextToken()); //간선 개수
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		visited[0][0] = true;
		int answer = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			answer++;
			for (int j = 0; j < size; j++) {
				Node now = q.poll();
				if (now.x == N - 1 && now.y == M - 1) {
					return answer;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx >= 0 && nx <= N - 1 && ny >= 0 && ny <= M - 1) {
						if (arr[nx][ny] == 1 && !visited[nx][ny]) {
							q.add(new Node(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		
		return answer;
	}
	
	private static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
