import java.util.*;

class Solution {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int temp = n % 3;
            n /= 3;
            if (temp == 0) {
                n--;
            }
            sb.insert(0, arr[temp]);
        }
        
        return sb.toString();
    }
}