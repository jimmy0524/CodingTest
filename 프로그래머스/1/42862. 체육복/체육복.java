import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(reserve);
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        
        for (int r : reserve) {
            if (lostList.contains(r)) {
                lostList.remove(Integer.valueOf(r));
                reserveList.remove(Integer.valueOf(r));
            }
        }
        for (Integer r : reserveList) {
            if (lostList.contains(r - 1)) {
                lostList.remove(Integer.valueOf(r - 1));
                continue;
            }
            
            if (lostList.contains(r + 1)) {
                lostList.remove(Integer.valueOf(r + 1));
                continue;
            }
        }
        
        return answer - lostList.size();
    }
}