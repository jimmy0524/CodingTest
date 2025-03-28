import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int startCount = 0; //도전한 사람 수 
            int failCount = 0; //실패한 사람 수
            boolean isClear = false;
            for (int j = 0; j < stages.length; j++) { 
                if (startCount == 0 && stages[j] >= i) {
                    startCount = stages.length - 1 - j + 1;
                }
                if (stages[j] > i) {
                    failCount = startCount - (stages.length - 1 - j + 1);
                    isClear = true;
                    break;
                }
            }

            if (startCount == 0) {
                map.put(i, 0.0); 
            } else if (!isClear) {
                map.put(i, 1.0);
            } else {
                map.put(i, (double) failCount / startCount);
            }
        }
        
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Double> comparingByValue().reversed())
            .mapToInt(entry -> entry.getKey())
            .toArray();
    }
}