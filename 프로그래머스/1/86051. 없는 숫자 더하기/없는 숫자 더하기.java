import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            boolean b = false;
            for (int num : numbers) {
                if (i == num) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                answer += i;
            }
        }
        return answer;
    }
}