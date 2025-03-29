import java.util.*;

class Solution {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> arr = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        Collections.sort(arr);
        
        if (arr.get(0).equals("")) {
            arr.remove(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(word)) {
                answer = i + 1;
            }
        }

        return answer;
    }
    
    public void dfs(String temp, int index) {
        if (index == 5) {
            arr.add(temp);
            return;
        }
        
        if (temp.length() >= 1) {
            arr.add(temp);
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(temp + alpha[i], index + 1);
        }
    }
}