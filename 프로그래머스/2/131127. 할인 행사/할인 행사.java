import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                arr.add(want[i]);
            }
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            ArrayList<String> temp = new ArrayList<>(arr);
            for (int j = i; j < i + 10; j++) {
                if (!temp.contains(discount[j])) {
                  continue;
                } else {
                    temp.remove(discount[j]);
                }
            }
            if (temp.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}