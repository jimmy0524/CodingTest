import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        
        ArrayList<Long> arr = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            arr.add(x * i);
        }
        
        long[] answer = new long[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}