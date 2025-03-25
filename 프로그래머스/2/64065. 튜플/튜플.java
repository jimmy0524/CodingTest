import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        for (String str : arr) {
            for (String str2 : str.split(",")) {
                int num = Integer.parseInt(str2);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
            .mapToInt(entry -> entry.getKey())
            .toArray();
    }
}