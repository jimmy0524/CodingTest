import java.io.*;
import java.util.*;

public class Main {
	// 54~
	static int[][] arr;
	static int answer;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Node n = new Node(0, 0, 0, 1);
		dfs(n);
		System.out.println(answer);

	}

	public static void dfs(Node n) {
//		System.out.println("startX : " + n.startX);
//		System.out.println("startY : " + n.startY);
//		System.out.println("endX : " + n.endX);
//		System.out.println("endY : " + n.endY);
		if (n.endX == N - 1 && n.endY == N - 1) {
			answer++;
			return;
		}
		// --
		if (n.startX == n.endX && n.endY - n.startY == 1) {
			if (n.endY <= N - 2) {
				if (arr[n.startX][n.endY + 1] == 0) {
					dfs(new Node(n.endX, n.endY, n.endX, n.endY + 1));
					if (n.endX <= N - 2) {
						if (arr[n.endX + 1][n.endY + 1] == 0 && arr[n.endX + 1][n.endY] == 0) {
							dfs(new Node(n.endX, n.endY, n.endX + 1, n.endY + 1));
						}
					}
				}
			}
		}
		// |
		else if (n.endX - n.startX == 1 && n.startY == n.endY) {
			if (n.endX <= N - 2) {
				if (arr[n.endX + 1][n.endY] == 0) {
					dfs(new Node(n.endX, n.endY, n.endX + 1, n.endY));
					if (n.endY <= N - 2) {
						if (arr[n.endX + 1][n.endY + 1] == 0 && arr[n.endX][n.endY + 1] == 0) {
							dfs(new Node(n.endX, n.endY, n.endX + 1, n.endY + 1));
						}
					}
				}
			}
		}
		// 대각선
		else {
			if (n.endY <= N - 2) {
				if (arr[n.endX][n.endY + 1] == 0) {
					dfs(new Node(n.endX, n.endY, n.endX, n.endY + 1));
				}
			}
			if (n.endX <= N - 2) {
				if (arr[n.endX + 1][n.endY] == 0) {
					dfs(new Node(n.endX, n.endY, n.endX + 1, n.endY));
					if (n.endY <= N - 2) {
						if (arr[n.endX + 1][n.endY + 1] == 0 && arr[n.endX][n.endY + 1] == 0) {
							dfs(new Node(n.endX, n.endY, n.endX + 1, n.endY + 1));
						}
					}
				}
			}
		}

	}

	public static class Node {
		int startX, startY, endX, endY = 0;

		public Node(int startX, int startY, int endX, int endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
	}

}
