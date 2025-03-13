import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int temp = 1;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.values());
        Collections.sort(arr);
        
        for (int i = arr.size() - 1; i >= 0; i--) {
            k -= arr.get(i);
            answer ++;
            if (k <= 0) {
                break;
            }
        }
  
        return answer;
    }
}