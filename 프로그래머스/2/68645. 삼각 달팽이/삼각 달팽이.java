import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int[][] matrix = new int[n][n];
        int next = 1; // 다음에 넣을 값
        int x = -1;
        int y = 0;
        int dir = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (next <= n * (n + 1) / 2) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            if (nextX >= n || nextX < 0 || nextY >= n || nextY < 0 || matrix[nextX][nextY] != 0) {
                dir = (dir + 1) % 3;
                nextX = x + dx[dir];
                nextY = y + dy[dir]; 
            }
            x = nextX;
            y = nextY;
            matrix[nextX][nextY] = next;
            next++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    answer.add(matrix[i][j]);
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}