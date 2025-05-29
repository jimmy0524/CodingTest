import java.io.*;
import java.util.*;

public class Main {
	static int answer = Integer.MIN_VALUE;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr[r][k] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
				}
			}
 		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			count++;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		
		answer = Math.max(answer, count);
	}
	
	public static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
