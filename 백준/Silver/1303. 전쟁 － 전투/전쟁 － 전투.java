import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visited;
	static char[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //가로 크기
		M = Integer.parseInt(st.nextToken()); //세로 크기
		arr = new char[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'W' && !visited[i][j]) {
					int result = bfs(new Node(i, j), 'W');
					sum += result * result;
				}
			}
		}
		
		
		
		System.out.print(sum + " ");
		
		sum = 0;
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B' && !visited[i][j]) {
					int result = bfs(new Node(i, j), 'B');
					sum += result * result;
				}
			}
		}
		
		System.out.print(sum);
	}
	
	private static int bfs(Node node, char c) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		visited[node.x][node.y] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			count++;
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (arr[nx][ny] == c && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
			}
		}
		
		return count;
	}
	
	private static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
