import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        for (int c : course) {
            for (String s : orders) {
               char[] arr = s.toCharArray();
                Arrays.sort(arr);
               dfs(0, 0, arr, c, new StringBuilder());      
            }
            List<String> keySet = new ArrayList<>(map.keySet());
                    keySet.sort((a, b) -> {return map.get(b) - map.get(a);});
                    if (!keySet.isEmpty() && map.get(keySet.get(0)) >= 2) {
                       result.add(keySet.get(0));
                        int tempCount = map.get(keySet.get(0));
                        System.out.println("tempCount : " + tempCount);
                        for (int j = 1; j < keySet.size(); j++) {
                            
                                System.out.println("keySet.get(j) : " + keySet.get(j));
                            System.out.println("map.get(keySet.get(j)" + map.get(keySet.get(j)));
                            if (map.get(keySet.get(j)) == tempCount) {
                                    result.add(keySet.get(j));
                                }
                        }
                    }
            map.clear();
            keySet.clear();
        }
        
        Collections.sort(result);
        return result.stream().toArray(String[]::new);
    }
    
    public void dfs(int index, int count, char[] arr, int c, StringBuilder sb) {
        if (c == count) {
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            System.out.println("s : " + s +  map.get(s));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(i + 1, count + 1, arr, c, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}