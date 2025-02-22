import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            arr.add(s.charAt(i) - '0');
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}