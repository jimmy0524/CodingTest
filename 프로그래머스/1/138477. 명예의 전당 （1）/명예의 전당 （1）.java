import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> top = new ArrayList<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            top.add(score[i]);
            Collections.sort(top);
            answer[i] = top.get(top.size() > k ? top.size() - k : 0);
        }
        return answer;
    }
}