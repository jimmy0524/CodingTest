import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long time = 0;
        long left = 1;
        long right = (long) n * times[times.length - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            for (int t : times) {
                people += mid / t;
                
                if (people >= n) {
                    break;
                }
            }
            
            if (people >= n) {
                    right = mid - 1;
                time = mid;
                } else {
                left = mid + 1;
            }
        }
        return time;
    }
}