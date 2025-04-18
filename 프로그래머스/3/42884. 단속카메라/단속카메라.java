import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {return a[1] - b[1];});
        
        int min = routes[0][1];
        int answer = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (min < routes[i][0]) {
                answer++;
                min = routes[i][1];
            }
        }
        
        return answer;
    }
}