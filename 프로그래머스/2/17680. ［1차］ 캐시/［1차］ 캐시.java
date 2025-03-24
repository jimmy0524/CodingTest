import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> arr = new ArrayList<>();
        int answer = 0;
        if (cacheSize == 0) {
            return 5 * cities.length;
        } 
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
            if (arr.contains(cities[i])) {
                answer++;
                int index = arr.indexOf(cities[i]);
                arr.remove(index);
                arr.add(cities[i]);
            } else {
                if (arr.size() >= cacheSize) {
                    arr.remove(0);
                }
                arr.add(cities[i]);
                answer += 5;
            } 
        }
        return answer;
    }
}