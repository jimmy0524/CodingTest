import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        for (int[] now : sizes) {
            wMax = Math.max(wMax, Math.max(now[0], now[1]));
            hMax = Math.max(hMax, Math.min(now[0], now[1]));
        }
        return wMax * hMax;
    }
}