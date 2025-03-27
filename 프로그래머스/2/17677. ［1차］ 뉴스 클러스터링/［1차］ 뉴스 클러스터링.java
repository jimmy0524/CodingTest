import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            if (temp.matches("^[a-z]*$")) {
                arr1.add(temp);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
             String temp = str2.substring(i, i + 2);
            if (temp.matches("^[a-z]*$")) {
                arr2.add(temp);
            }
        }
        
        int count = 0; //교집합
        ArrayList<String> copy = new ArrayList<>(arr1);
        
        for (String s : copy) {
            if (arr2.contains(s)) {
                count++;
                arr1.remove(s);
                arr2.remove(s);
            }
        }
        
        
        if (arr1.size() == 0 && arr2.size() == 0) {
            return 65536;
        } else {
            return (int) ((double) count / (count + arr1.size() + arr2.size()) * 65536);
        }
    }
}