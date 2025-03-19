import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{') {
                    stack.push(s.charAt(j));
                }
                if (s.charAt(j) == ')') {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
                
                if (s.charAt(j) == ']') {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
                
                if (s.charAt(j) == '}') {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            
            if (check && stack.isEmpty()) {
                answer ++;
            }
            
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}