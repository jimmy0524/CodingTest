import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> {return (b + a).compareTo(a + b);});
        
        if (arr[0].startsWith("0")) {
            return "0";
        }
        
        for (String s : arr) {
            sb.append(s);
        }
  
        return sb.toString();
    }
}