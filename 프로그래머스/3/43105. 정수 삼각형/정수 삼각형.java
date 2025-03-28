import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        Arrays.sort(dp[triangle.length - 1]);
        
        int answer = 0;
        return dp[triangle.length - 1][dp[triangle.length - 1].length - 1];
    }
}