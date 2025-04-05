import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        for (int i = 0; i < skip.length(); i++) {
            arr.remove(Character.valueOf(skip.charAt(i)));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int tempIndex = arr.indexOf(s.charAt(i));
            sb.append(arr.get((tempIndex + index) % arr.size()));
        }
        
        return sb.toString();
    }
}