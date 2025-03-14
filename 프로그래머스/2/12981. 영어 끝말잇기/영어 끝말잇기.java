import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> arr = new ArrayList<>();
        if (words[0].length() < 1) {
            return new int[]{1,1};
        }
        
        arr.add(words[0]);
    
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || arr.contains(words[i]) || words[i].length() < 1) {
                return new int[]{i % n + 1, (int) Math.ceil((i + 1) / (double) n)};
            }
            arr.add(words[i]);
        }

        return new int[]{0,0};
    }
}