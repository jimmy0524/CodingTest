import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
            for (int j = 0; j < sizes[i].length; j++) {
                if (j == 0) {
                    wMax = Math.max(wMax, sizes[i][j]);
                } else {
                    hMax = Math.max(hMax, sizes[i][j]);
                }
            }
        }
        return wMax * hMax;
    }
}