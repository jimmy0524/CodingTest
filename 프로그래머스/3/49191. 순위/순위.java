class Solution {
    public int solution(int n, int[][] results) {
        int[][] rank = new int[n + 1][n + 1];
        for (int[] r : results) {
            rank[r[0]][r[1]] = 1;
            rank[r[1]][r[0]] = -1;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(rank[i][k]==1 && rank[k][j]==1){
                        rank[i][j] = 1;
                        rank[j][i] = -1;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (rank[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}