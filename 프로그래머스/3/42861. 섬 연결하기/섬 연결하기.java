import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] arr : costs) {
            if (find(arr[0]) != find(arr[1])) {
                union(arr[0], arr[1]);
                answer+=arr[2];
            }
        }
        return answer;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}