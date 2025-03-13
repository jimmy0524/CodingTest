import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int temp = 1;
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < tangerine.length; i++) {
            if (tangerine[i] != tangerine[i - 1]) {
                arr.add(temp);
                temp = 1;
            } else {
                temp += 1;
            }
        }
        arr.add(temp);
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