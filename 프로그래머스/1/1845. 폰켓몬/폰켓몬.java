import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        answer = Math.min(answer, set.size());
        return answer;
    }
}