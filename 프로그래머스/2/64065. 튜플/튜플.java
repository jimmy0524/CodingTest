import java.util.*;

class Solution {
    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        Arrays.sort(arr, (a,b) -> {return a.length() - b.length();});
        for (String str : arr) {
            for (String str2 : str.split(",")) {
                set.add(Integer.parseInt(str2));
            }
        }
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}