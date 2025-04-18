import java.util.*;

class Solution {
    HashMap<Character, Integer> map;
    public String solution(String[] survey, int[] choices) {
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            int tempScore = score[choices[i] - 1];
            if (choices[i] <= 3) {
                char tempAlpha = survey[i].charAt(0);
                map.put(tempAlpha, map.getOrDefault(tempAlpha, 0) + tempScore);
                continue;
            } else if (choices[i] >= 5) {
                char tempAlpha = survey[i].charAt(1);
                map.put(tempAlpha, map.getOrDefault(tempAlpha, 0) + tempScore);
                continue;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        compete(sb, 'R', 'T'); 
        compete(sb, 'C', 'F'); 
        compete(sb, 'J', 'M'); 
        compete(sb, 'A', 'N'); 
        return sb.toString();
    }
    public void compete(StringBuilder sb, char a, char b) {
        map.put(a, map.getOrDefault(a, 0));
        map.put(b, map.getOrDefault(b, 0));
        int aScore = map.get(a);
        int bScore = map.get(b);
        if (aScore > bScore) {
            sb.append(a);
            return;
        } else if (bScore > aScore) {
            sb.append(b);
            return;
        }
        if (a < b) {
            sb.append(a);
        } else {
            sb.append(b);
        }
    }
}