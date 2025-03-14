import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> arr = new HashSet<>();
        
        arr.add(words[0]);
    
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || !arr.add(words[i])) {
                return new int[]{i % n + 1,(i / n) + 1};
            }
            arr.add(words[i]);
        }

        return new int[]{0,0};
    }
}