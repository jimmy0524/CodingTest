import java.util.*;

class Solution {
    public String solution(String p) {
        return change(p); 
    }
    public String change(String p) {
        if (p.isEmpty()) {
            return "";
        }
         int count = 0;
        int index = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;

            if (count == 0) {
                index = i;
                break;
            }
        }
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (isCorrect(u)) { //올바름
            return u + change(v);
        } else {
            StringBuilder sb = new StringBuilder();
                    sb.append('(');
                    sb.append(change(v));
                    sb.append(')');
                    String temp = u.substring(1, index);
                    for (int k = 0; k < temp.length(); k++) {
                        if (temp.charAt(k) == '(') {
                            sb.append(')');
                        } else {
                            sb.append('(');
                        }
                    }
                    return sb.toString();
                }
    }
    public boolean isCorrect(String str) { //올바른지
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}