class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        boolean answer = true;
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}