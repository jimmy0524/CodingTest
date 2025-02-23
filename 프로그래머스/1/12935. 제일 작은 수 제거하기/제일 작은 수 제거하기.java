import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length < 2) {
            return new int[]{-1};
        }
        
        int min = arr[0];
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int a : arr) {
            if (a <= min) {
                min = a;
            }
        }
        
        for (int a : arr) {
            if (a != min) {
                answer.add(a);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}