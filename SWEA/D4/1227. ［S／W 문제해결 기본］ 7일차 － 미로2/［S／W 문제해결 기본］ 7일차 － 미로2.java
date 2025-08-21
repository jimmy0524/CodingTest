import java.util.*;
import java.io.*;

public class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            board = new int[100][100];
            Node start = null;
            Node end = null;
            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = s.charAt(j) - '0';
                    if (board[i][j] == 2) {
                        start = new Node(i, j);
                    }
                    if (board[i][j] == 3) {
                        end = new Node(i, j);
                    }
                }
            }
            boolean answer = bfs(start, end);
            if (answer) {
                System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }

    public static boolean bfs(Node start, Node end) {
        boolean[][] visited = new boolean[100][100];
        Queue<Node> q = new ArrayDeque();
        q.add(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == end.x && now.y == end.y) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 100 || ny >= 100 || nx < 0 || ny < 0 || visited[nx][ny]) continue;
                if (board[nx][ny] == 0 || board[nx][ny] == 3) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
         }
        return false;
    }

    public static class Node {
        int x, y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}