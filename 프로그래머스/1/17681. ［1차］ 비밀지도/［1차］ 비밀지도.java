import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replace("0", " ");
            result[i] = result[i].replace("1", "#");
        }
    
        return result;
    }
}