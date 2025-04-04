import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int temp = 0;
       
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            
            for (int num : win_nums) {
                if (num == lotto) {
                    temp++;
                    break;
                }
            }
        }
        
        int min = temp;
        int max = temp + zero;
        
        
        int[] answer = {rank(max), rank(min)};
        return answer;
    }
    public int rank(int n) {
        switch (n) {
            case 2: 
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
        }
        return 6;
    }
}