import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] str = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 0 && (str[i].charAt(0) > '9' || str[i].charAt(0) < '0')) { //숫자가 아니면
                str[i] = Character.toUpperCase(str[i].charAt(0)) + str[i].substring(1);
            }
            sb.append(str[i]);
            if (i < str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}