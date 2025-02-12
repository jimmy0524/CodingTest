import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int answer = nums.length / 2; 
        HashSet<Integer> hashSet = new HashSet<>(); 
        for (int num : nums) {
            hashSet.add(num);
        }
        
        answer = Math.min(answer, hashSet.size());
        
        return answer;
    }
}