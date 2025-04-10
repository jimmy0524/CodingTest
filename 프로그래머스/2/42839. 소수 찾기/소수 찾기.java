import java.util.*;

class Solution {
    boolean[] visited;
    String[] arr;
    HashSet<Integer> set;
    public int solution(String numbers) {
        arr = numbers.split("");
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(0, "");
        int answer = 0;
        
        for (int i : set) {
            if(isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int count, String str) {
        if (!str.isEmpty()) {
            set.add(Integer.valueOf(str));
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(count + 1, str + arr[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}