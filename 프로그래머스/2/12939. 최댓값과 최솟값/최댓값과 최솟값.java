import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(num);
        String answer = "";
        answer += num[0] + " ";
        answer += num[num.length - 1];
        return answer;
    }
}