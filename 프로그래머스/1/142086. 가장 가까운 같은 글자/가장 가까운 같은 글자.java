import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[26];
        int[] result = new int[s.length()];
        
        Arrays.fill(arr, -1);
        
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] != -1) {
                result[i] = i - arr[s.charAt(i) - 'a'];
            } else {
                result[i] = -1;
            }
            arr[s.charAt(i) - 'a'] = i;
        }
        
        return result;
    }
}