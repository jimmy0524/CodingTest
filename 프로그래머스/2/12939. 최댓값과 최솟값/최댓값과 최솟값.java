import java.util.*;

class Solution {
    public String solution(String s) {
        String[] solution = s.split(" ");
        int[] stringtoInt = new int[solution.length];
        for (int i = 0; i < solution.length; i++) {
            stringtoInt[i] = Integer.parseInt(solution[i]);
        }
        Arrays.sort(stringtoInt);
        String answer = "";
        answer = stringtoInt[0] + " " + stringtoInt[stringtoInt.length - 1];
        return answer;
    }
}